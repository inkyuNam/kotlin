package days03

// Data Class
// DataClass 는 매개체의 데이터를 관리하는 용도로 사용하는 클래스이다.
// abstract, open, inner 클래스 등으로 정의할 수 없다.
// 반드시 주 생성자를 가지고 있어야 하는 클래스이다.

// Data Class 는 개발자의 개발 편리성을 위해 몇가지 메서드가 자동으로 생성된다.
// equals : 객체가 가지고 있는 변수를 모두 비교하는 메서드
// hashCode : 객체를 구분하기 위한 고유한 정수값
// copy : 객체를 복제하는 메서드
// toString : 객체가 가지고 있는 변수의 값을 출력
// componentN : 객체 분해 - 멤버변수들의 사용
fun main() {

    var obj1 = TestClass1(100,200)  // 대표생성자 호출
    println("obj1.a1 : ${obj1.a1}"); println("obj1.a2 : ${obj1.a2}"); println("obj1.a3 : ${obj1.a3}")
    var obj2 = TestClass1(100,200, 300) // 보조생성자 호출
    println("obj2.a1 : ${obj2.a1}"); println("obj2.a2 : ${obj2.a2}"); println("obj2.a3 : ${obj2.a3}")
    obj1.testMethod1()
    obj2.testMethod1()

    println("-----------------------------------------------------------------------")

    var obj3 = TestClass2(100,200)
    println("obj3.a1 : ${obj3.a1}"); println("obj3.a2 : ${obj3.a2}"); println("obj3.a3 : ${obj3.a3}")
    var obj4 = TestClass2(100,200, 300)
    println("obj4.a1 : ${obj4.a1}"); println("obj4.a2 : ${obj4.a2}"); println("obj4.a3 : ${obj4.a3}")
    obj3.testMethod2()
    obj4.testMethod2()

    println("-----------------------------------------------------------------------")

    println("toString 의 사용")
    println("일반 클래스 TestClass1 의 객체 obj1 의 toString : $obj1")
    println("데이터 클래스 TestClass2 의 객체 obj3 의 toString : $obj3")
    // data class 는 개발자가 사용하기 쉽도록 toString 메소드를 자동으로 오버라이딩한다.
    // 다만 주생성자에서 만들어진 멤버변수가 아니라면 toString 반환내용에 포함되지 않는다.
    var obj31:TestClass3 = TestClass3(10,20,30)
    println("데이터 클래스 TestClass3 의 객체 obj31 의 toString : $obj31")

    println("-----------------------------------------------------------------------")

    println("equals 의 사용")
    var obj5 = TestClass1(100,200,300)
    var obj6 = TestClass1(100,200,300)
    if(obj5==obj6) println("TestClass1 객체들 obj5 와 obj6 는 같은 객체이다.")
    else println("TestClass1 객체들 obj5 와 obj6 는 다른 객체이다.")
    // 일반 클래스의 객체는 참조값(주소) 를 비교한다.
    var obj7 = TestClass2(100,200,300)
    var obj8 = TestClass2(100,200,500)
    if(obj7==obj8) println("TestClass2 객체들 obj7 와 obj8 는 같은 객체이다.")
    else println("TestClass2 객체들 obj7 와 obj8 는 다른 객체이다.")
    // 데이터 클래스의 객체는 주생성자에서 생성된 멤버변수끼리 비교한다.

    var obj32:TestClass3 = TestClass3(10,20,30)
    var obj33:TestClass3 = TestClass3(10,20,50)
    if(obj32==obj33) println("TestClass3 객체들 obj32 와 obj33 는 같은 객체이다.")
    else println("TestClass3 객체들 obj32 와 obj33 는 다른 객체이다.")

    println("-----------------------------------------------------------------------")

    // copy 메소드
    // val obj9 = obj5.copy()
    val obj10 = obj7.copy()
    // copy 클래스는 새로운 객체 생성후 원본 객체의 멤버변수들을 복사해서
    // 복사본 객체를 만들어낸다.
    // 주생성자에서 만들어진 멤버변수만 복사되고, 나머지는 클래스에서 정의된 초기값으로 값이 정해진다.
    // a1,a2 는 obj7 객체가 가지고 있던 멤버변수의 값을 복사, a3은 클래스 정의할때 지정한 초기값 복사
    obj7.a1 = 500
    println("obj7.a1 : ${obj7.a1}")
    println("obj7.a2 : ${obj7.a2}")
    println("obj7.a3 : ${obj7.a3}")
    println("obj7 : $obj7")
    println("obj10.a1 : ${obj10.a1}")
    println("obj10.a2 : ${obj10.a2}")
    println("obj10.a3 : ${obj10.a3}")
    println("obj10 : $obj10")
    // 데이터 클래스의 copy 메서드로 생성된 객체는 이 역시도 dataClass 의 객체로 생성돼서
    // 필요한 모든 메서드가 오버라이딩 되어 있는 상태로 사용이 가능.

    println("-----------------------------------------------------------------------")

    // component 메서드
    val num1 = obj7.component1()    // val num1 = obj7.a1    컴포넌트와 같은 기능으로 사용 가능
    val num2 = obj7.component2()    // val num2 = obj7.a2
    println("num1 : $num1")
    println("num2 : $num2")
    // component 메서드는 주생성자에서 만들어진 멤버변수들의 값을 별도로 변수에 얻어서 사용하는 메서드이다.
    // 코틀린의 클래스에서는 멤버변수에 대한 getter 와 setter 가 이미 생성되기 때문에
    // 그리 많이 사용되는 메서드는 아니다.
    var obj11 = TestClass3(100,200,300)
    val num3 = obj11.component1()   //val num3 = obj7.a1
    val num4 = obj11.component2()   //val num4 = obj7.a2
    val num5 = obj11.component3()   //val num5 = obj7.a3
    println("num3 : $num3")
    println("num4 : $num4")
    println("num5 : $num5")
    // a3 멤버변수를 데이터클래스에서 자동오버라이딩 또는 자동생성되는 메서드에서 사용되게 하려면
    // 주생성자에 멤버변수 선언을 포함시켜 주어야 한다.

    println("-----------------------------------------------------------------------")

    println("component 메서드의 변형된 사용")
    val(num10,num11) = obj7 // component 라는 키워드 없이 객체안의 멤버변수를 다 꺼내서 왼쪽 변수들에 차례로 저장
    println("num10 : $num10")
    println("num11 : $num11")

    val(num12,num13,num14)=obj11
    println("num12 : $num12")
    println("num13 : $num13")
    println("num14 : $num14")

}

class TestClass1(var a1:Int, var a2:Int){
    var a3:Int = 0
    constructor(a1:Int,a2:Int,a3:Int):this(a1,a2){
        this.a3 = a3
    }
    fun testMethod1(){
        println("TestClass1 의 testMethod1")
    }
}

data class TestClass2(var a1:Int, var a2:Int){
    var a3:Int = 0
    constructor(a1:Int,a2:Int,a3:Int):this(a1,a2){
        this.a3 = a3
    }
    fun testMethod2(){
        println("TestClass2 의 testMethod2")
    }
}

data class TestClass3(var a1:Int, var a2:Int, var a3:Int)