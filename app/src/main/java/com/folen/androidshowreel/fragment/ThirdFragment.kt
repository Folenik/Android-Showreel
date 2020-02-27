package com.folen.androidshowreel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.ListFragment
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.fragment_third.*


class ThirdFragment : ListFragment(), AdapterView.OnItemClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        third_fragment_tv.text = getString(R.string.textview_third_fragment)
        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(activity,
                R.array.Cars, android.R.layout.simple_list_item_1)
        listAdapter = adapter
        listView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(activity, getString(R.string.listview_item_position, position.toString()), Toast.LENGTH_SHORT).show()
    }
}