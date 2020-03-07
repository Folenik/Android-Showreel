package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.activity_bitmaps.*


class BitmapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmaps)

        bitmapDecodeAndSetImageView()
    }

    private fun bitmapDecodeAndSetImageView() {
        val bitmapImage = BitmapFactory.decodeResource(baseContext.resources, R.drawable.flower)
        Log.i("bitmap height", bitmapImage.height.toString())
        Log.i("bitmap width", bitmapImage.width.toString())
        bitmap_imageview.setImageBitmap(bitmapImage)

        Log.i("imageview height", bitmap_imageview.height.toString())
        Log.i("imageview width", bitmap_imageview.width.toString())
    }

    private fun scaleBitmap(bitmap: Bitmap, scale: Double): Bitmap {
        val height = (bitmap_imageview.height * scale).toInt()
        val width = (bitmap_imageview.width * scale).toInt()

        Log.i("bitmap scaled height", height.toString())
        Log.i("bitmap scaled width", width.toString())

        return Bitmap.createScaledBitmap(bitmap, height, width, false)
    }

    @Suppress("UNUSED_PARAMETER")
    fun scaleUp(view: View) {
        val bitmap = bitmap_imageview.drawable as BitmapDrawable
        val scaledBitmap = scaleBitmap(bitmap.bitmap, 1.1)
        bitmap_imageview.setImageBitmap(scaledBitmap)

        Log.i("imageview height", bitmap_imageview.height.toString())
        Log.i("imageview width", bitmap_imageview.width.toString())
    }

    @Suppress("UNUSED_PARAMETER")
    fun scaleDown(view: View) {
        val bitmap = bitmap_imageview.drawable as BitmapDrawable
        bitmap_imageview.setImageBitmap(scaleBitmap(bitmap.bitmap, 0.9))

        Log.i("imageview scaled height", bitmap_imageview.height.toString())
        Log.i("imageview scaled width", bitmap_imageview.width.toString())
    }

    @Suppress("UNUSED_PARAMETER")
    fun invertColors(view: View) {
        val bitmap = bitmap_imageview.drawable as BitmapDrawable
        val mutableBitmap = bitmap.bitmap.copy(Bitmap.Config.ARGB_8888, true)
        for (i in 0 until bitmap_imageview.width step 1) {
            for (j in 0 until bitmap_imageview.height step 1) {
                val pixelColorIntValue = mutableBitmap.getPixel(j,i)

                val red: Int = pixelColorIntValue shr 16 and 0xFF
                val green: Int = pixelColorIntValue shr 8 and 0xFF
                val blue: Int = pixelColorIntValue shr 0 and 0xFF
                val invertedRed = 255 - red
                val invertedGreen = 255 - green
                val invertedBlue = 255 - blue

                val invertedColor: Int = Color.rgb(invertedRed, invertedGreen, invertedBlue)

                mutableBitmap.setPixel(j, i, invertedColor)
            }
        }
        bitmap_imageview.setImageBitmap(mutableBitmap)
    }

    @Suppress("UNUSED_PARAMETER")
    fun grayScale(view: View) {
        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        val filter = ColorMatrixColorFilter(matrix)
        bitmap_imageview.colorFilter = filter
    }

    @Suppress("UNUSED_PARAMETER")
    fun resetImg(view: View) {
        bitmapDecodeAndSetImageView()
        bitmap_imageview.colorFilter = null
    }

    fun intent(context: Context): Intent {
        return Intent(context, BitmapsActivity::class.java)
    }
}