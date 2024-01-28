package ru.weather.client.network.models

import com.google.gson.annotations.SerializedName

data class Forecast(
	@SerializedName("forecastday")
	val forecastDays: Array<ForecastDay> = emptyArray()
) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Forecast

		return forecastDays.contentEquals(other.forecastDays)
	}

	override fun hashCode(): Int {
		return forecastDays.contentHashCode()
	}
}
