package by.bsu.lab_3

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var toastService: ToastService ? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, ToastService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //val intent = Intent(this, ToastService::class.java)
        val textView = findViewById<TextView>(R.id.massage)
        return when (item.itemId) {
            R.id.five_seconds -> {
                textView.text = getString(R.string.five_sec)
                toastService?.getCurrentTimeSeconds(5000)
                true
            }
            R.id.ten_seconds -> {
                textView.text = getString(R.string.ten_sec)
                toastService?.getCurrentTimeSeconds(10000)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private val serviceConnection = object : ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            val binder = p1 as ToastService.ToastBinder
            toastService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isBound){
            unbindService(serviceConnection)
        }
    }
}