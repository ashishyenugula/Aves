package com.ashish.aves.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ashish.aves.R
import com.ashish.aves.databinding.ActivityDetailsBinding
import com.ashish.aves.model.ImageResponse
import com.bumptech.glide.Glide
import com.google.gson.Gson

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // using toolbar as ActionBar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        var mydata =
            Gson().fromJson(intent?.extras?.getString("Image_Details"), ImageResponse::class.java)
        binding.name.text = mydata.user?.name
        binding.bio.text=mydata.user?.bio
        binding.location.text=mydata.user?.location
        Glide.with(this).load(mydata.user?.profileImage?.medium).into(binding.profileImage)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}