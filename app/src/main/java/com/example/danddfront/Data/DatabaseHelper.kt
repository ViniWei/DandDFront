package com.example.danddfront.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    val CHARACTER_TABLE_NAME = "characters"

    companion object {
        private const val DATABASE_NAME = "dandd.db"
        private const val DATABASE_VERSION = 2
    }

    override fun onCreate(db: SQLiteDatabase)
    {
        // Create tables and their columns here
        val CREATE_TABLE_QUERY = "CREATE TABLE $CHARACTER_TABLE_NAME (id INTEGER PRIMARY KEY AUTOINCREMENT, pontos INTEGER, raca TEXT, vida INTEGER, forca INTEGER, destreza INTEGER, constituicao INTEGER, inteligencia INTEGER, sabedoria INTEGER, carisma INTEGER)"
        db.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    {
        // Upgrade database schema here
        db.execSQL("DROP TABLE IF EXISTS $CHARACTER_TABLE_NAME")
        onCreate(db)
    }

}
