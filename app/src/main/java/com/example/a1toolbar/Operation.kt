package com.example.a1toolbar

class Operation (private  val  firstTime: String, private  val secondTime: String) {
    fun plusTimes(): String {
        val totalSeconds = convertToSeconds(firstTime) + convertToSeconds(secondTime)
        return convertToTimeString(totalSeconds)
    }
    fun minusTimes(): String {
        val totalSeconds = convertToSeconds(firstTime) - convertToSeconds(secondTime)
        return if (totalSeconds < 0) "Time cannot be negative" else convertToTimeString(totalSeconds)
    }
    private fun convertToSeconds(time: String): Int {
        val regex = Regex("(\\d+h)?(\\d+m)?(\\d+s)?")
        val mathResult = regex.matchEntire(time)
        if (mathResult != null) {
            val (hours, minutes, seconds) = mathResult.destructured
            val hoursSeconds = hours.removeSuffix("h").toIntOrNull()?.times(3600) ?: 0
            val minutesSeconds = minutes.removeSuffix("m").toIntOrNull()?.times(60) ?: 0
            val secunds = seconds.removeSuffix("s").toIntOrNull() ?: 0
            return hoursSeconds + minutesSeconds + secunds
        }
        return 0
    }
    private fun convertToTimeString(totalSeconds: Int): String {
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val secs = totalSeconds % 60

        (if (hours > 0) "${hours}h" else "") +
                (if (minutes > 0) "${hours}m" else "")
        (if (secs > 0) "${hours}s" else "")
        return  "$hours:$minutes:$secs"


//        fun formatMilliseconds(milliseconds: Long): String {
//         val totalSeconds = milliseconds / 1000
//        val minutes = totalSeconds / 60
//        val seconds = totalSeconds % 60
//         return "$minutes:$seconds"
    }
}
