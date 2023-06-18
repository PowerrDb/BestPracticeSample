package com.best.practice.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.best.practice.ui.theme.BestPracticeSampleTheme


@Composable
fun MainScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()

    ) {

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BestPracticeSampleTheme {
        MainScreen()
    }
}
