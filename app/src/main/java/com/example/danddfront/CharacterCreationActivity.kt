package com.example.danddfront

import DandDService.Personagem
import DandDService.Racas.*;
import DatabaseHelper
import android.content.ContentValues
import android.content.Intent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

val race = Humano();
val character = Personagem(race);

class CharacterCreationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Title()
                Spacer(Modifier.height(50.dp))

                Row {
                    raceSelector(Humano());
                    raceSelector(AltoElfo());
                    raceSelector(Anao())
                }
                Row {
                    raceSelector(AnaoColina())
                    raceSelector(AnaoMontanha())
                    raceSelector(Draconato())
                }
                Row {
                    raceSelector(Drow())
                    raceSelector(Elfo())
                    raceSelector(GnomoFloresta())
                }
                Row {
                    raceSelector(GnomoRochas())
                    raceSelector(Halfling())
                    raceSelector(HalflingPesLeves())
                }
                Row {
                    raceSelector(HalflingRobusto())
                    raceSelector(MeioElfo())
                    raceSelector(MeioOrc())
                }

                Spacer(Modifier.height(25.dp))
                allStats()

                createButton()
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
fun raceDisplay() {
    var race = remember { mutableStateOf(character.raca.name) }
    Text(race.value);
}

@Composable
fun raceSelector(raca: Raca) {
    Button(onClick = {
        character.raca = raca;
    }) {
        Text(raca.name)
    }
}

@Composable
fun allStats() {
    Column() {
        statusSelector("Força", character.forca)
        statusSelector("Destreza", character.destreza)
        statusSelector("Constituicao", character.constituicao)
        statusSelector("inteligencia", character.inteligencia)
        statusSelector("sabedoria", character.sabedoria)
        statusSelector("carisma", character.carisma)
    }
}

@Composable
fun statusSelector(statusName : String, status : Int) {
    Row {
        Text(
            text = statusName,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.width(8.dp))
        Button(onClick = {
            when(statusName) {
                "Força" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(status)) { character.forca -= 1 }
                "Destreza" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(status)) { character.destreza -= 1 }
                "Constituicao" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(status)) { character.constituicao -= 1 }
                "sabedoria" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(status)) { character.sabedoria -= 1 }
                "carisma" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(status)) { character.carisma -= 1 }
            }
        }) {
            Text("Diminuir")
        }
        Button(onClick = {
            when(statusName) {
                "Força" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(status)) { character.forca += 1 }
                "Destreza" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(status)) { character.destreza += 1 }
                "Constituicao" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(status)) { character.constituicao += 1 }
                "sabedoria" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(status)) { character.sabedoria += 1 }
                "carisma" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(status)) { character.carisma += 1 }
            }
        }) {
            Text("Aumentar")
        }
    }
}

@Composable
fun createButton() {
    val context = LocalContext.current;

    Button(onClick = {
        character.iniciarPersonagem()

        //
        var dbHelper = DatabaseHelper(context);
        var db = dbHelper.writableDatabase

        val values = ContentValues().apply {
          put("raca", character.raca.name)
          put("vida", character.getVida())
          put("forca", character.forca)
          put("destreza", character.destreza)
          put("constituicao", character.constituicao)
          put("inteligencia", character.inteligencia)
          put("sabedoria", character.sabedoria)
          put("carisma", character.carisma)
        }

        val newRowId = db.insert(dbHelper.CHARACTER_DATABASE_NAME, null, values)
        println(newRowId);
        db.close();
        //

        val intent = Intent(context, CharacterShowActivity::class.java)

        var bundle = Bundle()
        bundle.putString("characterId", newRowId.toString())
        intent.putExtras(bundle)
        context.startActivity(intent)
    }) {
        Text("Criar")
    }
}
