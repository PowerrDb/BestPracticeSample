package com.best.practice.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.best.practice.R
import com.best.practice.ui.theme.BestPracticeSampleTheme
import com.google.android.material.bottomnavigation.BottomNavigationView


@Composable
fun HealthScreen() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.size(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        Section(text = R.string.placeholder_search) {
            AlignYourBodyRow()

        }
        Section(text = R.string.app_name) {
            FavoriteCollectionGrid()


        }
        Spacer(modifier = Modifier.size(10.dp))

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier) {
    TextField(
        value = "", onValueChange = {},
        placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        },
        colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface),
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }, modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )

}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)

        )
        Text(
            stringResource(id = text),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(20) {

            AlignYourBodyElement(drawable = R.drawable.sample_image, text = R.string.sample_text)
        }
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(6.dp)
            )
        }
    }

}

@Composable
fun FavoriteCollectionGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(

        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(120.dp)
    ) {
        items(40) {
            FavoriteCollectionCard(drawable = R.drawable.sample_image, text = R.string.sample_text)
        }

    }

}

@Composable
fun Section(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
            .padding(horizontal = 16.dp)
    )
    content()
}

@Composable
fun MyBottomNavigation() {

}

@Preview(showBackground = true)
@Composable
fun HealthScreenPreview() {
    BestPracticeSampleTheme {
        HealthScreen()
    }
}
