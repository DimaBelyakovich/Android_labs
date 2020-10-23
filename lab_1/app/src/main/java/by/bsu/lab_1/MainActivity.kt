package by.bsu.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_NUMBER = "by.bsu.number"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var receivedMassage = intent.getStringExtra(EXTRA_NUMBER)

        if(receivedMassage == null) receivedMassage = "0"
        textView.text = receivedMassage

        var score = receivedMassage.toInt()

        button_ok.setOnClickListener {
            val massageNumber = editTextNumber.text.toString()
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
