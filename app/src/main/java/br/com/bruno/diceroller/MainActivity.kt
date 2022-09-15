package br.com.bruno.diceroller

import android.annotation.SuppressLint
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

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRollDice.setOnClickListener {
            animationBarProgress()
        }
    }

    private fun animationBarProgress(){
        binding.circularProgressBar.progress = 0f
        binding.circularProgressBar.apply {
            setProgressWithAnimation(10f, 250)
        }
        rollDice()
    }

    private fun rollDice() {
        binding.imageDice.setImageResource(when(Random.nextInt(6)+1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })
    }
}