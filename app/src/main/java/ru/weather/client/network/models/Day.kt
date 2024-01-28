package ru.weather.client.network.models

import com.google.gson.annotations.SerializedName

data class Day(
	@SerializedName("avgtemp_c")
	val temperature: Double = 0.0,

	val condition: Condition? = null
)
