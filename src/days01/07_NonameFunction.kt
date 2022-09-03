package days01

fun main() {
     fun testFunction1(){
          println("testFunction1입니다.")
     }
    // val testFunction2 = testFunction1 // 에러
    // 자바스크립트에서 가능했던 선언적 함수의 직접 변수 저장은 불가능하다.

    // 아래와 같이 익명함수 저장은 가능하다.
    // 익명함수 생성
    val t1 = fun(x1:Int,x2:Int) : Int{
        return x1*x2
    }
    t1(20,30)
    var a1 = t1(20,30)
    println("a1 : $a1")
    var t2 = t1 // 변수에 저장된 함수의 몸체는 다른 변수에도 저장이 가능하다.
    var a2= t2(30,40)
    println ("a2 : $a2")
    // 1. 변수가 저장한 익명함수로 전달
    testFunc1(t1, 100, 200)

    // 2. 전달인수로 직접 익명함수를 써준다.
    testFunc1(fun(x1:Int,x2:Int):Int{return x1-x2},300,400)

    // 3. 전달인수로 람다함수의 몸체를 전달 : 매개변수가 헤더(원형) 이므로 몸체를 보내서 자연스럽게 저장되도록 한다.
    testFunc1({x1:Int,x2:Int->x1+x2},500,600)
    // 전달인수와 매개변수의 조합은 t3:(Int,Int)-> Int = {x1:Int,x2:Int -> x1+x2} 와 같다.
    println("--------------------------------------------")

    // 함수가 리턴되는 함수의 리턴값을 변수에 저장하는 경우는 이미 함수의 매개변수 & 리턴값의 자료형이 명확히
    // 결정되어 리턴되기 때문에 아래와 같이 별도의 자료형 기술없이 사용한다.
    // 함수가 리턴값으로 리턴되어 변수에 저장된다.
    var t4 = testFunc2()
    var r2 = t4(600,700)    // 정수형 매개변수 두 개, 정수리턴으로 된 함수가 리턴되어 t2 에 저장되고 실행되는 형태
    println("r2 : $r2")
    var t5 = testFunc3()
//    var t5:(Int,Int)->Int = testFunc3()
    var r3 = t5(600,700)    // 정수형 매개변수 두 개, 정수리턴으로 된 함수가 리턴되어 t2 에 저장되고 실행되는 형태
    println("r3 : $r3")
}
// 리턴값이 함수인 함수의 정의
// 함수의 리턴 자료형은 리턴되는 람다함수의 헤더((Int,Int)->Int) 를 써준다.
// 실제 리턴되는 함수의 내용은 return 키워드와 함께 익명함수든 람다함수든 자유롭게 써준다.
fun testFunc2():(Int,Int)->Int{
    return fun(x1:Int,x2:Int):Int{return x1*x2}
}
// 람다함수로 리턴하는 경우
fun testFunc3():(Int,Int)->Int{
    return {x1:Int,x2:Int->x1-x2}   // 람다함수가 리턴값으로 사용
}


// 함수의 몸체가 전달되어서 호출되는 함수는 매개변수도 그 함수의 몸체를 받을 수 있는 변수로 준비되어야 한다.
// 아래의 매개변수중 t3 는 함수를 저장하라 수 있는 매개변수이다.
// 함수의 매개변수에 람다함수의 원형(헤더) 부분을 전달된 함수에 맞게 써서 전달 & 저장되도록 한다.
fun testFunc1(t3:(Int,Int)->Int,a1:Int,a2:Int):Unit{
    var a3 = t3(a1,a2)
    println("a3 : $a3")
}
