package com.example.danddfront

import com.example.danddfront.Data.DatabaseHelper
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.danddfront.Data.CharacterModel

class CharacterShowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                stats()
            }
        }
    }

    fun getCharacterStats(characterId: String?, context: Context): CharacterModel? {
        if (characterId == null) {
            Toast.makeText(context, "Character ID: $characterId not found", Toast.LENGTH_LONG).show()
            return null;
        }

        val dbHelper = DatabaseHelper(context)
        val db = dbHelper.writableDatabase;

        val cursor = db.rawQuery("SELECT * FROM ${dbHelper.CHARACTER_TABLE_NAME} WHERE id = $characterId", null);
        var raca: String? = null;

        val characterModel = CharacterModel()

        if (cursor.moveToFirst()) {
            characterModel.raca = cursor.getString(cursor.getColumnIndex("raca"))
            characterModel.vida = cursor.getInt(cursor.getColumnIndex("vida"))
            characterModel.forca = cursor.getInt(cursor.getColumnIndex("forca"))
            characterModel.destreza = cursor.getInt(cursor.getColumnIndex("destreza"))
            characterModel.constituicao = cursor.getInt(cursor.getColumnIndex("constituicao"))
            characterModel.inteligencia = cursor.getInt(cursor.getColumnIndex("inteligencia"))
            characterModel.sabedoria = cursor.getInt(cursor.getColumnIndex("sabedoria"))
            characterModel.carisma = cursor.getInt(cursor.getColumnIndex("carisma"))
        }
        db.close()
        cursor.close()

        return characterModel;
    }

    @Composable
    fun stats() {
        val characterId = getIntent().getStringExtra("characterId")
        val character = getCharacterStats(characterId, LocalContext.current)

        Text(text = "Raca: ${character?.raca}")
        //Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Vida: ${character?.vida}")
        Text(text = "Força: ${character?.forca}")
        Text(text = "Destreza: ${character?.destreza}")
        Text(text = "Constituição: ${character?.constituicao}")
        Text(text = "Inteligencia: ${character?.inteligencia}")
        Text(text = "Sabedoria: ${character?.sabedoria}")
        Text(text = "Carisma: ${character?.carisma}")
    }
}