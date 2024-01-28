package ru.weather.client.data

import ru.weather.client.network.WeatherService
import ru.weather.client.network.models.Weather

interface WeatherRepository {

	suspend fun getWeather(
		city: String,
		key: String,
		days: Int,
	): Weather
}

class NetworkWeatherRepository(
	private val weatherService: WeatherService
) : WeatherRepository {

	override suspend fun getWeather(
		city: String,
		key: String,
		days: Int,
	): Weather = weatherService.getForecast(
		city = city,
		key = key,
		days = days,
		aqi = "no",
		alerts = "no"
	)
}
