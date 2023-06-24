package com.best.practice.screens

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.best.practice.screens.component.ListItem
import com.best.practice.ui.theme.BestPracticeSampleTheme


val names = listOf(   "item a3", "item four", "item 3", "item four")

@Composable
fun ListScreen(nameList: List<String> = names) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            ListItem(name = "Header", fontSize = 30.sp)
        }
        items(items = nameList) {
          ListItem(name = it)
        }
        item {
            ListItem(name = "Footer", fontSize = 30.sp)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    BestPracticeSampleTheme {
        ListScreen()
    }
}
