package days02

    // Any 클래스는 자바에서 Object 클래스와 같은 모든 클래스의 부모클래스가 되는 클래스이다.
    // 이미 만들어져있거나, 앞으로 생성될 클래스에 따로 명시하지 않아도 다른 클래스를 상속받지 않고 있다면 그 클래스는
    // Any 클래스를 상속받고 있다고 보아야한다.
    // 다만 다른 클래스를 상속 받고 있는 클래스는 그 부모 클래스가 Any 클래스를 상속 받고 있기 때문에
    // 결과적으로 자기 자신도 Any 클래스의 자식(손자) 클래스가 된다고 보아야한다.
fun main() {
    val obj1 = TestClass31()
        println("obj1 : $obj1")
        // 참조변수를 println 에 넣으면 Any 클래스에서 상속 받은 toString() 메서드가 실행되어
        // 클래스 이름과 해쉬 코드가 출력된다. obj1 : days03.testClass11@29453f44

        // Any 클래스에서 상속 받은 toString 메서드를 오버라이드 클래스는 재정의된 메서드가 실행된다.
        val obj2 = TestClass32()
        println("obj2 : $obj2")

        // 매개변수의 자료형이 Any 이기 때문에 어떤 클래스의 인스턴스가 전달인수가 되어도 무방하다.
        testFun(obj1)
        testFun(obj2)
}

fun testFun(a:Any){
    println("a : $a")
}


class TestClass31{}

class TestClass32{
    // Any 클래스에서 상속받은 toString 을 오버라이딩해서 사용할 수 있다.
    override fun toString(): String {
        return "TestClass32 객체입니다."
    }
}
