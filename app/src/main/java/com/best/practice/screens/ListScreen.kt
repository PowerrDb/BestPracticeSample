package com.best.practice.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.best.practice.ui.theme.BestPracticeSampleTheme


val names = listOf("Item 1", "Item 2 ", "item 3", "item four", "item 3", "item four", "item 3", "item four", "item 3", "item four", "item 3", "item four", "item 3", "item four")

@Composable
fun ListScreen(nameList: List<String> = names) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(items = nameList) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = it)
            }

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
