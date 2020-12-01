package by.bsu.lab_3

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class ToastService: Service(){

    private val binder = ToastBinder()
    private var handler = Handler()
    private var runnable = Runnable {  }

    inner class ToastBinder : Binder(){
        fun getService() : ToastService{
            return this@ToastService
        }
    }

    fun getCurrentTimeSeconds(delay : Long){
        handler.removeCallbacks(runnable)
        handler.postDelayed(Runnable {
            handler.postDelayed(runnable, delay)
            Toast.makeText(this, SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US).format(Date()) + " " + delay, Toast.LENGTH_SHORT)
                .show()
        }.also { runnable = it }, delay)
    }


    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }
}