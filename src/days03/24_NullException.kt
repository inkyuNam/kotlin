package days03

fun main() {
    // NullPointException
    // Java 언어로 소프트웨어를 개발하다보면 NullPointerException 이라는 오류를 자주 만나게 된다.
    // 이는 객체의 주소 값이 담겨져 있지 않는 (null 값이 들어 있는) 참조 변수를 통해 객체 접근을 시도하면 발생되는 오류이다.

    // Null Safe
    // Kotlin 은 개발자가 null 이 담겨 있는 참조변수를 통해 객체 접근을 시도할 때 오류가 발생되는 것을 방지하고자
    // 다양한 방법을 제공하고 있다.
    // 이를 통해 null 값에 대한 안정성을 확보 (null safe) 할 수 있다.

    println("---------------------------------------------------------------------------")

    // 1. !!연산자
    // !! 연산자는 null 을 허용하는 변수에 담긴 객체의 주소값을 null 을 허용하지 않는 형태의 값으로 변환하는 연산자이다.
    // 사용예시 : null 을 허용하지 않는 변수 = null 을 허용하는 변수 !! (a=b!!)
    // null 을 허용하는 변수에 담긴 값을 null 을 허용하지 않는 형태의 변수에 담을 경우 사용한다.
    // 변환 과정에서 null 값이 들어있을 경우 오류가 발생한다.
    // 따라서 이 연산자의 사용은 권장하지 않는다.
    testFun1("출력할 메시지")
    // testFun1(null)

    // ? : null 을 허용하지 않는 변수를 허용하는 변수로 변경

    println("---------------------------------------------------------------------------")

    // 2. ?: 연산자
    // 참조변수에 null 이 들어있으면 지정된 기본값을 적용한다.
    testFun2("출력될 문자열")
    testFun2(null)

    println("---------------------------------------------------------------------------")

    // 3. ?. 연산자
    // 전달 또는 대입된 변수에 null 이 있다면 사용된 멤버메서드 등을 null 로 변환
    testFun3("문자열")
    testFun3(null)

    println("---------------------------------------------------------------------------")


    // 변수명:자료형?   - null 을 허용하는 자료형으로 지정
    // 변수이름!! - 변수값이 null 을 허용하지 않는 형태로 변환
    // 변수이름?: - 변수값이 null 이라면 지정된 기본값이 반환
    // 변수이름?. - 메서드 호출시 변수값이 null 이라면 메서드가 호출되지 않고 null 을 반환

    println("---------------------------------------------------------------------------")
    
    // 스마트 캐스팅
    testFun4("안녕하세요")
    testFun4(null)
}

fun testFun4(str: String?) {
    if(str is String){  // is 의 대상인 str 이 null 을 저장하고 있으면 결과는 false 
        println(str.length)
    }
    // null 을 허용하는 변수가 null 값이 들어있지 않다는 것을 보장해주면 null 을 허용하지 않는 String 타입으로 스마트캐스팅이 발생
    if(str != null){    // if 문 내부에는 null 이 아닌 str 일때만 실행되므로 null 값을 허용하지 않는 변수로 스마트캐스팅 효과를 갖을 수 있다.
        println(str.length)
    }
    // if 문을 통해 null 허용 변수에 null 갑싱 아닌 객체의 주소 값이 들어 있음을 검사해주면
    // if 문 내부에서는 null 을 허용하지 않는 변수로 변환되어 사용할 수 있다.
    // if 문이 종료되면 다시 null 허용 변수가 된다.
    // 이때 비교연산은 != 보다 is 추천
}
fun testFun5(str:Any?){
    if(str is String){
        println(str.length)
    }
    // 비교 연산자(!=) 로 검사할 경우(스마트캐스팅) 타입이 Any 인 경우 컴파일 오류가 발생한다.
}

fun testFun3(str:String?){
    println("testFun3 str : $str")   // null 을 허용하지 않는 변수에 값을 옮기지 않으면 에러는 발생하지 않는다.
    println("testFun3 str length : ${str?.length}")
}


fun testFun2(str:String?){
    val value:String = str?:"default String"    // null 값을 대비한 기본값 지정
    // str 에 null 값이 지정되어 있다면 뒤에 지정해둔 기본값이 대신 사용된다.
    println("testFun2 value = $value")
}

fun testFun1(str:String?){
    val value:String = str!!
    // null 을 허용하는 변수에 담긴 값을 null 을 허용하지 않는 형태의 값으로 변환 : !!
    // !! 연산을 사용했더라도, 이미 변수에 null 이 들어있다면, 그 변수는 null 허용변수이며,
    // 눈가리기식의 변환만 이루어질 뿐이다.
    // null 값을 허용하지 않는 value 변수에 str!! 에 들어있는 null 값을 넣는 순간 에러가 발생한다.
    // 따라서 이 연산자의 사용은 권장하지 않는다.
    println("testFun1 value : $value")
}