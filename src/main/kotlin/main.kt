fun secondsToText(seconds: Long): String {
    return when {
        seconds <= 60 -> "только что"
        seconds <= 60 * 60 -> minutesToText((seconds / 60).toInt()) + " назад"
        seconds <= 24 * 60 * 60 -> hoursToText((seconds / (60 * 60)).toInt()) + " назад"
        seconds <= 48 * 60 * 60 -> "вчера"
        seconds <= 72 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
}

fun minutesToText(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes % 100 != 11 -> "$minutes минуту"
        minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursToText(hours: Int): String {
    return when {
        hours % 10 == 1 && hours % 100 != 11 -> "$hours час"
        hours % 10 in 2..4 && hours % 100 !in 12..14 -> "$hours часа"
        else -> "$hours часов"
    }
}

fun agoToText(lastVisit: Long): String {
    val seconds = (System.currentTimeMillis() - lastVisit) / 1000
    return secondsToText(seconds)
}
