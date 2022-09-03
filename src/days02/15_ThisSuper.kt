package days02

fun main() {
TestClass41(50)

}

// this 의 용도
// 1. 멤버변수와 매개변수(또는 지역변수) 의 이름이 같을 때 그들을 구분하기 위해 사용
// 2. 대표생성자가 있는 경우 보조 생성자에서 기본생성자의 매개변수 갯수와 자료형에 맞춰서 반드시 호출해야 하는데,
//      이때 this 키워드를 사용한다.
// 3. 메서드 내부에 다른 메서드(이름하여 지역 매서드 : 지역변수와 같은 의미) 를 만들어 쓸 수 있는데
//      멤버메서드와 구분하기 위해 사용한다.

class TestClass41(var a2:Int) {
    var a1: Int = 200

    // 보조생성자는 반드시 대표생성자를 this 키워드를 이용해서 호출
    // 대표생성자의 매개변수가 멤버변수로 생성이 되어야 하는데, 호출되지 않으면 생성되지 않기 때문.
    constructor() : this(300) {
    }
    fun testMethod1() {
        var a1 = 100
        println("현재 메서드의 지역변수 a1:$a1")
        println("현재 클래스의 멤버변수 a1 : ${this.a1}")

        fun testMethod2() { // 1번
            println("testMethod1 메서드 내부의 testMethod2 메서드")
        }

        testMethod2()   // 1번이 실행된다. 언제나 자기 지역이 우선
        this.testMethod2()  // 2번이 실행. this 는 언제나 멤버변수, 멤버메서드를 가리킨다.
    }

    fun testMethod2() { // 2번
        println("멤버메서드 testMethod2")
    }
}


// super 의 용도
// 1. 상속관계의 자식 생성자에서, 부모클래스의 생성자를 호출할 때, 자식클래스의 이름 옆에 부모클래스의 이름을 사용하지만
//  보조 생성자에서는 super 라는 키워드를 사용
// 2. 자식클래스에서 오버라이드된 메서드 그리고 변수를 사용할때, 인위적으로 부모의 메서드를 호출하거나 변수값을 취할 때 사용
open class SuperClass(var a2:Int) {   // 대표생성자
    open var a1 = 100
    constructor() : this(200){} // 보조 생성자
    open fun superMethod1(){
        println("SuperClass 의 superMethod1")
    }
}
// 대표생성자와 보조생성자가 모두 있는 부모 클래스는 둘 중 어떤 형태로도 상속(부모클래스 생성자호출) 이 가능
class SubClass : SuperClass(){
    override fun superMethod1(){
        super.superMethod1() // 부모클래스의 메서드
        println("super.a1 : ${super.a1}")   // 부모클래스의 멤버변수
        println("SubClass 의 superMethod1")
    }
}
class SubClass_1 : SuperClass{
    // constructor 키워드로 생성된 생성자 이름 옆에 super 키워드를 이용하여 부모 클래스의 대표 생성자 직접 호출할 수 있다.
    // 그 경우 Extends 로 연결되는 부모클래스 이름 옆의 괄호는 지워준다.
    // class SubClass_1 : SuperClass() -> class SubClass_1 : SuperClass
    constructor(a1:Int) : super(a1){}
}