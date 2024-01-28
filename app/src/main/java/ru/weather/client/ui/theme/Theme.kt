package ru.weather.client.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
	primary = Purple80,
	secondary = PurpleGrey80,
	tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
	primary = DarkByzantineBlue,
	background = LightCobaltBlue,
	/* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun WeatherTheme(
	content: @Composable () -> Unit
) {
	MaterialTheme(
		colorScheme = LightColorScheme,
		typography = Typography,
		content = content
	)
}