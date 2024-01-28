package ru.weather.client.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.weather.client.WeatherUiState
import ru.weather.client.WeatherViewModel
import ru.weather.client.ui.screens.weather.ErrorScreen
import ru.weather.client.ui.screens.weather.LoadingScreen
import ru.weather.client.ui.screens.weather.WeatherScreen

@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
) {
	val weatherViewModel: WeatherViewModel =
		viewModel(factory = WeatherViewModel.Factory)

	when (val weatherUiState = weatherViewModel.weatherUiState) {
		is WeatherUiState.Loading -> LoadingScreen(modifier)

		is WeatherUiState.Success -> WeatherScreen(
			weather = weatherUiState.weather,
			modifier = modifier
		)

		is WeatherUiState.Error -> ErrorScreen(modifier)
	}
}
