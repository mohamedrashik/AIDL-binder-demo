package vendor.math.service

import android.util.Log
import vendor.math.IMathAreaCalculator

class IMathAreaServiceImpl : IMathAreaCalculator.Stub() {
    override fun calculateSquareArea(side: Int): Int {
        val area = side * side
        Log.d(TAG, "calculateSquareArea: side=$side, area=$area")
        return area
    }

    override fun calculateRectangleArea(length: Int, width: Int): Int {
        val area = length * width
        Log.d(TAG, "calculateRectangleArea: length=$length, width=$width, area=$area")
        return area
    }

    override fun calculateTriangleArea(base: Int, height: Int): Int {
        val area = (base * height) / 2
        Log.d(TAG, "calculateTriangleArea: base=$base, height=$height, area=$area")
        return area
    }

    override fun calculateCircleArea(radius: Int): Int {
        val area = 3 * radius * radius // π ≈ 3 for integer math
        Log.d(TAG, "calculateCircleArea: radius=$radius, area=$area")
        return area
    }

    override fun getServiceName(): String {
        val name = "MathAreaCalculatorService"
        Log.d(TAG, "getServiceName: $name")
        return name
    }

    companion object{
        const val TAG = "MathService"
    }

}