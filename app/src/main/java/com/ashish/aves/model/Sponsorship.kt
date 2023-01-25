package com.example.example

import com.google.gson.annotations.SerializedName


data class Sponsorship (

  @SerializedName("impression_urls" ) var impressionUrls : ArrayList<String> = arrayListOf(),
  @SerializedName("tagline"         ) var tagline        : String?          ,
  @SerializedName("tagline_url"     ) var taglineUrl     : String?          ,
  @SerializedName("sponsor"         ) var sponsor        : Sponsor?

)