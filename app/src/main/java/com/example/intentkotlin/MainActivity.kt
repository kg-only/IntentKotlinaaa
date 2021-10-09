package com.example.intentkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var btn: Button? = null
    private var editText1: EditText? = null
    private var editText2: EditText? = null
    private var editText3: EditText? = null
    private var editText4: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1 = findViewById(R.id.edittext1)
        editText2 = findViewById(R.id.edittext2)
        editText3 = findViewById(R.id.edittext3)
        editText4 = findViewById(R.id.edittext4)
        btn = findViewById(R.id.btnRegister)
        btn!!.setOnClickListener {
            if (editText1!!.text.length == 9){
                resultOfIntent()
            }else editText1!!.error = "Ошибка"

            if(editText3!!.text.toString() == editText4!!.text.toString()){
                resultOfIntent()
            }else editText4!!.error = "Пароли не совпадают"
        }
    }

    private fun resultOfIntent() {
        val result1 = editText1!!.text.toString()
        val result2 = editText2!!.text.toString()
        val result3 = editText3!!.text.toString()
        val result4 = editText4!!.text.toString()
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("result1", result1)
        intent.putExtra("result2", result2)
        intent.putExtra("result3", result3)
        intent.putExtra("result4", result4)
        startActivity(intent)
    }
}
