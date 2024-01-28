package ru.weather.client.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Info(
	text: String,
	@DrawableRes icon: Int,
	modifier: Modifier = Modifier,
	textBlockWidth: Dp = 120.dp,
	fontSize: TextUnit = 20.sp,
	iconSize: Dp = 22.dp,
	value: String = "",
	valueContent: @Composable BoxScope.() -> Unit = {
		TextView(
			text = value,
			modifier = Modifier.align(Alignment.CenterEnd),
			fontSize = fontSize
		)
	}
) {
	Row(modifier = modifier) {
		Box(modifier = Modifier.width(textBlockWidth)) {
			TextView(
				text = text,
				modifier = Modifier.align(Alignment.CenterStart),
				fontSize = fontSize
			)
		}
		Image(
			painter = painterResource(id = icon),
			contentDescription = null,
			modifier = Modifier
				.size(iconSize)
				.align(Alignment.CenterVertically)
		)
		Box(
			modifier = Modifier.weight(1f),
			content = valueContent
		)
	}
}