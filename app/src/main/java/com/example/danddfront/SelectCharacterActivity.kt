package com.example.danddfront

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.danddfront.Data.DatabaseHelper
import com.example.danddfront.ui.theme.DandDFrontTheme

class SelectCharacterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            characterList()
        }
    }
}

@Composable
fun characterList() {
    Column {
        val ids = listAllCharactersIds()
        ids.forEach { id ->
            val context = LocalContext.current;
            Button( onClick = {
                loadCharacter(context, id)
            }) {
                Text(id.toString())
            }
        }
    }
}


@Composable
fun listAllCharactersIds() : ArrayList<Int> {
    val dbHelper = DatabaseHelper(LocalContext.current)
    val db = dbHelper.writableDatabase;

    val cursor = db.rawQuery("SELECT id, raca FROM ${dbHelper.CHARACTER_DATABASE_NAME}", null);

    val idList = ArrayList<Int>();

    while (cursor.moveToNext()) {
        idList.add(cursor.getInt(cursor.getColumnIndex("id")))
    }

    db.close()
    cursor.close()

    return idList;
}

fun loadCharacter(context: Context, id: Int) {
    val intent = Intent(context, CharacterShowActivity::class.java)

    var bundle = Bundle()
    bundle.putString("characterId", id.toString())
    intent.putExtras(bundle)
    context.startActivity(intent)
}
