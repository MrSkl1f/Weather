package ru.weather.client.ui.screens.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun LoadingScreen(
	modifier: Modifier = Modifier
) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.then(modifier),
		contentAlignment = Alignment.Center
	) {
		CircularProgressIndicator(
			modifier = Modifier.size(75.dp),
			color = MaterialTheme.colorScheme.primary,
			strokeWidth = 3.dp,
			strokeCap = StrokeCap.Round
		)
	}
}
