package com.animesh.roy.grocerylisting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.animesh.roy.grocerylisting.R
import com.animesh.roy.grocerylisting.data.BestSellingList

class BestSellingListAdapter(private val bestSellingList: List<BestSellingList>): RecyclerView.Adapter<BestSellingListAdapter.BestSellingListViewHolder>() {

    class BestSellingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bestSellingIconImage: ImageView = itemView.findViewById(R.id.bestSelingImage)
        val bestSellingName: TextView = itemView.findViewById(R.id.bestSellingName)
        val bestSellingPrice: TextView = itemView.findViewById(R.id.bestSellingPrice)
        val bestSellingImg: ImageView = itemView.findViewById(R.id.fruit_add)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellingListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.best_selling_listitem,
                       parent, false)

        return BestSellingListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BestSellingListViewHolder, position: Int) {
      val currentItem = bestSellingList[position]

        holder.bestSellingIconImage.setImageResource(currentItem.bestSellingIconImage)
        holder.bestSellingImg.setImageResource(currentItem.fruitAddImg)

        holder.bestSellingName.text = currentItem.bestSellingName
        holder.bestSellingPrice.text = currentItem.bestSellingPrice
    }

    override fun getItemCount(): Int {
       return bestSellingList.size
    }

}