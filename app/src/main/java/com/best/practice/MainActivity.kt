package com.best.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.best.practice.screens.HealthScreen
import com.best.practice.screens.ListScreen
import com.microsoft.clarity.Clarity
import com.microsoft.clarity.ClarityConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthScreen()
           // MainScreen()
        }

    }
}

