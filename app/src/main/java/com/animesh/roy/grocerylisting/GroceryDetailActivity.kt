package com.animesh.roy.grocerylisting

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class GroceryDetailActivity : AppCompatActivity() {

    var amountStr: String = ""
    var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grocery_detail)

        val detailsAmount: TextView = findViewById(R.id.detailsAmount)
        val detailsName: TextView = findViewById(R.id.detailsName)
        val detailsImg: ImageView = findViewById(R.id.detailsImg)


        getIncomingIntent(detailsAmount, detailsName, detailsImg)

    }

    private fun getIncomingIntent(
        detailsAmount: TextView,
        detailsName: TextView,
        detailsImg: ImageView,
    ) {
        if (intent.hasExtra("amount_value")) {
            amountStr = intent.getStringExtra("amount_value").toString()
            name = intent.getStringExtra("name_value").toString()
            Log.d("IdVal ", amountStr.toString())
        }
        detailsAmount.text = amountStr
        detailsName.text = name

        // img res
        val extras = intent.extras
        val b = extras!!.getByteArray("img_value")
        val bmp = BitmapFactory.decodeByteArray(b, 0, b!!.size)
        detailsImg.setImageBitmap(bmp)
    }
}