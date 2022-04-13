package com.example.goodsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goodsapp.databinding.ActivityMainBinding
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var recyclerView = binding.recyclerViewMain
        recyclerView.layoutManager = LinearLayoutManager(this)

        var products = fetchJson()
        recyclerView.adapter = ProductAdapter(products)

    }

    fun fetchJson(): Goods {
        val jsonText : String = applicationContext.assets // чтение goods из assets
            .open("goods")
            .bufferedReader().use {
                it.readText()
            }
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // using moshi lib for json parcing
        val jsonAdapter: JsonAdapter<Goods> = moshi.adapter(Goods::class.java)
        val products = jsonAdapter.fromJson(jsonText)
        return products!!
    }




}


