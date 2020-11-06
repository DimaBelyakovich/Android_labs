package by.bsu.lab_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import by.bsu.lab_2.MainActivity.Companion.EXTRA_SUM

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewSecond = findViewById<TextView>(R.id.textViewSecond)
        textViewSecond.text = getString(R.string.activity_name_second)

        val textView = findViewById<TextView>(R.id.textViewMain).apply {

            text = intent.getIntExtra(EXTRA_SUM,0).toString()
        }

        val editText = findViewById<EditText>(R.id.editText)

        val button = findViewById<Button>(R.id.buttonOk)
        button.setOnClickListener{
            if(editText.text.isNotEmpty()){
                var sum = editText.text.toString().toInt() + textView.text.toString().toInt()

                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra(EXTRA_SUM, sum)
                }

                setResult(Activity.RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this, R.string.empty_string, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }
    }
}

