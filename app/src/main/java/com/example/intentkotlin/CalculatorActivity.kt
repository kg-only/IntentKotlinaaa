package com.example.intentkotlin

import android.annotation.SuppressLint
import android.mtp.MtpObjectInfo
import android.os.Bundle
import android.telecom.PhoneAccount
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private var firstInput: TextView? = null
    private var signOutput: TextView? = null
    private var sign: String? = null
    private var value1: String? = null
    private var value2: String? = null
    private var t: String? = null
    private var num1: Double? = null
    private var num2: Double? = null
    private var result: Double? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        firstInput = findViewById(R.id.edit_text_first_input)
        signOutput = findViewById(R.id.action)

        val one = findViewById<Button>(R.id.one_btn)
        val two = findViewById<Button>(R.id.two_btn)
        val three = findViewById<Button>(R.id.three_btn)
        val four = findViewById<Button>(R.id.four_btn)
        val five = findViewById<Button>(R.id.five_btn)
        val six = findViewById<Button>(R.id.six_btn)
        val seven = findViewById<Button>(R.id.seven_btn)
        val eight = findViewById<Button>(R.id.eight_btn)
        val nine = findViewById<Button>(R.id.nine_btn)
        val zero = findViewById<Button>(R.id.zero_btn_btn)
        val plus = findViewById<Button>(R.id.plus_btn)
        val minus = findViewById<Button>(R.id.minus_btn)
        val division = findViewById<Button>(R.id.division_btn)
        val multiplication = findViewById<Button>(R.id.multiplication_btn)
        val equals = findViewById<Button>(R.id.equals_btn)
        val point = findViewById<Button>(R.id.point_btn)
        val clear = findViewById<Button>(R.id.clear_btn)
        val percent = findViewById<Button>(R.id.percent)
        val delete = findViewById<Button>(R.id.backspace_btn)
        val push = findViewById<Button>(R.id.push_btn)
/*
........................ЦИФРЫ........................
 */

        /*
........................ЦИФРЫ........................
 */one.setOnClickListener { firstInput!!.text.toString()  + "1"}

        two.setOnClickListener { firstInput!!.text.toString()  + "2"}
        three.setOnClickListener { firstInput!!.text.toString()  + "3"}
        four.setOnClickListener {firstInput!!.text.toString()  + "4" }
        five.setOnClickListener { firstInput!!.text.toString()  + "5" }
        six.setOnClickListener { firstInput!!.text.toString() + "6" }
        seven.setOnClickListener { firstInput!!.text.toString() + "7" }
        eight.setOnClickListener { firstInput!!.text.toString()  + "8" }
        nine.setOnClickListener { firstInput!!.text.toString()  + "9" }
        zero.setOnClickListener { firstInput!!.text.toString()  + "0" }
        push.setOnClickListener {
            signOutput!!.text = null
            signOutput!!.text.toString() + "ЦИФРЫ ЖМИ БЛЯТ!"
        }
        /*
          .........................ДЕЙСВТИЯ........................

         */


        /*
          .........................ДЕЙСВТИЯ........................

         */minus.setOnClickListener {
            sign = "-"
            value1 = firstInput!!.text.toString()
            firstInput!!.text = null
            signOutput!!.text = "-"
        }

        plus.setOnClickListener {
            sign = "+"
            value1 = firstInput!!.text.toString()
            firstInput!!.text = null
            signOutput!!.text = "+"
        }
        multiplication.setOnClickListener {
            sign = "x"
            value1 = firstInput!!.text.toString()
            firstInput!!.text = null
            signOutput!!.text = "x"
        }
        division.setOnClickListener {
            sign = "/"
            value1 = firstInput!!.text.toString()
            firstInput!!.text = null
            signOutput!!.text = "/"
        }

        percent.setOnClickListener {
            sign = "%"
            value1 = firstInput!!.text.toString()
            firstInput!!.text = null
            signOutput!!.text = "%"
        }
        point.setOnClickListener { firstInput!!.text.toString() + "." }

        equals.setOnClickListener {
            when {
                firstInput!!.text.toString() == "" -> {
                    firstInput!!.text = ""
                }
                sign != null -> {
                    value2 = firstInput!!.text.toString()
                    num1 = value1!!.toDouble()
                    num2 = value2!!.toDouble()
                    firstInput!!.text=null
                    when (getSign()) {
                        "+" -> {
                            firstInput!!.text=null
                            result = num1!! + num2!!
                            firstInput!!.text = result.toString() + ""
                            sign = null
                        }
                        "-" -> {
                            firstInput!!.text=null
                            result = num1!! - num2!!
                            firstInput!!.text = result.toString() + ""
                            sign = null
                        }
                        "/" -> {
                            firstInput!!.text=null
                            result = num1!! / num2!!
                            firstInput!!.text = result.toString() + ""
                            sign = null
                        }
                        "x" -> {
                            firstInput!!.text=null
                            result = num1!! * num2!!
                            firstInput!!.text = result.toString() + ""
                            sign = null
                        }
                        "%" -> {
                            firstInput!!.text=null
                            result = num1!! * num2!! / 100
                            firstInput!!.text = result.toString() + ""
                            sign = null
                        }
                        else -> {
                        }
                    }
                }
                else -> firstInput!!.text.toString()  + "Ошибка"
            }
        }
        clear.setOnClickListener {
            firstInput!!.text = null
            signOutput!!.text = null
        }
        delete.setOnClickListener {
            t = firstInput!!.text.toString()
            if (t!!.isEmpty()) {
                firstInput!!.text = ""
            } else {
                firstInput!!.text = t!!.substring(0, t!!.length - 1)
            }
        }

    }

    private fun getSign(): String? {
        return sign
    }
    @SuppressLint("SetTextI18n")
    private fun TextView.setText(){
        firstInput!!.text.toString() + "1"
    }
}


