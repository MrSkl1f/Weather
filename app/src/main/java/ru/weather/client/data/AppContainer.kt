package ru.weather.client.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.weather.client.network.WeatherService

interface AppContainer {
	val weatherRepository: WeatherRepository
}

class DefaultAppContainer : AppContainer {

	private val client = OkHttpClient.Builder()
		.addInterceptor(
			HttpLoggingInterceptor().apply {
				setLevel(HttpLoggingInterceptor.Level.BODY)
			}
		)
		.build()

	private val retrofit = Retrofit.Builder()
		.addConverterFactory(GsonConverterFactory.create())
		.client(client)
		.baseUrl(BASE_URL)
		.build()

	private val retrofitService by lazy {
		retrofit.create(WeatherService::class.java)
	}

	override val weatherRepository: WeatherRepository by lazy {
		NetworkWeatherRepository(retrofitService)
	}

	companion object {
		private const val BASE_URL = "https://api.weatherapi.com/v1/"
	}
}