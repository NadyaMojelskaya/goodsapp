package com.example.goodsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goodsapp.databinding.ActivityMainBinding


class ProductAdapter(val goods: Goods): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()  {
    private lateinit var binding: ActivityMainBinding

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = goods.products.get(position)
        holder.bind(product)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_row, parent, false)
        return ProductViewHolder(view) // ,onClick
    }

    override fun getItemCount(): Int  = goods.products.count()

    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val productIdTextView: TextView = itemView.findViewById(R.id.textView_productId)
        private val productNameTextView: TextView = itemView.findViewById(R.id.textView_productName)
        private var currentProduct: Product? = null

//        init {
//            itemView.setOnClickListener {
//                currentProduct?.let {
//                    //onClick(it)
//                }
//            }
//        }

        fun bind(product: Product) {
            currentProduct = product

            productIdTextView.text = product.id.toString()
            productNameTextView.text = product.name

        }
    }
}