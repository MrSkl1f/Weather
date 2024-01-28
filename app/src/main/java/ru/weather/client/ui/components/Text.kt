package ru.weather.client.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ru.weather.client.ui.theme.LailaFontFamily

@Composable
fun TextView(
	text: String,
	modifier: Modifier = Modifier,
	fontSize: TextUnit = 24.sp,
	fontWeight: FontWeight = FontWeight.SemiBold
) {
	Text(
		text = text,
		modifier = modifier,
		style = TextStyle(
			fontSize = fontSize,
			fontFamily = LailaFontFamily,
			fontWeight = fontWeight,
			color = MaterialTheme.colorScheme.primary,
			textAlign = TextAlign.Center,
		)
	)
}