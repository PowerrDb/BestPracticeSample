package com.best.practice.screens.component

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
                animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessLow
    )
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable {
                when (backgroundColor) {
                    Color.Green -> {
                        backgroundColor = Color.White
                    }

                    Color.White -> {
                        backgroundColor = Color.Green
                    }
                }

            }
            .padding(start = 5.dp)

    ) {

        Spacer(modifier = Modifier.height(3.dp))
            Row(modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(modifier = Modifier.weight(1f) ,
                    text = name,
                    fontStyle = FontStyle.Italic,
                    fontSize = fontSize,
                )
                Button( modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp)),
                    onClick = { expanded=!expanded }) {

                    Text(text = if (expanded) "Show less" else "Show more" ,
                        modifier = Modifier.padding(8.dp))
                }
            }

        Spacer(modifier = Modifier.height(5.dp))
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
