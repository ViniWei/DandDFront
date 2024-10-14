package com.example.danddfront

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CharacterCreationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Title()
                Spacer(Modifier.height(25.dp))
                Spacer(Modifier.height(25.dp))
                allStats()
                Button(onClick = {}) {
                    Text("Criar")
                }

            }
        }
    }
}

@Composable
fun Title() {
    Text(
        "Criar Personagem",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center),
    )
}

@Composable
fun allStats() {
    Column() {
        statusSelector("Força")
        statusSelector("Destreza")
        statusSelector("Constituicao")
        statusSelector("inteligencia")
        statusSelector("sabedoria")
        statusSelector("carisma")
    }
}


@Composable
fun statusSelector(statusName : String) {
    Row {
        Text(
            text = statusName,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = "00",
            style = MaterialTheme.typography.titleMedium
        )
        Button(onClick = { println(statusName) }) {
            Text("Lower")
        }
        Button(onClick = { println(statusName) }) {
            Text("Higher")
        }
    }
}