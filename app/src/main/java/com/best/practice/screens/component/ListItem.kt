package com.best.practice.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.best.practice.screens.ListScreen
import com.best.practice.screens.names
import com.best.practice.ui.theme.BestPracticeSampleTheme

@Composable
fun ListItem(
    name : String,
    fontSize :TextUnit=20.sp
) {
    var backgroundColor by remember {
        mutableStateOf(Color.White)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable {
                when (backgroundColor) {
                    Color.Green->{ backgroundColor = Color.White}
                    Color.White->{ backgroundColor = Color.Green}
                }

            }
            .padding(start = 5.dp)

    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = name, fontStyle = FontStyle.Italic,fontSize = fontSize)
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
    }


}
@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    BestPracticeSampleTheme {
        ListScreen(names)
    }
}
