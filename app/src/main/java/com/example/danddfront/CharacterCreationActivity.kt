package com.example.danddfront

import DandDService.Personagem
import DandDService.Racas.*;
import com.example.danddfront.Data.DatabaseHelper
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
import com.example.danddfront.Data.CharacterService

val race = Humano();
var character = Personagem(race);
var characterId : String? = null;

class CharacterCreationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            characterId = getIntent().getStringExtra("characterId")
            if (characterId != null) {
                val characterService = CharacterService()
                val char = characterService.getCharacterStats(characterId, LocalContext.current);

                if (char != null) {
                    val raca = when(char.raca) {
                        "Humano" -> Humano()
                        "AltoElfo" -> AltoElfo()
                        "Anao" -> Anao()
                        "AnaoColina" -> AnaoColina()
                        "AnaoMontanha" -> AnaoMontanha()
                        "Draconato" -> Draconato()
                        "Drow" -> Drow()
                        "Elfo" -> Elfo()
                        "GnomoFloresta" -> GnomoFloresta()
                        "GnomoRochas" -> GnomoRochas()
                        "Halfling" -> Halfling()
                        "HalflingPesLeves" -> HalflingPesLeves()
                        "HalflingRobusto" -> HalflingRobusto()
                        "MeioElfo" -> MeioElfo()
                        "MeioOrc" -> MeioOrc()
                        else -> Humano()
                    }
                    character = Personagem(raca)

                    character.forca = char.forca
                    character.destreza = char.destreza
                    character.constituicao = char.constituicao
                    character.inteligencia = char.inteligencia
                    character.sabedoria = char.sabedoria
                    character.carisma = char.carisma
                    character.administradorAtributosPontos.pontos = char.pontos
                }
            }

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

        var stat = remember { mutableStateOf(status) }
        Text(stat.value.toString())

        Spacer(Modifier.width(8.dp))
        Button(onClick = {
            when(statusName) {
                "Força" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(character.forca)) { character.forca -= 1; stat.value = character.forca }
                "Destreza" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(character.destreza)) { character.destreza -= 1; stat.value = character.destreza  }
                "Constituicao" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(character.constituicao)) { character.constituicao -= 1; stat.value = character.constituicao }
                "inteligencia" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(character.inteligencia)) { character.inteligencia -= 1; stat.value = character.inteligencia }
                "sabedoria" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(character.sabedoria)) { character.sabedoria -= 1; stat.value = character.sabedoria }
                "carisma" -> if (character.administradorAtributosPontos.VerificarSubtracaoAtributoEaumentarPontos(character.carisma)) { character.carisma -= 1; stat.value = character.carisma }
            }
        }) {
            Text("Diminuir")
        }
        Button(onClick = {
            when(statusName) {
                "Força" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(character.forca)) { character.forca += 1; stat.value = character.forca }
                "Destreza" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(character.destreza)) { character.destreza += 1; stat.value = character.destreza  }
                "Constituicao" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(character.constituicao)) { character.constituicao += 1; stat.value = character.constituicao }
                "inteligencia" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(character.inteligencia)) { character.inteligencia += 1; stat.value = character.inteligencia }
                "sabedoria" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(character.sabedoria)) { character.sabedoria += 1 ; stat.value = character.sabedoria  }
                "carisma" -> if (character.administradorAtributosPontos.VerificarAdicaoAtributoEDiminuirPontos(character.carisma)) { character.carisma += 1 ; stat.value = character.carisma  }
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
          put("pontos", character.administradorAtributosPontos.pontos)
          put("raca", character.raca.name)
          put("vida", character.getVida())
          put("forca", character.forca)
          put("destreza", character.destreza)
          put("constituicao", character.constituicao)
          put("inteligencia", character.inteligencia)
          put("sabedoria", character.sabedoria)
          put("carisma", character.carisma)
        }

        var id: String = "";
        if (characterId == null) {
            id = db.insert(dbHelper.CHARACTER_TABLE_NAME, null, values).toString()
        } else {
            db.update(dbHelper.CHARACTER_TABLE_NAME, values, "id=?", arrayOf(characterId))
            id = characterId as String
        }

        db.close();
        //

        val intent = Intent(context, CharacterShowActivity::class.java)

        var bundle = Bundle()
        bundle.putString("characterId", id.toString())
        intent.putExtras(bundle)
        context.startActivity(intent)
    }) {
        Text("Criar")
    }
}
