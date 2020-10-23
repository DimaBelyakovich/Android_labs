package by.bsu.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val numberMassage = intent.getStringExtra(EXTRA_NUMBER)
        textView2.text = numberMassage
        var score = numberMassage.toInt()
        button.setOnClickListener{
            val massage = editTextNumber2.text.toString()
            if (massage == "") return@setOnClickListener
            else {
                score += massage.toInt()
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra(EXTRA_NUMBER, score.toString())
                }
                startActivity(intent)
            }
        }
    }

}