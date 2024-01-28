package ru.weather.client.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.weather.client.R
import ru.weather.client.ui.theme.LightCobaltBlue
import ru.weather.client.ui.theme.DarkByzantineBlue
import ru.weather.client.ui.theme.LailaFontFamily
import ru.weather.client.utils.WeatherConditionUtils

@Composable
fun Temperature(
	temperature: Double,
	iconSize: Dp,
	modifier: Modifier = Modifier,
	fontSize: TextUnit = 64.sp,
	fontWeight: FontWeight = FontWeight.SemiBold,
) {
	Row(
		modifier = modifier.wrapContentSize()
	) {
		Text(
			text = WeatherConditionUtils.formatValue(temperature),
			modifier = Modifier
				.align(Alignment.CenterVertically),
			style = TextStyle(
				fontSize = fontSize,
				fontFamily = LailaFontFamily,
				fontWeight = fontWeight,
				color = DarkByzantineBlue,
				textAlign = TextAlign.Center,
			)
		)

		Image(
			painter = painterResource(id = R.drawable.progress),
			contentDescription = null,
			modifier = Modifier
				.size(iconSize)
				.align(Alignment.Top),
		)
	}
}

@Preview
@Composable
private fun TemperaturePreview() {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(color = LightCobaltBlue)
	) {
		Temperature(
			temperature = 23.1,
			iconSize = 27.dp,
			modifier = Modifier.align(Alignment.Center)
		)
	}
}