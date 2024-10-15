package com.example.danddfront

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class CharacterShowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var raceName = "Elfo da silva"
        if (getIntent().getStringExtra("race") != null) {
           raceName = getIntent().getStringExtra("race").toString()
        }

        var vida = "0"
        if (getIntent().getStringExtra("vida") != null) {
            vida = getIntent().getStringExtra("vida").toString()
        }

        var forca = "0"
        if (getIntent().getStringExtra("forca") != null) {
            forca = getIntent().getStringExtra("forca").toString()
        }

        var destreza = "0"
        if (getIntent().getStringExtra("destreza") != null) {
            destreza = getIntent().getStringExtra("destreza").toString()
        }

        var constituicao = "0"
        if (getIntent().getStringExtra("constituicao") != null) {
            constituicao = getIntent().getStringExtra("constituicao").toString()
        }

        var inteligencia = "0"
        if (getIntent().getStringExtra("inteligencia") != null) {
            inteligencia = getIntent().getStringExtra("inteligencia").toString()
        }

        var sabedoria = "0"
        if (getIntent().getStringExtra("sabedoria") != null) {
            sabedoria = getIntent().getStringExtra("sabedoria").toString()
        }

        var carisma = "0"
        if (getIntent().getStringExtra("carisma") != null) {
            carisma = getIntent().getStringExtra("carisma").toString()
        }

        setContent {
            Column {
                Text(text = "Raca: $raceName")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Vida: $vida")
                Text(text = "Força: $forca")
                Text(text = "Destreza: $destreza")
                Text(text = "Constituição: $constituicao")
                Text(text = "Inteligencia: $inteligencia")
                Text(text = "Sabedoria: $sabedoria")
                Text(text = "Carisma: $carisma")
            }
        }
    }
}