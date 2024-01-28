package ru.weather.client.network.models

import ru.weather.client.utils.DateUtils

data class ForecastDay(
	val date: String? = null,

	val day: Day? = null
) {
	fun formatDate() = DateUtils.formatDate(date) ?: ""
}
