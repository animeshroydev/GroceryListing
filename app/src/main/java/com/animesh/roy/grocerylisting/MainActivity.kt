package com.animesh.roy.grocerylisting

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.animesh.roy.grocerylisting.adapter.BestSellingListAdapter
import com.animesh.roy.grocerylisting.adapter.ExclusiveListAdapter
import com.animesh.roy.grocerylisting.adapter.GroceryListAdapter
import com.animesh.roy.grocerylisting.data.BestSellingList
import com.animesh.roy.grocerylisting.data.ExclusiveList
import com.animesh.roy.grocerylisting.data.GroceriesList
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import java.io.ByteArrayOutputStream
import java.util.*


class MainActivity : AppCompatActivity(), GroceryListAdapter.OnItemClickListener {

    private val imageList = ArrayList<SlideModel>()
    private val groceryList = ArrayList<GroceriesList>()

    private lateinit var exclusiveRecyclerView: RecyclerView
    private lateinit var groceriesRecyclerView: RecyclerView
    private lateinit var bestSellingRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exclusiveRecyclerView = findViewById(R.id.exclusive_recyclerview)
        groceriesRecyclerView = findViewById(R.id.groceries_recyclerview)
        bestSellingRecyclerView = findViewById(R.id.bestselling_recyclerview)


        imgSlider()
        exclusiveRecyclerViewList()
        groceryRecyclerViewList()
        bestSellingRecyclerViewList()


    }

    private fun groceryRecyclerViewList() {
        val groceriesList = feedGroceryListData()
        groceriesRecyclerView.adapter = GroceryListAdapter(groceriesList, this)
        groceriesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun feedGroceryListData(): List<GroceriesList> {


        groceryList.add(GroceriesList(R.drawable.rice, "Rice", "1kg, Price"))
        groceryList.add(GroceriesList(R.drawable.nuts, "Nuts", "3kg, Price"))
        groceryList.add(GroceriesList(R.drawable.wheat, "Wheat", "4kg, Price"))
        groceryList.add(GroceriesList(R.drawable.sugar, "Sugar", "5kg, Price"))
        groceryList.add(GroceriesList(R.drawable.salt, "Salt", "6kg, Price"))

        return groceryList
    }

    private fun exclusiveRecyclerViewList() {

        val exclusiveList = feedExclusiveListData()
        exclusiveRecyclerView.adapter = ExclusiveListAdapter(exclusiveList)
        exclusiveRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun feedExclusiveListData(): List<ExclusiveList> {

        val list = ArrayList<ExclusiveList>()


            list.add(ExclusiveList(R.drawable.apple,
                "Red Apple",
                "1kg, Priceg",
                "$4.0",
                R.drawable.ic_add))
            list.add(ExclusiveList(R.drawable.bananas,
                "Bananas",
                "7pcs, Priceg",
                "$5.22",
                R.drawable.ic_add))
            list.add(ExclusiveList(R.drawable.guava,
                "Guava",
                "2kg, Priceg",
                "$2.99",
                R.drawable.ic_add))
            list.add(ExclusiveList(R.drawable.mango,
                "Mango",
                "6kg, Priceg",
                "$8.32",
                R.drawable.ic_add))
            list.add(ExclusiveList(R.drawable.grape,
                "Grape",
                "3kg, Priceg",
                "$6.01",
                R.drawable.ic_add))
            list.add(ExclusiveList(R.drawable.coconut,
                "Coconut",
                "2pcs, Priceg",
                "$7.0",
                R.drawable.ic_add))


        return list
    }

    private fun imgSlider() {
        imageList.add(SlideModel(R.drawable.slide_four))
        imageList.add(SlideModel(R.drawable.slide_two))
        imageList.add(SlideModel(R.drawable.slide_three))
        imageList.add(SlideModel(R.drawable.slide_one))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }



    private fun bestSellingRecyclerViewList() {

        val bestSellingList = feedBestSellingListData()
        bestSellingRecyclerView.adapter = BestSellingListAdapter(bestSellingList)
        bestSellingRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun feedBestSellingListData(): List<BestSellingList> {

        val list = ArrayList<BestSellingList>()


        list.add(BestSellingList(R.drawable.turnip,
            "Turnip",
            "$6.03",
            R.drawable.ic_add))
        list.add(BestSellingList(R.drawable.ginger,
            "Ginger",
            "$2.32",
            R.drawable.ic_add))
        list.add(BestSellingList(R.drawable.greenbeans,
            "Green Beans",
            "$3.96",
            R.drawable.ic_add))
        list.add(BestSellingList(R.drawable.brusselssprouts,
            "Brussels Sprouts",
            "$7.39",
            R.drawable.ic_add))
        list.add(BestSellingList(R.drawable.cherrytomato,
            "Tomato",
            "$2.21",
            R.drawable.ic_add))
        list.add(BestSellingList(R.drawable.eggplant,
            "Eggplant",
            "$1.0",
            R.drawable.ic_add))

        return list
    }



    override fun onItemClick(position: Int) {

        // Toast.makeText(this, "Item $position name: " + groceryList.get(position).groceryName, Toast.LENGTH_SHORT).show()

        val intent = Intent(this, GroceryDetailActivity::class.java)
        intent.putExtra("name_value", groceryList.get(position).groceryName)
        intent.putExtra("amount_value", groceryList.get(position).groceryAmount)


        val bitmap = BitmapFactory.decodeResource(resources, groceryList.get(position).groceryImage)
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val b: ByteArray = baos.toByteArray()

        intent.putExtra("img_value", b)

        startActivity(intent)

    }


}