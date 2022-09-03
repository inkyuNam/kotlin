package days02

import days01.selectWeekday

fun main() {
    print("연도 입력 : ")
    val year:Int = readLine()!!.toInt()
    print("월 입력 : ")
    val month:Int = readLine()!!.toInt()
    print("일 입력 : ")
    val day:Int = readLine()!!.toInt()

    var days:Int = somdays(year,month,day)  // 전달인수에 year,day 도 추가
    // somedays 함수 안에서 월에 해당하는 날짜수 계산할 때 when 을 이용하지 말고, 배열 생성후 반복실행과 함께 계산
    val temp:Int = days % 7
    val weekday:String = selectWeekday(temp)
    println(weekday)
}
fun somdays(year:Int,month:Int,day:Int):Int {
    var days = 0
    var mdays = arrayOf(0,31,28,31,30,31,30,31,31,30,31,30,31)
    if((year%4==0)&&(year%100!=0)||(year%400==0)) mdays[2] = 29

    days = (year-1)*365
    val y:IntRange = 1..(year-1)
    for(i in y){
        if((i%4==0)&&(i%100!=0)||(i%400==0)) days++
    }
    var i:Int = 0
    while(i<month){
        days += mdays[i]
        i++
    }
    days += day
    return days
}

fun selectWeekday(temp: Int): String=when(temp) {
    1->"토요일입니다."
    2->"일요일입니다."
    3->"월요일입니다."
    4->"화요일입니다."
    5->"수요일입니다."
    6->"목요일입니다."
    0->"금요일입니다."
    else -> "잘못된 연산입니다."
}