package com.example.flexboxdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val rv = findViewById<RecyclerView>(R.id.rvImage)
        val adapter = ImageAdapter()
        val flexbox = FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
        }
        rv.apply {
            layoutManager = flexbox
            this.adapter = adapter
        }
        rv.adapter = adapter
        adapter.addData(listOf("0", "1", "1", "2", "1", "1", "0", "1", "0", "2", "1", "0", "0"))
    }
}