package ru.weather.client

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import ru.weather.client.ui.WeatherApp
import ru.weather.client.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			WeatherTheme {
				WeatherApp()

				val view = LocalView.current
				val backgroundColor = MaterialTheme.colorScheme.background
				SideEffect {
					val window = (view.context as Activity).window
					window.statusBarColor = backgroundColor.toArgb()
					window.navigationBarColor = backgroundColor.toArgb()

					WindowCompat.getInsetsController(window, view)
						.isAppearanceLightStatusBars = true
					WindowCompat.getInsetsController(window, view)
						.isAppearanceLightNavigationBars = true
				}
			}
		}
	}
}
