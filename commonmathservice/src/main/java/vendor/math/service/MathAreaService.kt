package vendor.math.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MathAreaService : Service() {

    private lateinit var mMathAreaService: IMathAreaServiceImpl

    override fun onCreate() {
        super.onCreate()
        this.mMathAreaService = IMathAreaServiceImpl()
        Log.d(TAG, "onCreate()'ed")
    }
    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind()'ed")
        return this.mMathAreaService
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "unBind()'ed")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy()'ed")
        super.onDestroy()
    }
    companion object{
        const val TAG = "MathService"
    }
}