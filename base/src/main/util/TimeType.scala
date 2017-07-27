package util

/**
  * Created by jwang on 7/18/2017.
  */

object TimeType extends Enumeration {
    type TimeType = Value
    val Year = Value(1, "Year")
    val Month = Value(2, "Month")
    val Day = Value(3, "Day")
    val Week = Value(4, "Week")
    val Hour = Value(5, "Hour")
    val Minute = Value(6, "Minute")
    val Second = Value(7, "Second")
  }

