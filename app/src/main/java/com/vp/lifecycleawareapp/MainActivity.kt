package com.vp.lifecycleawareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
   // lateinit var timerTick: UsingLifeCycle
    lateinit var viewModel: UsingLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(UsingLiveData::class.java)
        viewModel.startTimer()


        viewModel.timeData.observe(this,object : Observer<String>{
            override fun onChanged(t: String?) {
                Toast.makeText(this@MainActivity, t, Toast.LENGTH_SHORT).show()
            }

        })

//         timerTick = UsingLifeCycle(application,this)
//        timerTick.startTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
       // timerTick.cancelTimer()
    }
}