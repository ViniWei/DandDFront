package com.example.danddfront

import DandDService.Personagem
import DatabaseHelper
import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class CharacterShowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                stats()
            }
        }
    }

    fun getCharacterStats(characterId: String?, context: Context): String? {
        if (characterId == null) {
            Toast.makeText(context, "Character ID: $characterId not found", Toast.LENGTH_LONG).show()
            return null;
        }

        val dbHelper = DatabaseHelper(context)
        val db = dbHelper.writableDatabase;

        val cursor = db.rawQuery("SELECT * FROM ${dbHelper.CHARACTER_DATABASE_NAME} WHERE id = $characterId", null);
        var raca: String? = null;

        if (cursor.moveToFirst()) {
            raca = cursor.getString(cursor.getColumnIndex("raca"))
        }
        db.close()
        cursor.close()

        return raca;
    }

    @Composable
    fun stats() {
        val characterId = getIntent().getStringExtra("characterId")
        val raca = getCharacterStats(characterId, LocalContext.current)

        Text(text = "Raca: $raca")
        //Spacer(modifier = Modifier.height(10.dp))
        //Text(text = "Vida: $vida")
        //Text(text = "Força: $forca")
        //Text(text = "Destreza: $destreza")
        //Text(text = "Constituição: $constituicao")
        //Text(text = "Inteligencia: $inteligencia")
        //Text(text = "Sabedoria: $sabedoria")
        //Text(text = "Carisma: $carisma")
    }
}