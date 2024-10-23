package com.example.clickbait

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clickbait.data.DataSource
import com.example.clickbait.model.Ad
import com.example.clickbait.ui.theme.ClickbaitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickbaitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClickbaitApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickbaitTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displaySmall
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun AdItem (
ad: Ad,
modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                modifier = modifier
                    .size(64.dp)
                    .padding(8.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop,
                painter = painterResource(ad.imageResourceId),
                contentDescription = null
            )


            Column {
                Text(
                    text = stringResource(ad.creator),
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = stringResource(ad.title),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = stringResource(ad.time),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}


@Composable
fun ClickbaitApp() {
    Scaffold(
        topBar = {
            ClickbaitTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(DataSource.Ads) {
                AdItem(
                    ad = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ClickbaitPreview() {
    ClickbaitTheme {
        ClickbaitApp()
    }
}