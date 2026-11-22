package com.example.notasapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val file = File(filesDir, "nota.txt")
        val editText = EditText(this).apply {
            hint = "Escreva sua nota aqui..."
            setText(if (file.exists()) file.readText() else "")
            minLines = 8
        }

        val saveButton = Button(this).apply {
            text = "Salvar nota"
            setOnClickListener {
                file.writeText(editText.text.toString())
                Toast.makeText(this@MainActivity, "Nota salva!", Toast.LENGTH_SHORT).show()
            }
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
            addView(editText)
            addView(saveButton)
        }

        setContentView(layout)
    }
}
