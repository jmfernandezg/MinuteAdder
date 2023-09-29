package com.affinipay.minuteadder

object MinuteAdder {
 private def parseTime(time: String): (Int, Int, String) = {
    val timeSplit = time.split(":")
    val minuteSplit = timeSplit(1).split(" ")

    val hour = timeSplit(0).toInt
    val minute = minuteSplit(0).toInt
    val meridian = minuteSplit(1)

    (hour, minute, meridian)
  }

  private def completeTime(int: Int): String = {
    if (int.toString().length() == 1) s"0$int" else int.toString()
  }

  def addMinutes(time: String, minutes: Int): String = {
    val timeParsed = parseTime(time)

    val totalMinutes = timeParsed._1 * 60 + timeParsed._2 + minutes
    val totalHours = totalMinutes / 60

    val newMinutes = totalMinutes % 60
    val newHours = if (totalHours > 12) totalHours - 12 else totalHours

    val newMeridian = if (timeParsed._1.<(12) && totalHours.>=(12))
      timeParsed._3 match {
        case "AM" => "PM"
        case "PM" => "AM"
      } else timeParsed._3

     s"$newHours:${completeTime(newMinutes)} $newMeridian"
  }

  
}