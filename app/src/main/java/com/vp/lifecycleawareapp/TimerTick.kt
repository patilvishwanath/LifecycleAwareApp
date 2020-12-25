package com.vp.lifecycleawareapp

import android.app.Application
import android.content.Context
import android.os.CountDownTimer
import android.widget.Toast

/**
 * Created by Vishwanath Patil on 25/12/20.
 */
class TimerTick(context: Application)  {


    val timer : CountDownTimer = object : CountDownTimer(60000,3000){
        override fun onFinish() {
           Toast.makeText(context,"Finis",Toast.LENGTH_SHORT).show()
        }

        override fun onTick(p0: Long) {
            Toast.makeText(context,p0.toString(),Toast.LENGTH_SHORT).show()

        }

    }

   fun startTimer() {
       timer.start()
   }

    fun cancelTimer() {
        timer.cancel()
    }

}