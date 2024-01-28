package ru.weather.client.network.models

import com.google.gson.annotations.SerializedName

data class Current(
	@SerializedName("temp_c")
	val temperature: Double = 0.0,

	val condition: Condition? = null,

	@SerializedName("wind_mph")
	val wind: Double = 0.0,

	@SerializedName("pressure_mb")
	val pressure: Double = 0.0,

	val humidity: Int = 0,

	@SerializedName("feelslike_c")
	val feelsLike: Double = 0.0
) {
	fun getAtmosphericPressure() = pressure * 0.75006f
}
