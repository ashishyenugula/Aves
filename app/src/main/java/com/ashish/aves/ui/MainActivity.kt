package com.ashish.aves.ui


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ashish.aves.MainAdapter
import com.ashish.aves.viewmodel.MainRepository
import com.ashish.aves.R
import com.ashish.aves.databinding.ActivityMainBinding
import com.ashish.aves.listners.ClickListener
import com.ashish.aves.listners.RetrofitService
import com.ashish.aves.model.ImageResponse
import com.ashish.aves.viewmodel.MainViewModel
import com.ashish.aves.viewmodel.MyViewModelFactory
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    private val mainadapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //  setSupportActionBar(binding.toolbar)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // using toolbar as ActionBar
        setSupportActionBar(toolbar)
        // supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        viewModel =
            ViewModelProvider(
                this,
                MyViewModelFactory(MainRepository(retrofitService))
            )[MainViewModel::class.java]

        binding.recyclerview.apply {
            adapter = mainadapter
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )


        }
        mainadapter.setOnItemClickListener(object : ClickListener<ImageResponse> {
            override fun onClick(view: View?, data: ImageResponse, position: Int) {
                val intent =
                    Intent(
                        applicationContext,
                        DetailsActivity::class.java
                    ).apply {
                        putExtra("Image_Details", Gson().toJson(data))
                    }


                startActivity(intent)
            }
        })

        mainadapter.setOnImageItemClickListener(object : ClickListener<ImageResponse> {
            override fun onClick(view: View?, data: ImageResponse, position: Int) {
                val intent =
                    Intent(
                        applicationContext,
                        ImageActivity::class.java
                    ).apply {
                        putExtra("Image_Details", Gson().toJson(data))
                    }


                startActivity(intent)
            }
        })

        viewModel.data.observe(this, Observer {
            Log.d("Data", "onCreate: $it")
            mainadapter.setImgList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d("ErrorData", "onCreate: $it")
        })
        viewModel.getAllImages()
    }
}