package com.example.goodsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(val goods: List<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()  {

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = goods.get(position)
        holder.bind(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_row, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int  = goods.count()

    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val productIdTextView: TextView = itemView.findViewById(R.id.textView_productId)
        private val productNameTextView: TextView = itemView.findViewById(R.id.textView_productName)
        private var currentProduct: Product? = null

        fun bind(product: Product) {
            currentProduct = product

            productIdTextView.text = product.id.toString()
            productNameTextView.text = product.name

        }
    }
}