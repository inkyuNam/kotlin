package days02

fun main() {

    val obj1 = TestClass51()   // Inter1 을 상속(구현) 받은 자식 클래스
    val obj2 = TestClass52()   // Inter2 을 상속(구현) 받은 자식 클래스
    val obj3 = TestClass53()   // Inter1,Inter2 를 상속(구현) 받은 자식 클래스
    obj1.inter1_Method1()
    obj1.inter1_Method2()
    obj2.inter2_Method1()
    obj2.inter2_Method2()
    obj3.inter1_Method1()
    obj3.inter1_Method2()
    obj3.inter2_Method1()
    obj3.inter2_Method2()

    // 부모중 해당 인터페이스가 구현되어있는 객체만 전달인수로 사용이 가능
    testFun1(obj1)  // obj1 은 전달할 수 없다.
    testFun2(obj2)  // obj2 는 전달할 수 없다.
    testFun1(obj3)  // Inter1 이 구현되었으므로 전달인수로 전달 가능
    testFun2(obj3)  // Inter2 이 구현되었으므로 전달인수로 전달 가능
}
fun testFun1(obj:Inter1){
    obj.inter1_Method1()
    obj.inter1_Method2()
}
fun testFun2(obj:Inter2){
    obj.inter2_Method1()
    obj.inter2_Method2()
}

// 인터페이스 : 추상클래스가할 수 없었던 다중 상속이 가능하다.
// 자바의 버전이 업그레이드 되면서 인터페이스에도 override 의 강제성이 부여되지 않은 일반 변수와 메서드 선언이 가능해졌다.

interface Inter1{
    fun inter1_Method1(){
        println("Inter1 의 Method1 입니다.")
    }   // override 의 강제성이 부여되지 않은 메서드
    fun inter1_Method2()    // override 강제성이 부여된 메서드(몸체가 없기 때문에)
}

interface Inter2{
    fun inter2_Method1(){
        println("Inter2 의 Method1 입니다.")
    }
    fun inter2_Method2()
}

// 인터페이스의 구현은 자식 클래스 이름 옆에 ":" 과 함께 () 괄호 없이 인터페이스의 이름만 기술
class TestClass51:Inter1{
    override fun inter1_Method2() {
        println("TestClass51 의 오버라이딩 된 Method2 입니다.")
    }
}

class TestClass52:Inter2{
    override fun inter2_Method2() {
        println("TestClass52 의 오버라이딩 된 Method2 입니다.")
    }
}

// 두 개 이상의 인터페이스를 구현하려면 인터페이스 이름들을 "," 로 구분하여 기술한다.
class TestClass53:Inter1,Inter2{
    override fun inter1_Method2(){
        println("TestClass53의 inter1 에서 오버라이딩 된 Method2입니다.")
    }

    override fun inter2_Method2() {
        println("TestClass53의 inter2 에서 오버라이딩 된 Method2입니다.")
    }
}