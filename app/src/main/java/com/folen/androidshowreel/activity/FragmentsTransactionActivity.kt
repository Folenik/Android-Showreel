package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.folen.androidshowreel.R
import com.folen.androidshowreel.base.BaseActivity
import com.folen.androidshowreel.fragment.SimpleFragment
import kotlinx.android.synthetic.main.activity_fragments_transactions.*


class FragmentsTransactionActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_transactions)

        button_add.setOnClickListener {
            var simpleFragment = SimpleFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragments_layout, simpleFragment).commit()
        }

        button_remove.setOnClickListener {
            try {
                supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentById(R.id.fragments_layout)!!).commit()
            } catch (e: NullPointerException) {
                Toast.makeText(this, getString(R.string.no_fragments), LENGTH_LONG).show()
            }
        }

        button_replace.setOnClickListener {
            var simpleFragment = SimpleFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragments_layout, simpleFragment).commit()
        }

        button_add_bs.setOnClickListener {
            var simpleFragment = SimpleFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragments_layout, simpleFragment).addToBackStack(null).commit()
        }

        button_replace_bs.setOnClickListener {
            var simpleFragment = SimpleFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragments_layout, simpleFragment).addToBackStack(null).commit()
        }

        button_pop_bs.setOnClickListener {
            supportFragmentManager.popBackStack()
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, FragmentsTransactionActivity::class.java)
    }
}