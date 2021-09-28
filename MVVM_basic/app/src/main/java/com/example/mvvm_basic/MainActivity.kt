package com.example.mvvm_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_basic.databinding.ActivityMainBinding
import com.example.mvvm_basic.DataModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AppViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding:ActivityMainBinding  = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        activityMainBinding.
//        activityMainBinding.executePendingBindings();

        activityMainBinding.lifecycleOwner = this
    }
}