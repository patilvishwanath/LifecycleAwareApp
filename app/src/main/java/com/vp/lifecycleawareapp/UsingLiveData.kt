package com.vp.lifecycleawareapp

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Vishwanath Patil on 25/12/20.
 */
class UsingLiveData:ViewModel() {

    val timeData= MutableLiveData<String>()

     private var timer : CountDownTimer

    init {
         timer  = object : CountDownTimer(60000,3000){
            override fun onFinish() {
                // Toast.makeText(context,"Finis", Toast.LENGTH_SHORT).show()
                timeData.postValue("Finish")
            }

            override fun onTick(p0: Long) {
                // Toast.makeText(context,p0.toString(), Toast.LENGTH_SHORT).show()
                timeData.postValue("$p0")
            }

        }


        timer.start()
    }



    fun startTimer() {

    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }


}