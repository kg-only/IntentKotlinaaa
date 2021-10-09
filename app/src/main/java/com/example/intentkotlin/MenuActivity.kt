package com.example.intentkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuActivity : AppCompatActivity() {
    lateinit var bottom_navigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        bottom_navigation = findViewById(R.id.bottom_navigation)
        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.calculator -> {
                    openCalculatorActivity()
                    true
                }
                R.id.camera -> {
                    openCalculatorActivity()
                    true
                }
                R.id.weather -> {
                    openCalculatorActivity()
                    true
                }
                else -> false

            }
        }
    }
private fun openCalculatorActivity(activity: Activity){
    val intent = Intent(this, MainActivitySecond::class.java)
    startActivity(intent)
}

}

