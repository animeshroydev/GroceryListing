package com.animesh.roy.grocerylisting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.animesh.roy.grocerylisting.R
import com.animesh.roy.grocerylisting.data.ExclusiveList

class ExclusiveListAdapter(private val exclusiveList: List<ExclusiveList>): RecyclerView.Adapter<ExclusiveListAdapter.ExclusiveListViewHolder>() {

    class ExclusiveListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitIconImage: ImageView = itemView.findViewById(R.id.fruitExclusiveImage)
        val fruitName: TextView = itemView.findViewById(R.id.fruitName)
        val fruitAmount: TextView = itemView.findViewById(R.id.fruitAmount)
        val fruitPrice: TextView = itemView.findViewById(R.id.priceOfFruits)
        val fruitAddImg: ImageView = itemView.findViewById(R.id.fruit_add)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExclusiveListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.exclusive_listitem,
                       parent, false)

        return ExclusiveListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExclusiveListViewHolder, position: Int) {
      val currentItem = exclusiveList[position]

        holder.fruitIconImage.setImageResource(currentItem.fruitIconImage)
        holder.fruitAddImg.setImageResource(currentItem.fruitAddImg)

        holder.fruitName.text = currentItem.fruitName
        holder.fruitAmount.text = currentItem.fruitAmount
        holder.fruitPrice.text = currentItem.priceOfFruit
    }

    override fun getItemCount(): Int {
       return exclusiveList.size
    }

}