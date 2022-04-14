package com.example.goodsapp

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "picture")
    val picture: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "companyName")
    val companyName: String,
    @Json(name = "companyLogo")
    val companyLogo: String,
    @Json(name = "companyLink")
    val companyLink: String
)
