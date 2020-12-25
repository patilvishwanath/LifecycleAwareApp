package com.vp.lifecycleawareapp

import android.app.Application
import android.content.Context
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by Vishwanath Patil on 25/12/20.
 */
class UsingLifeCycle(context: Application, lifecycleOwner: LifecycleOwner) : LifecycleObserver {

    private var isStart=false
    private val lifecycle = lifecycleOwner.lifecycle
    init {
        lifecycle.addObserver(this)
    }

    val timer: CountDownTimer = object : CountDownTimer(60000, 3000) {
        override fun onFinish() {
            if (lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED))
                Toast.makeText(context, "Finis", Toast.LENGTH_SHORT).show()
        }

        override fun onTick(p0: Long) {
            if (lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED))
                Toast.makeText(context, p0.toString(), Toast.LENGTH_SHORT).show()

        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer() {
        if(!isStart) {
            timer.start()
            isStart = true;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cancelTimer() {
        timer.cancel()
    }

}