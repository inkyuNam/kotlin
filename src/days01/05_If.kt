package days01

fun main() {
    // 기본 if 문
    val a1:Int = 10
    if(a1==10)println("a1은 10입니다.")
    if(a1!=10){
        println("a1은10이 아닙니다.")
    }
    println("--------------------------------------------------------")

    // else 문 : 조건식이 만족하지 않을 경우 수행될 부분
    if(a1==10)println("a1은10입니다.")
    else println("a1은 10이 아닙니다.")

    if(a1==20){
        println("a1 은 20입니다.")
    }else{
        println("a1은 20이 아닙니다.")
    }
    println("--------------------------------------------------------")

    // else if
    if(a1==5){
        println("a1은 5입니다.")
    }else if(a1==10){
        println("a1은 10입니다.")
    }else if(a1==20){
        println("a1은 20입니다.")
    }else{
        println("a1은 5,10,20 이 아닙니다.")
    }
    println("--------------------------------------------------------")

    var a4:String = ""
    var a5:Int = 10

    // 자바와 코틀린이 같아지는 if 문의 사용
    if(a5==10) a4="10입니다."
    else a4 = "10이 아닙니다."
    println("a4:$a4")

    // 자바에서만 사용하는 if문의 변형 사용 코틀린에서는 이와 같은 문법을 사용할 수 없다.
//    var b:Int = 10
//    var a6 = (b!=10)? "10과 같습니다." : "10과 다릅니다.";

    // 코틀린에서만 사용할 수 있는 if 문의 변형 사용
    val a6:String = if(a5==10) "10입니다." else "10이 아닙니다."
    println("a6 : $a6")

    val a7:String = if(a5==10) {
        println("블록1 수행")
        "10입니다."    // 변수에 입력될 값은 각 경우에 해당하는 영역 맨 마지막에 써준다.
    }else{
        println("블록2수행")
        "10이 아닙니다."
    }
    println("a7:$a7")
}