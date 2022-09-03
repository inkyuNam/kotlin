package days02

fun main() {
    val s1 = SubClass11()    // 자식 클래스의 객체 생성
    println("s1.subMember1 : ${s1.subMember1}")
    s1.subMethod1()
    println("s1.superMember1 : ${s1.superMember1}")
    s1.superMethod1()
}
// 상속이 될 클래스들이 final 로 만들어진다. 이는 상속이 불가능하므로, open 키워드를 앞에 붙인다.
open class SuperClass11{
    var superMember1 = 100
    fun superMethod1(){
        println("SuperClass1 의 메서드입니다.")
    }
}

// 상속은 extends 키워드 없이 부모 클래스 이름을 ':' , '()' 와 함께 클래스 옆에 써준다.
class SubClass11 : SuperClass11(){
    val subMember1 = 200
    fun subMethod1(){
        println("SubClass1 의 메서드입니다.")
    }
}

// 부모클래스에 대표생성자가 있다면
open class SuperClass12(val a1:Int){}
// 상속을 위해 부모클래스 이름을 쓰고 괄호를 연결했다면,
// 괄호 안에 부모클래스의 대표생성자 매개변수에 맞게 전달인수를 전달해준다.
// 그렇지 않으면 부모클래스의 멤버변수가 생성되지 않고, 상속도 안되는 에러를 발생한다.
class SubClass12 : SuperClass12(100){
}

// 자식 클래스의 생성자가 따로 기술되어야 한다면 아래와 같이 표현한다.
// 자신의 대표생성자는 없지만 부모클래스의 대표생성자가 있으므로, 아래와 같이 super 키워드를 사용한다.
class SubClass13 : SuperClass12{
    constructor() : super(100){
    }
}

// 자식 클래스에도 대표생성자가 있다면 아래와 같이 작성된다.
// 또한 constructor 키워드는 생략 가능하다.
// class SubClass4 constructor(var a4:Int) : SuperClass2(100){
class SubClass4 (var a4:Int) : SuperClass12(100){
    constructor() : this(100){
    }
}