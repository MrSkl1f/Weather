package ru.weather.client.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.weather.client.ui.screens.HomeScreen

@Composable
fun WeatherApp(
	modifier: Modifier = Modifier
) {
	Surface(
		modifier = modifier
			.fillMaxSize()
			.statusBarsPadding(),
		color = MaterialTheme.colorScheme.background
	) {
		HomeScreen()
	}
}