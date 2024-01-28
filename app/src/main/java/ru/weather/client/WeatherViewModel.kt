package ru.weather.client

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.weather.client.data.WeatherRepository
import ru.weather.client.network.models.Weather
import java.io.IOException

sealed interface WeatherUiState {
	data class Success(val weather: Weather) : WeatherUiState
	data object Error : WeatherUiState
	data object Loading : WeatherUiState
}

class WeatherViewModel(
	private val weatherRepository: WeatherRepository
) : ViewModel() {

	var weatherUiState: WeatherUiState by mutableStateOf(WeatherUiState.Loading)
		private set

	init {
		getWeather()
	}

	fun getWeather(
		city: String = "Moscow",
		days: Int = 4,
	) {
		viewModelScope.launch {
			weatherUiState = WeatherUiState.Loading
			weatherUiState =
				try {
					WeatherUiState.Success(
						weatherRepository.getWeather(
							city = city,
							key = "9e742f7d0fb6441ea9c84330242701",
							days = days
						)
					)
				} catch (e: IOException) {
					WeatherUiState.Error
				} catch (e: HttpException) {
					WeatherUiState.Error
				}
		}
	}

	companion object {
		val Factory: ViewModelProvider.Factory = viewModelFactory {
			initializer {
				val application = (this[APPLICATION_KEY] as WeatherApplication)
				val weatherRepository = application.container.weatherRepository
				WeatherViewModel(weatherRepository = weatherRepository)
			}
		}
	}
}