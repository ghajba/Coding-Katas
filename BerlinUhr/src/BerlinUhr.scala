import java.util.{Calendar, Date}

/**
 * Created by GHajba on 2014.02.26..
 */

object BerlinUhr {

  def secondsRow(seconds:Int):String= {
  if (seconds%2 == 0)
    return "Y";
  return "O";
}

  def singleMinuteRow(minutes:Int):String={
    return ("Y"*(minutes%5))+("O"*(4-minutes%5))
  }

  def fiveMinutesRow(minutes:Int):String={
    var res = ("Y"*(minutes/5)).toCharArray
    var i = 0;
    for (i <- 1 to res.length
      if i%3 == 0 ) {
      res(i-1) = 'R'
    }
    return res.mkString+("O"*(11-minutes/5))
  }

  def singleHoursRow(hours:Int):String={
    return ("R"*(hours%4))+("O"*(4-hours%4))
  }
  def fiveHoursRow(hours:Int):String={
    return ("R"*(hours/5))+("O"*(4-hours/4))
  }

  def main(args: Array[String]) {
    val cal:Calendar = Calendar.getInstance();
    println(secondsRow(cal.get(Calendar.SECOND)))
    println(fiveHoursRow(cal.get(Calendar.HOUR_OF_DAY)))
    println(singleHoursRow(cal.get(Calendar.HOUR_OF_DAY)))
    println(fiveMinutesRow(cal.get(Calendar.MINUTE)))
    println(singleMinuteRow(cal.get(Calendar.MINUTE)))
  }
}