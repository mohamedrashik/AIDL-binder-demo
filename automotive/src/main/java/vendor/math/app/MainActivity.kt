package vendor.math.app

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import vendor.math.IMathAreaCalculator
import vendor.math.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var service: IMathAreaCalculator? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent("vendor.math.service")

        intent.setClassName("vendor.math.service", "vendor.math.service.MathAreaService")
        if (!super.bindService(intent, connection, BIND_AUTO_CREATE)) {
            Log.w(TAG, "Failed to bind to Math service");
        }
        binding.buttonSquare.setOnClickListener(listener)
        binding.buttonRectangle.setOnClickListener(listener)
        binding.buttonTriangle.setOnClickListener(listener)
        binding.buttonCirlce.setOnClickListener(listener)
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {

            service = IMathAreaCalculator.Stub.asInterface(p1)
            Log.d(TAG, "onServiceConnected ${service?.serviceName}")
            binding.title.text = service?.serviceName
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected")
        }
    }

    private val listener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            when (view?.id) {
                binding.buttonSquare.id -> binding.textScore.text =
                    "${service?.calculateSquareArea(2)}"

                binding.buttonRectangle.id -> binding.textScore.text =
                    "${service?.calculateRectangleArea(2, 5)}"

                binding.buttonTriangle.id -> binding.textScore.text =
                    "${service?.calculateTriangleArea(2, 2)}"

                binding.buttonCirlce.id -> binding.textScore.text =
                    "${service?.calculateCircleArea(2)}"
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        service = null
    }

    companion object {
        const val TAG = "MathService"
    }
}