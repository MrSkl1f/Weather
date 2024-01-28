package ru.weather.client

import android.app.Application
import ru.weather.client.data.AppContainer
import ru.weather.client.data.DefaultAppContainer

class WeatherApplication : Application() {

	lateinit var container: AppContainer

	override fun onCreate() {
		super.onCreate()
		container = DefaultAppContainer()
	}
}