package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.model.ParcelableModel
import com.folen.androidshowreel.model.SerializableModel
import kotlinx.android.synthetic.main.activity_intent_data_pass.*


class IntentDataPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_data_pass)

        button_pass_parcelable_data.setOnClickListener {
            if (gender_male.isChecked) {
                createParcelableModelPutExtraAndStartNewActivity(et_name.text.toString(), et_age.text.toString().toInt(), "male")
            } else {
                createParcelableModelPutExtraAndStartNewActivity(et_name.text.toString(), et_age.text.toString().toInt(), "female")
            }
        }

        button_pass_serializable_data.setOnClickListener {
            if (gender_male.isChecked) {
                createSerializableModelPutExtraAndStartNewActivity(et_name.text.toString(), et_age.text.toString().toInt(), "male")
            } else {
                createSerializableModelPutExtraAndStartNewActivity(et_name.text.toString(), et_age.text.toString().toInt(), "female")
            }
        }
    }

    private fun createParcelableModelPutExtraAndStartNewActivity(name: String, age: Int, gender: String) {
        val intent = Intent(baseContext, IntentDataPassedActivity::class.java)
        val parcelableModel = ParcelableModel(name, age, gender)
        intent.putExtra("Parcelable", parcelableModel)
        intent.putParcelableArrayListExtra("Parcelable", arrayListOf(parcelableModel))
        startActivity(intent)
    }

    private fun createSerializableModelPutExtraAndStartNewActivity(name: String, age: Int, gender: String) {
        val intent = Intent(baseContext, IntentDataPassedActivity::class.java)
        val serializableModel = SerializableModel()
        serializableModel.name = name
        serializableModel.age = age
        serializableModel.gender = gender

        Log.i("Serializable model", serializableModel.age.toString())

        intent.putExtra("Serializable", arrayListOf(serializableModel))
        startActivity(intent)
    }

    fun intent(context: Context): Intent {
        return Intent(context, IntentDataPassActivity::class.java)
    }
}