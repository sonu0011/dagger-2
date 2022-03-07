package com.sonu.dagger2example.example

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sonu.dagger2example.R
import com.sonu.dagger2example.core.BaseApplication
import com.sonu.dagger2example.example.viewmodels.MainViewModel
import com.sonu.dagger2example.example.viewmodels.MainViewModelFactory
import javax.inject.Inject

class ExampleActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    lateinit var viewModel: MainViewModel

    private val product: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        (application as BaseApplication).mainComponent.inject(this)

        viewModel =
            ViewModelProvider(this, factory = mainViewModelFactory).get(MainViewModel::class.java)

        viewModel.productsLiveData.observe(this) {
            product.text = it.joinToString { x -> x.title + "\n \n" }
        }

    }
}