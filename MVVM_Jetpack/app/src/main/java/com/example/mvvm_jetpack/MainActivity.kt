package com.example.mvvm_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mvvm_jetpack.ui.theme.MVVM_JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MVVM_JetpackTheme {
                LoginApp()
            }

        }
    }
}
