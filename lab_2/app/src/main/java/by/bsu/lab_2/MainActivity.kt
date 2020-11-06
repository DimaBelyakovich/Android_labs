package by.bsu.lab_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewSecond = findViewById<TextView>(R.id.textViewSecond)
        textViewSecond.text = getString(R.string.activity_name_main)

        val scoreView = findViewById<TextView>(R.id.textViewMain)

        val button = findViewById<Button>(R.id.buttonOk)
        button.setOnClickListener{
            val editText = findViewById<EditText>(R.id.editText)
            if(editText.text.isNotEmpty()){
                val score = scoreView.text.toString().toInt()
                var sum = score + editText.text.toString().toInt()

                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra(EXTRA_SUM, sum)
                }

                editText.text.clear()
                startActivityForResult(intent, REQUEST_CODE)

            }else{
                Toast.makeText(this, R.string.empty_string, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val textView = findViewById<TextView>(R.id.textViewMain)
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            textView.text = data?.getIntExtra(EXTRA_SUM, 0).toString()
        }
    }

    companion object {
        const val EXTRA_SUM = "com.example.lab1.SUM"
        const val REQUEST_CODE = 7
    }
}

