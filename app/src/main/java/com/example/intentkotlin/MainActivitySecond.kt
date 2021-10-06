package com.example.intentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivitySecond : AppCompatActivity() {
    private var textView1: TextView?=null
    private var textView2:TextView?=null
    private var textView3:TextView?=null
    private var textView4:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second)
        textView1 = findViewById(R.id.text1)
        textView2 = findViewById(R.id.text2)
        textView3 = findViewById(R.id.text3)
        textView4 = findViewById(R.id.text4)
        val intent = intent
        val result1 = intent.getStringExtra("result1").toString()
        val result2 = intent.getStringExtra("result2").toString()
        val result3 = intent.getStringExtra("result3").toString()
        val result4 = intent.getStringExtra("result4").toString()
        textView1!!.text = result1
        textView2!!.text = result2
        textView3!!.text = result3
        textView4!!.text = result4
    }
}
