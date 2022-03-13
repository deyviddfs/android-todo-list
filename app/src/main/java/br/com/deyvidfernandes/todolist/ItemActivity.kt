package br.com.deyvidfernandes.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import br.com.deyvidfernandes.todolist.MainActivity.Companion.itens

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener {
            val editTextItem = findViewById<EditText>(R.id.editTextItem)
            val spinnerType = findViewById<Spinner>(R.id.spinnerType)
            val newitem = Item(editTextItem.text.toString(), spinnerType.selectedItem.toString())
            itens.add(newitem)
            finish()
        }
    }
}