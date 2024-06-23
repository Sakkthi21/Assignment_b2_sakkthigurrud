package com.example.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var itemList: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemList = generateItems()
        adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter
    }

    private fun generateItems(): MutableList<Item> {
        val items = mutableListOf<Item>()
        items.add(Item(R.drawable.iphone, "Iphone"))
        items.add(Item(R.drawable.samsung, "Samsung"))
        items.add(Item(R.drawable.nokia, "Nokia"))
        items.add(Item(R.drawable.realme, "Realme"))
        items.add(Item(R.drawable.oppo, "OPPO"))
        return items
    }
}
