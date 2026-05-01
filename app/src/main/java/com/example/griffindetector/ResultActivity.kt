package com.example.griffindetector

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getStringExtra("PERSONAGGIO") ?: "PETER"
        findViewById<TextView>(R.id.result_name).text = result

        findViewById<Button>(R.id.btn_retry).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Pulisce la cronologia
            startActivity(intent)
        }
    }
}