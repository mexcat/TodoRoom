package cl.gencina.todoroom.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.todoroom.data.local.ItemEntity
import cl.gencina.todoroom.databinding.ItemBinding

class ListItemAdapter:RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>() {
    private var listaItems : List<ItemEntity> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listaItems[position]
        holder.bind(item)
    }
    fun setData(items:List<ItemEntity>){
        listaItems = items
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return listaItems.size
    }


    class ItemViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemEntity){
            binding.tvName.text = item.name
            binding.tvPrice.text = item.price.toString()
            binding.tvQuantity.text = item.quantity.toString()
            binding.tvTotal.text = (item.price * item.quantity).toString()
        }
    }
}