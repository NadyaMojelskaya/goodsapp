package com.example.goodsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goodsapp.databinding.ActivityMainBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var recyclerView: RecyclerView = binding.recyclerViewMain1

        recyclerView.layoutManager = LinearLayoutManager(this)

        var products = fetchJson()
        recyclerView.adapter = ProductAdapter(products)
    }

    fun fetchJson(): List<Product> {
        val jsonText : String = applicationContext.assets // чтение goods.json из assets
            .open("goods")
            .bufferedReader().use {
                it.readText()
            }
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // using moshi lib for json parcing
        val type: Type = Types.newParameterizedType(MutableList::class.java, Product::class.java)
        val adapter = moshi.adapter<List<Product>>(type)
        val products: List<Product>? = adapter.fromJson(jsonText)

        return products!!
    }
}


