package com.example.griffindetector

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultName = findViewById<TextView>(R.id.result_name)
        val resultImage = findViewById<ImageView>(R.id.result_image)
        val btnRetry = findViewById<Button>(R.id.btn_retry)

        val result = intent.getStringExtra("PERSONAGGIO") ?: "PETER"

        resultName.text = result

        when (result) {
            "PETER" -> resultImage.setImageResource(R.drawable.peter)
            "STEWIE" -> resultImage.setImageResource(R.drawable.stewie)
            "QUAGMIRE" -> resultImage.setImageResource(R.drawable.quagmire)
            else -> resultImage.setImageResource(R.drawable.peter)
        }

        btnRetry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}