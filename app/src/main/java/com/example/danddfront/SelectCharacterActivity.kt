package com.example.danddfront

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.danddfront.Data.DatabaseHelper

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
    val context = LocalContext.current;
    Column {
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("<-")
        }
        val ids = listAllCharactersIds()
        ids.forEach { id ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                color = Color.LightGray
            ) {
                Row {
                    Spacer(Modifier.width(20.dp))
                    Text(id.toString(), modifier = Modifier.align(Alignment.CenterVertically))
                    Spacer(Modifier.width(20.dp))
                    Button(onClick = {
                        loadCharacter(context, id)
                    }) {
                        Text("👁")
                    }
                    FilledTonalButton(onClick = {
                        deleteCharacter(context, id);
                        val intent = Intent(context, SelectCharacterActivity::class.java)

                        context.startActivity(intent)
                    }, ) {
                        Text("🗑")
                    }
                }
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun listAllCharactersIds() : ArrayList<Int> {
    val dbHelper = DatabaseHelper(LocalContext.current)
    val db = dbHelper.writableDatabase;

    val cursor = db.rawQuery("SELECT id, raca FROM ${dbHelper.CHARACTER_TABLE_NAME}", null);

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

fun deleteCharacter(context: Context, id: Int) {
    val dbHelper = DatabaseHelper(context)
    val db = dbHelper.writableDatabase;

    db.delete(dbHelper.CHARACTER_TABLE_NAME, "id = ?", arrayOf(id.toString()))
    db.close()
}