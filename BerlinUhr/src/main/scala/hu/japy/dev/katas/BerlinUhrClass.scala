package hu.japy.dev.katas

import java.util.{Date, Calendar}
import java.text.SimpleDateFormat

/**
 * Created by GHajba on 2014.02.27..
 */
class BerlinUhrClass {

  def secondsRow(seconds:Int):String= {
    if (seconds%2 == 0)
      return "Y";
    return "O";
  }

  def singleMinuteRow(minutes:Int):String={
    return ("Y"*(minutes%5))+("O"*(4-minutes%5))
  }

  def fiveMinutesRow(minutes:Int):String={
    val res = ("Y"*(minutes/5)).toCharArray
    var i = 0;
    for (i <- 1 to res.length
         if i%3 == 0 ) {
      res(i-1) = 'R'
    }
    return res.mkString+("O"*(11-minutes/5))
  }

  def singleHoursRow(hours:Int):String={
    return ("R"*(hours%5))+("O"*(4-hours%5))
  }
  def fiveHoursRow(hours:Int):String={
    return ("R"*(hours/5))+("O"*(4-hours/5))
  }

  def berlinUhrAsSingleString(time:String):String = {
    val timeParts = time split ":"
    val hours = timeParts(0).toInt
    val minutes = timeParts(1).toInt
    val seconds = if(timeParts.length == 3) timeParts(2).toInt else 0

    return secondsRow(seconds)+fiveHoursRow(hours)+singleHoursRow(hours)+fiveMinutesRow(minutes)+singleMinuteRow(minutes)

  }

  def showBerlinUhr(time:String) ={

    val berlinString = berlinUhrAsSingleString(time)
    println(berlinString.substring(0,1))
    println(berlinString.substring(1, 5))
    println(berlinString.substring(5,9))
    println(berlinString.substring(9,20))
    println(berlinString.substring(20))
  }

  def main(args: Array[String]):Unit =
  {
    val dateFormat = new SimpleDateFormat("HH:mm:ss")
    println(dateFormat.format(new Date))
  }

}
