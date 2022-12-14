package days01

fun main() {
    val r1:Int
    // 코틀린에서 변수를 선언하면 보통 변수이름 옆에 콜론(:) 과 함께 자료형을 기술
    val r2 = 100
    // 변수에 입력되는 값이 정수라면 자료형을 따로 쓰지 않아도 그 변수는 Int 형으로 생성된다.
    // 변수를 선언하고 초기화되는 값의 자료형이 명확하다면 변수선언의 자료형부분은 생략 가능하다.

    val r3 = testFun1(100,200)
    // 함수의 리턴값의 자료형이 Int 자료형으로 명확하기 때문에 따로 변수의 자료형을 쓰지 않는다.
    val r4 = testFun2(100,200)
    val r5 = testFun3(100,200)
    println("------------------------------------------------")

    // 람다함수 : 함수의 초간단 간략형 표현으로 , 함수의 몸체를 변수에 담아 사용하도록 변형한 형태
    val lambda1 : (Int,Int) -> Int = {a1:Int,a2:Int -> a1+a2} // 람다함수의 풀 버전 사용
    // (Int,Int) : 매개변수의 갯수와 자료형
    // {a1:Int, a2:Int -> a1+a2} 앞에 정의된 자료형에 맞춰 사용되는 실제 매개변수와 연산식&리턴값
    // Int = & -> a1+a2 : 리턴값의 자료형과 리턴값
    // lambda1 : 함수의 이름
    // : (Int,Int) -> Int : 함수의 전체 자료형(매개변수와 리턴값)
    // {a1:Int,a2:Int -> a1+a2} : a1,a2 는 실제 매개변수 a1+a2 는 실제 리턴값

    val r6 = lambda1(100,200)
    println("r6 : $r6")


    val lambda2 = {a1:Int,a2:Int -> a1+a2}  // 매개변수, 리턴값의 자료형이 명확하다면 ':' 이후부터 '=' 이전까지 생략 가능하다.
    // (Int,Int) -> Int : 함수의 원형(형태만 기술한 원본형) 을 생략한 형태
    val r7 = lambda2(100,200)
    println("r7 : $r7")


    val lambda3 : (Int,Int) -> Int = {a1,a2 -> a1+a2}
    // 헤더를 생략하지 않고 함수 바디쪽 자료형을 생략한 형태
    val r8 = lambda3(100,200)
    println("r8 : $r8")


    // 함수의 몸체에 여러 라인의 명령이 필요한 경우 원래의 함수 형태 호출
    val lambda4 = {a1:Int, a2:Int ->
        val r1 = a1 + a2
        val r2 = a1 - a2
        r1 * r2 // 맨 마지막에 리턴값만 쓰면, 람다함수의 리턴값으로 인식
    }
    val r9 = lambda4(100,200)
    println("r9 : $r9")

    
    // 매개변수와 리턴값이 없는 람다함수
    val lambda5 : () -> Unit = {print("lambda5 호출")}
    lambda5()
}

// 1. 함수의 리턴값이 호출된 곳에서 리턴값을 받는 변수의 자료형을 결정
fun testFun1(a1:Int,a2:Int):Int{
    return a1+a2
}

// 2. 함수의 리턴값이 간단한 수식으로 해결된다면 = 과 함께 연결하여 return 명령을 대신한다.
// testFun1 과 testFun2 는 같은 동작을 하는 함수이다.
fun testFun2(a1:Int, a2:Int) : Int = a1+a2

// 3. 리턴값의 자료형이 아래와 같이 정수와 정수의 연산이어서 그 결과도 정수라면 그리고 그 정수가
//      리턴될거라면 함수의 리턴자료형도 생략 가능하다.
fun testFun3(a1:Int,a2:Int) = a1 + a2