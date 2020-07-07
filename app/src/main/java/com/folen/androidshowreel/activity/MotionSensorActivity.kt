package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.activity_motion_sensor.*

class MotionSensorActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var mSensorManager: SensorManager
    private lateinit var mSensor: Sensor
    private val sensorNamesArray = arrayOf("Accelerometer", "Gyroscope", "Linear acceleration", "Rotation vector", "Step counter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_sensor)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensor_name.text = sensorNamesArray[0]

        radio_group_sensors.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                R.id.sensor_accelerometer -> initSensors(Sensor.TYPE_ACCELEROMETER, sensorNamesArray[0])
                R.id.sensor_gyroscope -> initSensors(Sensor.TYPE_GYROSCOPE, sensorNamesArray[1])
                R.id.sensor_acceleration -> initSensors(Sensor.TYPE_LINEAR_ACCELERATION, sensorNamesArray[2])
                R.id.sensor_rotation_vector -> initSensors(Sensor.TYPE_ROTATION_VECTOR, sensorNamesArray[3])
                R.id.sensor_step_counter -> initSensors(Sensor.TYPE_STEP_COUNTER, sensorNamesArray[4])
            }
        }
    }

    private fun initSensors(whichSensor: Int, sensorName: String) {
        sensor_name.text = sensorName
        mSensorManager.unregisterListener(this)

        try {
            mSensor = mSensorManager.getDefaultSensor(whichSensor)
            mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL)
        } catch (e: IllegalStateException) {
            sensor_value1.text = getString(R.string.sensor_no_sensor)
            sensor_value2.text = getString(R.string.sensor_no_sensor)
            sensor_value3.text = getString(R.string.sensor_no_sensor)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        sensor_value1.text = event!!.values[0].toString()
        sensor_value2.text = event!!.values[1].toString()
        sensor_value3.text = event!!.values[2].toString()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //nothing
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun intent(context: Context): Intent {
        return Intent(context, MotionSensorActivity::class.java)
    }
}