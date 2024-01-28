package ru.weather.client.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
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

	UpdateScreen(weatherViewModel)
	val weather = weatherViewModel.weatherUiState.collectAsState()

	when (weather.value) {
		is WeatherUiState.Loading -> LoadingScreen(modifier)

		is WeatherUiState.Success -> WeatherScreen(
			weather = (weather.value as WeatherUiState.Success).weather,
			modifier = modifier
		)

		is WeatherUiState.Error -> ErrorScreen(modifier)
	}
}

@Composable
private fun UpdateScreen(
	weatherViewModel: WeatherViewModel
) {
	val lifecycleOwner = LocalLifecycleOwner.current

	DisposableEffect(lifecycleOwner) {
		val observer = LifecycleEventObserver { _, event ->
			if (event == Lifecycle.Event.ON_RESUME) {
				weatherViewModel.getWeather()
			}
		}
		lifecycleOwner.lifecycle.addObserver(observer)

		onDispose {
			lifecycleOwner.lifecycle.removeObserver(observer)
		}
	}
}
