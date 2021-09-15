package com.animesh.roy.grocerylisting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.animesh.roy.grocerylisting.R
import com.animesh.roy.grocerylisting.data.GroceriesList

class GroceryListAdapter(private val groceryList: List<GroceriesList>,
                         private val listener: OnItemClickListener
):
    RecyclerView.Adapter<GroceryListAdapter.GroceryListViewHolder>() {

    inner class GroceryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
          View.OnClickListener {
        val groceryImage: ImageView = itemView.findViewById(R.id.groceries_img)
        val groceryName: TextView = itemView.findViewById(R.id.groceries_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.groceries_listitem,
                       parent, false)

        return GroceryListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GroceryListViewHolder, position: Int) {
      val currentItem = groceryList[position]

        holder.groceryImage.setImageResource(currentItem.groceryImage)

        holder.groceryName.text = currentItem.groceryName

    }

    override fun getItemCount(): Int {
       return groceryList.size
    }

}