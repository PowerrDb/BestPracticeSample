package com.best.practice.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.best.practice.ui.theme.BestPracticeSampleTheme


@Composable
fun MainScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        var message by rememberSaveable {
            mutableStateOf("First text!")
        }
        var isVisible by rememberSaveable {
            mutableStateOf(true)
        }


        AnimatedVisibility(visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()) {
            Text(text = message)
        }




        Log.e("______compose", "MainScreen")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            isVisible = !isVisible
            message = "Changed by button"
            Toast.makeText(context, "Button clicked!", Toast.LENGTH_LONG).show()
        }) {
            if (isVisible)
                Text(text = "Hide TextView")
            else Text(text = "Show TextView")
        }
        Spacer(modifier = Modifier.height(120.dp))
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BestPracticeSampleTheme {
        MainScreen()
    }
}
