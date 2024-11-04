package com.example.danddfront

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characterButton : Button = findViewById<Button>(R.id.CreateCharacterMenuButton)
        characterButton.setOnClickListener {
            val intent = Intent(this, CharacterCreationActivity::class.java)
            startActivity(intent)
        }

        val listButton : Button = findViewById<Button>(R.id.ListCharactersMenuButton)
        listButton.setOnClickListener {
            val intent = Intent(this, SelectCharacterActivity::class.java)
            startActivity(intent)
        }
    }
}