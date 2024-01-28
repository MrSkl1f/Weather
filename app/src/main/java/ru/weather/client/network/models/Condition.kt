package ru.weather.client.network.models

import ru.weather.client.R
import ru.weather.client.utils.WeatherConditionUtils

data class Condition(
	val text: String? = null,
	val code: Int = 1000,
) {
	fun getIcon() = WeatherConditionUtils.getIconByCondition(code)
}
