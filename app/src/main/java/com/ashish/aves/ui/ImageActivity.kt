package com.ashish.aves.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.ashish.aves.R
import com.ashish.aves.databinding.ActivityImageBinding
import com.ashish.aves.model.ImageResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson

class ImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // using toolbar as ActionBar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var mydata =
            Gson().fromJson(intent?.extras?.getString("Image_Details"), ImageResponse::class.java)
        binding.description.text=mydata.description

        Glide.with(this).load(mydata.urls?.full).centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imageView)

    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}