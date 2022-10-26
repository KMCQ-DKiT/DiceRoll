package com.example.diceroll

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Stats : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)


        val homeButton: Button = findViewById(R.id.button6)
        homeButton.setOnClickListener { finish() }


        val totalRollMessage = intent.getIntExtra(totalRollMessage, 0)
        val totalWinMessage = intent.getIntExtra(totalWinsMessage, 0)
        val totalLossMessage = intent.getIntExtra(totalLossMessage, 0)
        val winPercentageMessage = intent.getDoubleExtra(winPercentageMessage, 0.0)


        Log.d("SpinMessage", "$totalRollMessage")
        Log.d("SpinMessage", "$totalWinMessage")
        Log.d("SpinMessage", "$totalLossMessage")


        val textView = findViewById<TextView>(R.id.textView).apply {
            text = totalRollMessage.toString()
        }

        val winView = findViewById<TextView>(R.id.textView2).apply {
            text = totalWinMessage.toString()

        }

        val winrationView = findViewById<TextView>(R.id.textView3).apply {
            text = totalLossMessage.toString()
        }
        val winPercentage = findViewById<TextView>(R.id.textView4).apply {
            text = winPercentageMessage.toString()
        }

    }
}