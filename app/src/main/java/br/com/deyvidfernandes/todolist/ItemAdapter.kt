package br.com.deyvidfernandes.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.deyvidfernandes.todolist.MainActivity.Companion.itens
import br.com.deyvidfernandes.todolist.MainActivity.Companion.adapter

class ItemAdapter (private val dataSet: List<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>(),
    View.OnClickListener {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageButtonDelete: ImageButton
        val textViewItem: TextView
        val textViewType: TextView

        init {
            imageButtonDelete = view.findViewById(R.id.imageButtonDelete)
            textViewItem = view.findViewById(R.id.textViewItem)
            textViewType = view.findViewById(R.id.textViewType)
        }
    }

    //Define o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_item_todo, parent, false)

        return ViewHolder(view)
    }

    //De/Para Objeto para o layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]

        holder.textViewItem.text = item.name
        holder.textViewType.text = item.type
        holder.imageButtonDelete.setOnClickListener {
            itens.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(holder.itemView.context, "Item excluído com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }

    //Retorna o tamanho da lista
    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}