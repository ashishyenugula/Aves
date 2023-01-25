package com.example.example

import com.google.gson.annotations.SerializedName


data class Links (

  @SerializedName("self"      ) var self      : String,
  @SerializedName("html"      ) var html      : String?,
  @SerializedName("photos"    ) var photos    : String? ,
  @SerializedName("likes"     ) var likes     : String?,
  @SerializedName("portfolio" ) var portfolio : String? ,
  @SerializedName("following" ) var following : String?,
  @SerializedName("followers" ) var followers : String?

)