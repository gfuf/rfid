package com.example.rfid

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.rfid.label.RfidLabelDetails


class MainActivity : AppCompatActivity() {
    private val rfids = listOf(RfidLabelDetails("1"), RfidLabelDetails("2"));


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init()
    {
        val adapter: ArrayAdapter<RfidLabelDetails> = ArrayAdapter<RfidLabelDetails>(this,  android.R.layout.simple_list_item_1, rfids)
        findViewById<ListView>(R.id.rfidList).setAdapter(adapter);
    }
}