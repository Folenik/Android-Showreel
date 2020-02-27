package com.folen.androidshowreel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SerializableModel : Serializable {
    @SerializedName("name")
    var name: String? = null
    @SerializedName("age")
    var age: Int? = null
    @SerializedName("gender")
    var gender: String? = null
}

