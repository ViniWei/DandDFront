package com.example.danddfront.Data

import android.content.Context
import android.widget.Toast

class CharacterService {
    fun getCharacterStats(characterId: String?, context: Context): CharacterModel? {
        if (characterId == null) {
            Toast.makeText(context, "Character ID: $characterId not found", Toast.LENGTH_LONG).show()
            return null;
        }

        val dbHelper = DatabaseHelper(context)
        val db = dbHelper.writableDatabase;

        val cursor = db.rawQuery("SELECT * FROM ${dbHelper.CHARACTER_TABLE_NAME} WHERE id = $characterId", null);

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
            characterModel.pontos = cursor.getInt(cursor.getColumnIndex("pontos"))
        }
        db.close()
        cursor.close()

        return characterModel;
    }
}