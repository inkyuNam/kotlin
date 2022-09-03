package days01

fun main() {
    // 월과 일을 입력 받아서 요일을 출력해주세요
    // 2022 년에 한해서 입력하세요
    // 2022 년 1월 1일은 토요일입니다. 상대적 위치의 값으로 요일을 선택하세요.
    print("월 입력 : ")
    val month:Int = readLine()!!.toInt()
    print("일 입력 : ")
    val day:Int = readLine()!!.toInt()

    var days:Int = sumdays(month)   // 1월부터 입력한 월의 전달까지 날짜수 계산하는 함수 제작
    days += day
    val temp:Int = days % 7

    val weekday:String = selectWeekday(temp) // 총날짜를 7로 나눈 나머지로 요일을 계산하는 함수 제작
    println(weekday)


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

fun sumdays(month: Int): Int{
      val days:Int=when(month) {
            1 -> 0
            2 -> 31
            3 -> 31 + 28
            4 -> 31 + 28 + 31
            5 -> 31 + 28 + 31 + 30
            6 -> 31 + 28 + 31 + 30 + 31
            7 -> 31 + 28 + 31 + 30 + 31 + 30
            8 -> 31 + 28 + 31 + 30 + 31 + 30 + 31
            9 -> 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31
            10 -> 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30
            11 -> 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31
            12 -> 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30
            else -> 0
        }
    return days
}

/*
fun sumdays(month:Int):Int{
    var days:Int = if(month==1) 0
    else if(month==2)31
    else if(month==3)31+28
    else if(month==4)31+28+31
    else if(month==5)31+28+31+30
    else if(month==6)31+28+31+30+31
    else if(month==7)31+28+31+30+31+30
    else if(month==8)31+28+31+30+31+30+31
    else if(month==9)31+28+31+30+31+30+31+31
    else if(month==10)31+28+31+30+31+30+31+31+30
    else if(month==11)31+28+31+30+31+30+31+31+30+31
    else if(month==12)31+28+31+30+31+30+31+31+30+31+30
    else 0
    return days
}

fun selectWeekday(temp: Int): String {
    return if(temp==1)"토요일입니다."
    else if(temp==2)"일요일입니다."
    else if(temp==3)"월요일입니다."
    else if(temp==4)"화요일입니다."
    else if(temp==5)"수요일입니다."
    else if(temp==6)"목요일입니다."
    else "금요일입니다."
}
 */
// 두 개의 함수를 when 으로 재생성해주세요.

