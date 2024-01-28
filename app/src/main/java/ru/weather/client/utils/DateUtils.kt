package ru.weather.client.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

	fun formatDate(sourceDate: String?) = sourceDate?.let {
		val parser = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
		val formatter = SimpleDateFormat("dd EEE, MMM", Locale.ENGLISH)
		val parsedDate = parser.parse(it)
		parsedDate?.let { date -> formatter.format(date) }
	}
}
