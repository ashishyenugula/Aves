package com.ashish.aves.model

import com.example.example.Links
import com.example.example.Sponsorship
import com.example.example.User
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageResponse(
    @SerializedName("id"                       ) var id                     : String?,
    @SerializedName("created_at"               ) var createdAt              : String?,
    @SerializedName("updated_at"               ) var updatedAt              : String?,
    @SerializedName("promoted_at"              ) var promotedAt             : String?,
    @SerializedName("width"                    ) var width                  : Int?,
    @SerializedName("height"                   ) var height                 : Int?,
    @SerializedName("color"                    ) var color                  : String?,
    @SerializedName("blur_hash"                ) var blurHash               : String?,
    @SerializedName("description"              ) var description            : String?,
    @SerializedName("alt_description"          ) var altDescription         : String?,
    @SerializedName("urls"                     ) var urls                   : Urls?,
    @SerializedName("links"                    ) var links                  : Links?,
    @SerializedName("likes"                    ) var likes                  : Int?,
    @SerializedName("liked_by_user"            ) var likedByUser            : Boolean?,
    @SerializedName("current_user_collections" ) var currentUserCollections : ArrayList<String> = arrayListOf(),
    @SerializedName("sponsorship"              ) var sponsorship            : Sponsorship?,
  //  @SerializedName("topic_submissions"        ) var topicSubmissions       : TopicSubmissions?,
    @SerializedName("user"                     ) var user                   : User?

) :Serializable
