package by.bsu.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val EXTRA_NUMBER = "by.bsu.number"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var receivedMassage = intent.getStringExtra(EXTRA_NUMBER)
        val textView = findViewById<TextView>(R.id.textView).apply {
            if(receivedMassage == null){
                receivedMassage = "0"
            }
            text = receivedMassage
        }
        var score = receivedMassage.toInt()

        val editTextNumberView = findViewById<EditText>(R.id.editTextNumber)

        val buttonOK = findViewById<Button>(R.id.button_ok)
        buttonOK.setOnClickListener {
            val massageNumber = editTextNumberView.text.toString()

            if(massageNumber == ""){
                return@setOnClickListener
            }else {
                score += massageNumber.toInt()
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra(EXTRA_NUMBER, score.toString())
                }
                startActivity(intent)
            }
        }
    }
}
