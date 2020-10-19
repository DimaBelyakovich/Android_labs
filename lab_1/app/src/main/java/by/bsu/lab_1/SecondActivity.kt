package by.bsu.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val numberMassage = intent.getStringExtra(EXTRA_NUMBER)
        val textView = findViewById<TextView>(R.id.textView2).apply {
            text = "= $numberMassage"
        }

        val editText = findViewById<EditText>(R.id.editTextNumberDecimal2)

        var score = numberMassage.toInt()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val massage = editText.text.toString()
            if (massage == ""){
                return@setOnClickListener
            }else {
                score += massage.toInt()
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra(EXTRA_NUMBER, score.toString())
                }
                startActivity(intent)
            }
        }
    }

}