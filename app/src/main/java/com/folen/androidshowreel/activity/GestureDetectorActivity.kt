package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.folen.androidshowreel.R
import com.folen.androidshowreel.base.BaseActivity
import com.folen.androidshowreel.util.Const.GESTURE_LOG
import com.squareup.seismic.ShakeDetector


class GestureDetectorActivity : BaseActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ShakeDetector.Listener {

    private lateinit var gDetector: GestureDetectorCompat
    private lateinit var sDetector: ShakeDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture_detector)

        initDetectors()
    }

    private fun initDetectors() {
        gDetector = GestureDetectorCompat(this, this)
        gDetector.setOnDoubleTapListener(this)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sDetector = ShakeDetector(this)
        sDetector.start(sensorManager)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (gDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }
//        ** CAN ALSO USE MOTION EVENT LIKE THIS **
//        return when (event.actionMasked) {
//            MotionEvent.ACTION_DOWN -> {
//                Log.d(GESTURE_LOG, getString(R.string.gesture_action_down))
//                true
//            }
//            MotionEvent.ACTION_MOVE -> {
//                Log.d(GESTURE_LOG, getString(R.string.gesture_action_move))
//                true
//            }
//            MotionEvent.ACTION_UP -> {
//                Log.d(GESTURE_LOG, getString(R.string.gesture_action_up))
//                true
//            }
//            MotionEvent.ACTION_CANCEL -> {
//                Log.d(GESTURE_LOG, getString(R.string.gesture_action_cancel))
//                true
//            }
//            MotionEvent.ACTION_OUTSIDE -> {
//                Log.d(GESTURE_LOG, getString(R.string.gesture_action_outside))
//                true
//            }
//            else -> super.onTouchEvent(event)
//        }
//       *******************************************

    override fun onShowPress(e: MotionEvent?) {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_show_press))
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_single_tap_up))
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_down))
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_fling))
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_scroll))
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_long_press))
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_double_tap))
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_double_tap_event))
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        Log.d(GESTURE_LOG, getString(R.string.gesture_action_single_tap_confirmed))
        return true
    }

    override fun hearShake() {
        val newIntent = Intent(this, DeathToolsActivity::class.java)
        startActivity(newIntent)
    }

    fun intent(context: Context): Intent {
        return Intent(context, GestureDetectorActivity::class.java)
    }
}