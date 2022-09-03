package days02

fun main() {

    val obj2:SubClass2 = SubClass2()
    // 오버라이딩 된 메서드를 실행한다.
    obj2.superMethod2()
    // 부모클래스의 레퍼런스변수에 자식클래스의 인스턴스를 저장
    val obj3:SuperClass2 = SubClass2()
    // 부모클래스의 레퍼런스 변수로 호출한 메서드는... 자식 클래스에서 재정의된 메서드가 우선 실행된다.
    obj3.superMethod2()
    println("-----------------------------------------------------------------------")
    
    testFun(obj2)   // 전달인수로 자식 인스턴수 주소를 저장하고 자식클래스 참조변수 전달
    testFun(obj3)   // 전달인수로 자식 인스턴스 주소를 저장하고 부모클래스 참조변수 전달

    val obj4:SuperClass2 = SuperClass2()
    testFun(obj4)
}

// SuperClass2 를 상속받은 모든 자식클래스의 인스턴스는 전달인수로 전달될 수 있다.

fun testFun(obj:SuperClass2){
    obj.superMethod2()
}

open class SuperClass2 {
    // 오버라이드될 부모클래스의 메소드는 반드시 앞에 open 을 붙여서 쓴다.
    open fun superMethod2(){
        println("SuperClass2 의 SuperMethod2")
    }
}

class SubClass2 : SuperClass2(){
    override fun superMethod2(){
        // super.superMethod2() // 부모클래스의 오버라이딩 되기전 메서드 호출 : super 키워드 이용
        println("SubClass2 의 오버라이딩 된 superMethod2")
    }
}