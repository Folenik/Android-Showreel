package com.folen.androidshowreel.activity

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import java.util.*
import kotlin.collections.ArrayList

class DialogsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowSimpleDialog(view: View) {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(getString(R.string.alert_give_money_title))
            setMessage(getString(R.string.alert_give_money_message))
            setPositiveButton(getString(R.string.agree), DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(applicationContext, getString(R.string.agree) + "d", LENGTH_SHORT).show()
            })
            setNegativeButton(getString(R.string.disagree), DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(applicationContext, getString(R.string.disagree) + "d", LENGTH_SHORT).show()
            })
            show()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowListDialog(view: View) {
        val cars = arrayOf("Audi", "BMW", "Citroen", "Peugeot", "Kia")
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(getString(R.string.alert_list_item))
            setItems(cars) { _, which ->
                Toast.makeText(applicationContext, cars[which], LENGTH_SHORT).show()

            }
            setNegativeButton(getString(R.string.dismiss), null)
            show()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowMultichoiceDialog(view: View) {
        val perks = arrayOf("Clever", "Handsome", "Muscular")
        val perkList = ArrayList<Int>()
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(getString(R.string.alert_multiple_list_item))
            setMultiChoiceItems(perks, null) { _, which, isChecked ->
                if (isChecked) {
                    perkList.add(which)
                } else if (perkList.contains(which)) {
                    perkList.remove(Integer.valueOf(which))
                }
            }
            setPositiveButton(getString(R.string.ok), DialogInterface.OnClickListener { _, _ ->
                val perkListStrings = ArrayList<String>()

                for (i in perkList.indices) {
                    perkListStrings.add(perks[perkList[i]])
                }

                Toast.makeText(applicationContext, "You are: " + Arrays.toString(perkListStrings.toTypedArray()), LENGTH_SHORT).show()
            })
            show()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowEditTextDialog(view: View) {
        val builder = AlertDialog.Builder(this)
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_edittext, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.edit_text)

        with(builder) {
            setTitle(getString(R.string.alert_edittext))
            setView(dialogLayout)
            setPositiveButton(getString(R.string.ok)) { _, _ ->
                Toast.makeText(applicationContext,
                        editText.text.toString(),
                        LENGTH_SHORT).show()
            }
            show()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowCustomDialog(view: View) {
        val dialog = Dialog(this)

        with(dialog) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dialog_custom)
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        dialog.show()
    }

    fun intent(context: Context): Intent {
        return Intent(context, DialogsActivity::class.java)
    }
}