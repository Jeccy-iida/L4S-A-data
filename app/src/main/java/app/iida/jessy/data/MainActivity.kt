package app.iida.jessy.data

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val saveText = findViewById<TextView>(R.id.saveText)
        val readButton = findViewById<Button>(R.id.readButton)
        val readText = findViewById<TextView>(R.id.readText)

        val dateStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        saveButton.setOnClickListener(
                val stringText = editText.text.toString()
                saveText.text = stringText

                val editor = dateStore.edit()
                editor.pitString("Input",stringText)

                editor.apply()
        )

        readButton.setOnClickListener(
                val str = dateStore.getString("Input","NoDate")
                readText.text = str

        )
    }
}