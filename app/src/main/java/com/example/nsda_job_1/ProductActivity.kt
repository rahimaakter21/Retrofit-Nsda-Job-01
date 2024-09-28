package com.example.nsda_job_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nsda_job_01.Adapter.ProductAdapter
import com.example.nsda_job_01.viewModel.ProductViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductActivity : AppCompatActivity() {
    private  lateinit var  productViewModel: ProductViewModel
    private  lateinit var  productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        productAdapter = ProductAdapter(emptyList())

        val  refreshBtn: FloatingActionButton = findViewById(R.id.refreshBtn)

        refreshBtn.setOnClickListener{

            startActivity(Intent(this@ProductActivity,ProductActivity::class.java))
            finish()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.productRV)
        recyclerView.layoutManager= LinearLayoutManager(this)

        productViewModel.products.observe(this, Observer {  products ->
            productAdapter = ProductAdapter(products)
            recyclerView.adapter = ProductAdapter(products)

        })
    }
}