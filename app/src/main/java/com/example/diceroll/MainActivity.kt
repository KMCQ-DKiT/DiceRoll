package com.example.diceroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView


const val totalRollMessage = "Total Amount of Spins"
const val totalWinsMessage = "Total Amount of Wins"
const val totalLossMessage = "Total Amount of Loss"
const val winPercentageMessage = "Win Percentage"



class MainActivity : AppCompatActivity() {
    var totalRolls=0
    var totalWins=0
    var totalLoss=0
    var winPercentage=0.0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val helpButton: Button = findViewById(R.id.button3)
        helpButton.setOnClickListener {
            val intent = Intent(this, Help::class.java).apply{}
            startActivity(intent) }

        val statsButton: Button = findViewById(R.id.button4)

        statsButton.setOnClickListener {
            val intent2 = Intent(this, Stats::class.java).apply{
                putExtra(totalRollMessage,totalRolls)
                putExtra(totalWinsMessage, totalWins)
                putExtra(totalLossMessage, totalLoss)
                putExtra(winPercentageMessage, winPercentage)
            }
            startActivity(intent2)

        }

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
           rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        val diceRoll3 = dice.roll()


        val diceImage1: ImageView = findViewById(R.id.imageView1)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val diceImage3: ImageView = findViewById(R.id.imageView3)
        val winLose: ImageView = findViewById(R.id.imageViewLose)








        val drawableResource1 = when (diceRoll) {
            1 -> R.drawable.bird
            2 -> R.drawable.frog
            3 -> R.drawable.lion
            else -> {R.drawable.penguin}
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.bird
            2 -> R.drawable.frog
            3 -> R.drawable.lion
            else -> {R.drawable.penguin}
        }
        val drawableResource3 = when (diceRoll3) {
            1 -> R.drawable.bird
            2 -> R.drawable.frog
            3 -> R.drawable.lion
            else -> {R.drawable.penguin}
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
        diceImage3.setImageResource(drawableResource3)
        totalRolls +=1

        if(drawableResource1 == drawableResource2 && drawableResource2 == drawableResource3){
            winLose.setImageResource(R.drawable.you_win_red_rubber_stamp_over_white_background_86701663)

            totalWins +=1

        }
        else{
            winLose.setImageResource(R.drawable._60_f_131419939_uh5audnnojgivepfgweswogzmxbdugwe)
            totalLoss +=1
        }
        winPercentage = (((totalWins.toDouble() / totalRolls) * 100))

        Log.d(totalRollMessage, totalRolls.toString())
        Log.d(totalWinsMessage, totalWins.toString())
        Log.d(totalLossMessage, totalLoss.toString())
        Log.d(winPercentageMessage, winPercentage.toString())


//        val resultTextView: TextView = findViewById(R.id.textView4)
//        resultTextView.text = totalRolls.toString()
//        val resultTextView1: TextView = findViewById(R.id.textView5)
//        resultTextView1.text = totalWins.toString()
//        val resultTextView2: TextView = findViewById(R.id.textView6)
//        resultTextView2.text = totalLoss.toString()
    }


}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}




