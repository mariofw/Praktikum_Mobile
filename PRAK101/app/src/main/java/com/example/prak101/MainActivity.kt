package com.example.prak101

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollbutton: Button = findViewById(R.id.button1)
        rollbutton.setOnClickListener {rollDice()}
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll1 = dice.roll1()
        val diceRoll2 = dice.roll1()
        val diceGambar: ImageView = findViewById(R.id.gambar1)
        val diceGambar2: ImageView = findViewById(R.id.gambar2)

        val GambarResource = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val GambarResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceGambar.setImageResource(GambarResource)
        diceGambar2.setImageResource(GambarResource2)
        diceGambar.contentDescription = diceRoll1.toString()
        diceGambar2.contentDescription = diceRoll2.toString()

        if (diceRoll1 == diceRoll2) {
            val toast = Toast.makeText(this, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast2 = Toast.makeText(this, "Anda belum beruntung!", Toast.LENGTH_SHORT)
            toast2.show()
        }
    }
}
class Dice(private val numSides: Int) {
    fun roll1(): Int {
        return (1..numSides).random()
    }

    fun roll2(): Int {
        return (1..numSides).random()
    }
}
