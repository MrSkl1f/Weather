package ru.weather.client.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Info(
	text: String,
	value: String,
	@DrawableRes icon: Int,
	modifier: Modifier = Modifier
) {
	Row(modifier = modifier) {
		Box(modifier = Modifier.width(120.dp)) {
			TextView(
				text = text,
				modifier = Modifier.align(Alignment.CenterStart),
				fontSize = 20.sp
			)
		}
		Image(
			painter = painterResource(id = icon),
			contentDescription = null,
			modifier = Modifier
				.size(22.dp)
				.align(Alignment.CenterVertically)
		)
		Box(
			modifier = Modifier.weight(1f)
		) {
			TextView(
				text = value,
				modifier = Modifier.align(Alignment.CenterEnd),
				fontSize = 20.sp
			)
		}
	}
}