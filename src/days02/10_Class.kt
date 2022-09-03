package days02

fun main() {
    
    // 자바는 프로그램 자체도 클래스이다. 클래스로 프로그램의 실행과 자료들이 모두 관리된다. -> 객체지향 프로그램
    // 객체지향 프로그램의 반대개념이 구조화프로그램이다. 이는 함수 중심으로 프로그램 시작과 끝이 관리된다.
    // 코틀린은 자료들은 클래스로, 프로그램 시간과 끝 관리는 함수로 병행하여 운용되는 형태이다.
    
    // 생성된 클래스 형태로 객체를 생성한다.
    // 자바문법 : TestClass1 obj1 = new TestClass1()
    // 코틀린 : val 참조변수이름 : 클래스이름 = 클래스이름()
    val obj1:TestClass1 = TestClass1()  // 정의된 클래스의 객체 생성
    val obj2:TestClass2 = TestClass2()  // new 를 쓰지 않아도 새공간이 할당된다.
    // new 를 쓰지 않는다고 새로운 공간이 만들어지지 않는 것이 아니라 사용상 생략되어 사용될 뿐이다.
    println("obj1 : $obj1")
    println("obj2 : $obj2")
    val obj3 = obj1
    println("obj3 : $obj3")

    val obj5 = TestClass3() // 자료형이 대입되는 객체의 자료형에 의해 명확히 결정되므로
    // 변수 옆에:TestClass3 는 생략할 수 있다.
    println("obj5.a1 : ${obj5.a1}")
    println("obj5.a2 : ${obj5.a2}")
    // 멤버변수에 접근하는 순간 내부적으로 getter 와 setter 가 실행되어 값을 이용하게 된다.

    // obj5.a1 = 100    // 에러 : setter 가 없는 a1 변수는 값을 변경할 수 없다.
    obj5.a2 = 200
    println("obj5.a2 : ${obj5.a2}")
    obj5.testMethod1()
    obj5.testMethod2()
}

class TestClass3{
    val a1:Int = 0  // getter 만 있는 val 변수는 밑줄이 없다.
    var a2:Int = 0  // getter 와 setter 가 모두 생성되는 var 변수는 밑줄이 표시된다.
    // 멤버변수 : 멤버변수는 var 또는 val 로 자유롭게 생성이 가능하다.
    // 자료형은 초기값에 따라 결정되도록 생략 가능 하다.
    // 코틀린 클래스에서 생성된 멤버변수는 기본적으로 private 로 생성된다.

    // 멤버메서드
    fun testMethod1(){
        println("testMethod1")
    }
    fun testMethod2(){
        println("testMethod2")
    }
}

class TestClass1{
    // 비어있는 클래스의 생성
}
class TestClass2    // 비어있는 클래스를 생성 & {} 생략
                    // 비어있는 클래스를 생성한다면 {} 를 생략할 수 있다.