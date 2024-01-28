package ru.weather.client.utils

import ru.weather.client.R

object WeatherConditionUtils {

	fun getIconByCondition(code: Int) = when(code) {
		// Clear and sunny conditions
		1000 -> R.drawable.sunny
		// Mostly clear, partly cloudy day
		1003 -> R.drawable.partly_cloudy_day
		// Cloudy conditions
		1006, 1009 -> R.drawable.cloud
		// Foggy conditions
		1030, 1135, 1147 -> R.drawable.foggy
		// Light, moderate, heavy rain showers
		1063, 1180, 1183, 1186, 1189, 1192, 1195, 1240, 1243, 1246 -> R.drawable.rainy
		// Light, moderate, heavy snow showers
		1066, 1114, 1210, 1213, 1216, 1219, 1222, 1225, 1255, 1258 -> R.drawable.snowy
		// Sleet, ice pellets
		1069, 1072, 1150, 1153, 1168, 1171, 1204, 1207, 1237, 1249, 1252 -> R.drawable.mix
		// Thunderstorm conditions
		1087, 1273, 1276, 1279, 1282 -> R.drawable.thunderstorm
		// Night clear conditions
		// Assuming a specific code for night clear conditions
		else -> R.drawable.clear // Assuming 'clear' is a generic icon for undefined conditions
	}

	fun formatValue(value: Double, forceRound: Boolean = false): String =
		if ((value % 1.0) == 0.0 || forceRound) {
			String.format(null, "%.0f", value)
		} else {
			value.toString()
		}
}
