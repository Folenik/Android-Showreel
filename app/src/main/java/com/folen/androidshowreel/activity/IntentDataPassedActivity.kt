package com.folen.androidshowreel.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.model.ParcelableModel
import com.folen.androidshowreel.model.SerializableModel
import kotlinx.android.synthetic.main.activity_intent_data_passed.*


class IntentDataPassedActivity : AppCompatActivity() {

    lateinit var name: String
    lateinit var gender: String
    var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_data_passed)

        getParcelableData()
        getSerializableData()
    }

    private fun getParcelableData() {
        try {
            try {
                val parcelableArray: ArrayList<ParcelableModel> =
                        intent.extras?.getParcelableArrayList<ParcelableModel>("Parcelable") as ArrayList<ParcelableModel>

                data_passed_textview.text = getString(R.string.textview_data_passed,
                        parcelableArray[0].name,
                        parcelableArray[0].age,
                        parcelableArray[0].gender)
            } catch (e: TypeCastException) {
                Log.i("Error404", e.toString())
            }
        } catch (e: NullPointerException) {
            Log.i("Error404", e.toString())
        }
    }


    private fun getSerializableData() {
        try {
            try {
                @Suppress("UNCHECKED_CAST")
                val serializableArray = intent.extras?.getSerializable("Serializable") as ArrayList<SerializableModel>

                data_passed_textview.text = getString(R.string.textview_data_passed,
                        serializableArray[0].name,
                        serializableArray[0].age,
                        serializableArray[0].gender)
            } catch (e: TypeCastException) {
                Log.i("Error404", e.toString())
            }
        } catch (e: NullPointerException) {
            Log.i("Error404", e.toString())
        }
    }
}