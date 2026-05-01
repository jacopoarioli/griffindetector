package com.example.griffindetector

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        findViewById<Button>(R.id.btn_scopri).setOnClickListener {
            // Lista di tutti i RadioGroup
            val groups = listOf(
                R.id.q1, R.id.q2, R.id.q3, R.id.q4, R.id.q5,
                R.id.q6, R.id.q7, R.id.q8, R.id.q9, R.id.q10
            )

            var pPeter = 0; var pStewie = 0; var pQuagmire = 0
            var rispostoATutto = true

            for (id in groups) {
                val group = findViewById<RadioGroup>(id)
                val selected = group.checkedRadioButtonId
                if (selected == -1) {
                    rispostoATutto = false
                    break
                }
                // Logica semplificata basata sull'ordine delle risposte
                when (findViewById<Button>(selected).text.toString()) {
                    // Questa è una logica dimostrativa basata sui caratteri
                    // In un'app reale useresti ID specifici
                }

                // Usiamo una logica di posizione per semplicità di calcolo
                val index = group.indexOfChild(findViewById(selected))
                when(index) {
                    0 -> pPeter++
                    1 -> pStewie++
                    2 -> pQuagmire++
                }
            }

            if (!rispostoATutto) {
                Toast.makeText(this, "Rispondi a tutte le domande!", Toast.LENGTH_SHORT).show()
            } else {
                val vincitore = if (pPeter >= pStewie && pPeter >= pQuagmire) "PETER"
                else if (pStewie >= pPeter && pStewie >= pQuagmire) "STEWIE"
                else "QUAGMIRE"

                // Aggiungiamo gli altri se vuoi variabilità (Meg, Chris, Herbert casuali per ora o basati su logica)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("PERSONAGGIO", vincitore)
                startActivity(intent)
            }
        }
    }
}