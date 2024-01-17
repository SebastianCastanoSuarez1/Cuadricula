package com.example.cuadricula

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cuadricula.data.DataSource
import com.example.cuadricula.model.Topic
import com.example.cuadricula.ui.theme.CuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    PantallaFinal()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PantallaFinal() {
    CuadriculaTheme {
        CardApp()
    }
}

@SuppressLint("ResourceType")
@Composable
fun FormattedCard(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            Image(
                painter = painterResource(topic.foto),
                contentDescription = null,
                modifier = Modifier
                    .height(dimensionResource(R.dimen.ppading_68dp))
                    .width(dimensionResource(R.dimen.ppading_68dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(
                    top = (dimensionResource(R.dimen.ppading_16dp)),
                    end = (dimensionResource(R.dimen.ppading_16dp))
                )
            ) {
                Text(
                    text = LocalContext.current.getString(topic.stringResourceId),
                    modifier = Modifier.padding(
                        start = (dimensionResource(R.dimen.ppading_16dp)),
                        bottom = (dimensionResource(R.dimen.ppading_8dp))
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = (dimensionResource(R.dimen.ppading_16dp)))
                    )
                    Text(
                        text = topic.vacantes.toString(),
                        modifier = Modifier.padding(start = (dimensionResource(R.dimen.ppading_8dp))),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}


@Composable
fun CardList(topicList: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(dimensionResource(R.dimen.ppading_8dp)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.ppading_8dp)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.ppading_8dp))
    ) {
        this.items(topicList) { topic -> FormattedCard(topic = topic) }
    }
}

@Composable
fun CardApp() {
    CardList(topicList = DataSource.topic)
}