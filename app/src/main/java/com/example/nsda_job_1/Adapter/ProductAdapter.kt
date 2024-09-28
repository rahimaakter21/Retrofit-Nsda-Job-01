package com.example.nsda_job_01.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nsda_job_1.Product
import com.example.nsda_job_1.R

class ProductAdapter (private val products: List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

 inner class  ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    val productImg = itemView.findViewById<ImageView>(R.id.images)
    val productTitle = itemView.findViewById<TextView>(R.id.title)
        val productName= itemView.findViewById<TextView>(R.id.nameTV)
        val productPrice= itemView.findViewById<TextView>(R.id.priceTV)
        val productDescription= itemView.findViewById<TextView>(R.id.descriptionTV)

     fun bind(product: Product){

          productTitle.text = product.title
          productName.text = product.name
         productPrice.text = "Price : ${product.price}$"
         productDescription.text = product.description
         Glide.with(itemView).load(product.images[0]).into(productImg)
     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }
}