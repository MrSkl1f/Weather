package ru.weather.client.network.models

import com.google.gson.annotations.SerializedName

data class Location(
	val name: String? = null,
	val country: String? = null,
	@SerializedName("localtime")
	val time: String? = null,
)
