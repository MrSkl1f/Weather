package ru.weather.client.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.weather.client.network.models.Weather

interface WeatherService {

	@GET("forecast.json")
	suspend fun getForecast(
		@Query("q")
		city: String,

		@Query("key")
		key: String,

		@Query("days")
		days: Int,

		@Query("aqi")
		aqi: String,

		@Query("alerts")
		alerts: String,
	): Weather
}
