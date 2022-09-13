package br.com.bruno.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.com.bruno.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.btnRollDice)
        button.text = "Jogue o dado"
        button.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val diceNumber : TextView = findViewById(R.id.tvText)
        diceNumber.text = (Random.nextInt(6)+1).toString()
    }

}