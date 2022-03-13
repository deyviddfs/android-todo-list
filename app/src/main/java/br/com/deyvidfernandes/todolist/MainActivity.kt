package br.com.deyvidfernandes.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        var itens = mutableListOf<Item>()
        var adapter = ItemAdapter(itens)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadList()
    }

    fun loadList() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val textViewEmpty = findViewById<TextView>(R.id.textViewEmpty)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        if (itens.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            textViewEmpty.setVisibility(View.VISIBLE);
        }
        else {
            recyclerView.setVisibility(View.VISIBLE);
            textViewEmpty.setVisibility(View.GONE);
        }
    }

    override fun onResume() {
        super.onResume()
        loadList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_new -> {
            val intent = Intent(this, ItemActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}