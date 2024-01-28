package ru.weather.client.network.models

data class Weather(
	val location: Location? = null,
	val current: Current? = null,
)
