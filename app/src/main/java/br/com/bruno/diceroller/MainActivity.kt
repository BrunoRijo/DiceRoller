package br.com.bruno.diceroller

import android.graphics.Color
import android.opengl.GLES30
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import br.com.bruno.diceroller.databinding.ActivityMainBinding
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar : CircularProgressBar = findViewById(R.id.circularProgressBar)
        val button : Button = findViewById(R.id.btnRollDice)
        button.setOnClickListener {
            progressBar.progress = 0f
            animationBarProgress(progressBar)
        }

    }

    private fun animationBarProgress(progressBar : CircularProgressBar){
        progressBar.apply {
            setProgressWithAnimation(10f, 250)
        }
        rollDice()
    }

    private fun rollDice() {
        val diceNumber : ImageView = findViewById(R.id.image_dice)
        val drawableResource = when(Random.nextInt(6)+1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceNumber.setImageResource(drawableResource)
    }
}