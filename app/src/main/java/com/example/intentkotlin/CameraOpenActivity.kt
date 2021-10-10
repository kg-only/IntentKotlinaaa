package com.example.intentkotlin

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

private const val REQUEST_CODE_CAMERA = 100
private const val REQUEST_CODE_CAPTURE = 1


class CameraOpenActivity : AppCompatActivity() {
    private var textView1: TextView? = null
    private var textView2: TextView? = null
    private var textView3: TextView? = null
    private var textView4: TextView? = null
    private var btnCamera: Button? = null
    private var cameraImageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_open)

        textView1 = findViewById(R.id.text1)
        textView2 = findViewById(R.id.text2)
        textView3 = findViewById(R.id.text3)
        textView4 = findViewById(R.id.text4)
        btnCamera = findViewById(R.id.btnCamera)
        cameraImageView = findViewById(R.id.cameraImageView)
        val intent = intent
        val result1 = intent.getStringExtra("result1").toString()
        val result2 = intent.getStringExtra("result2").toString()
        val result3 = intent.getStringExtra("result3").toString()
        val result4 = intent.getStringExtra("result4").toString()
        textView1!!.text = result1
        textView2!!.text = result2
        textView3!!.text = result3
        textView4!!.text = result4


        btnCamera!!.setOnClickListener {
            cameraPermission()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_CAPTURE) {
                if (data != null && data.extras != null) {
                    val bitmap = data.extras!!.get("data")
                    cameraImageView!!.setImageBitmap(bitmap as Bitmap?)
                }
            }
        }
    }

    fun cameraPermission() {
        val permission = Manifest.permission.CAMERA
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            showCamera()
        } else {
            requestCameraPermission()
        }
    }

    private fun showCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CODE_CAPTURE)
    }

    private fun requestCameraPermission() {
        val permissions = arrayOf(Manifest.permission.CAMERA)
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_CAMERA)
    }
}
