package ru.weather.client.ui.screens.weather

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.weather.client.R
import ru.weather.client.network.models.Weather
import ru.weather.client.ui.components.Info
import ru.weather.client.ui.components.Temperature
import ru.weather.client.ui.components.TextView
import ru.weather.client.utils.WeatherConditionUtils

@Composable
fun WeatherScreen(
	weather: Weather,
	modifier: Modifier,
) {
	val location = remember(weather) { weather.location }
	val current = remember(weather) { weather.current }
	val condition = remember(current) { current?.condition }

	Column(
		modifier = modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Location(
			name = location?.name ?: "",
			country = location?.country ?: "",
			time = location?.time ?: "",
			modifier = Modifier.padding(top = 88.dp)
		)

		Main(
			icon = condition?.getIcon() ?: R.drawable.sunny,
			temperature = current?.temperature ?: 0.0,
			text = condition?.text ?: "",
			modifier = Modifier.padding(top = 50.dp)
		)

		FeelsLike(
			feelsLike = current?.feelsLike ?: 0.0,
			modifier = Modifier.padding(top = 50.dp)
		)

		AdditionalInfo(
			wind = current?.wind ?: 0.0,
			humidity = current?.humidity ?: 0,
			pressure = current?.getAtmosphericPressure() ?: 0.0,
			modifier = Modifier.padding(top = 50.dp)
		)
	}
}

@Composable
private fun Location(
	name: String,
	country: String,
	time: String,
	modifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier
	) {
		TextView(
			text = "$name, $country",
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold
		)

		TextView(
			text = time.split(" ").last(),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold
		)
	}
}

@Composable
private fun Main(
	@DrawableRes icon: Int,
	temperature: Double,
	text: String,
	modifier: Modifier = Modifier,
) {

	Column(
		modifier = modifier,
		verticalArrangement = Arrangement.spacedBy(12.dp)
	) {
		Image(
			painter = painterResource(id = icon),
			contentDescription = null,
			modifier = Modifier
				.size(60.dp)
				.align(Alignment.CenterHorizontally),
		)

		Temperature(
			temperature = temperature,
			iconSize = 27.dp,
		)

		TextView(
			text = text,
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
		)
	}
}

@Composable
private fun FeelsLike(
	feelsLike: Double,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier
	) {
		TextView(
			text = stringResource(id = R.string.feels_like),
			modifier = Modifier
				.align(Alignment.CenterVertically),
		)

		Temperature(
			temperature = feelsLike,
			iconSize = 14.dp,
			modifier = Modifier
				.align(Alignment.CenterVertically),
			fontSize = 24.sp,
			fontWeight = FontWeight.SemiBold
		)
	}
}

@Composable
private fun AdditionalInfo(
	wind: Double,
	humidity: Int,
	pressure: Double,
	modifier: Modifier = Modifier
) {
	val formattedWind = WeatherConditionUtils.formatValue(wind)
	val formattedPressure = WeatherConditionUtils.formatValue(pressure, true)
	Column(
		modifier = modifier.width(250.dp)
	) {
		Info(
			text = stringResource(id = R.string.wind),
			icon = R.drawable.air,
			value = "$formattedWind m/s"
		)
		Info(
			text = stringResource(id = R.string.humidity),
			icon = R.drawable.humidity,
			value = "${humidity}%"
		)
		Info(
			text = stringResource(id = R.string.pressure),
			icon = R.drawable.pressure,
			value = "$formattedPressure atm"
		)
	}
}
