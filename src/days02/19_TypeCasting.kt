package days02

fun main() {
    // 기본 자료형 클래스간의 형변환 -------------------------------------------
    var a1:Int = 100
    // var a2:Double = a1 // 에러
    var a2:Double = a1.toDouble()
    
    var b1:Double = 123.12
    // var b2:Int = b1
    var b2:Int = b1.toInt()
    
    var c1:String = "1234"
    var c2:Int = c1.toInt()
    
    var d1:String = "122.34"
    var d2:Double = d1.toDouble()
    
    // val s3:String = "안녕하세요";     val n4:Int = s3.toInt() // 에러
    // -------------------------------------------------------------------------

    // 1. 부모클래스의 참조변수에 자식클래스의 인스턴스를 저장
    val super1:SuperClass4 = SubClass41()   // SuperClass4 : 부모클래스, SubClass41 : 자식클래스
    val inter1:Inter4 = SubClass42()    // Inter4 : 부모인터페이스, SubClass42 : 자식클래스
    // 스마트 캐스팅 발생

    // 2. 자식인스턴스가 저장된 부모레퍼런스 변수에 저장되었다가 다시 자식 레퍼런스 변수로 옮겨 저장될 때,
    //  강제 캐스팅이 필요하다는 건 자바나 코틀린이나 같다.
    //  옮겨지는 인스턴스는 반드시 자식인스턴스여야하는 제약도 같다.
    //  다만 코틀린과 자바의 명령이 달라진다.

//    val sub1:SubClass41 = (SubClass41)super1    // 자바 문법
//    val sub2:SubClass42 = (SubClass42)inter1    // 자바 문법

    // 코틀린에서 자식 인스턴스를 담고 있는 부모 레퍼런스 변수값이 자식 레퍼런스 변수로 이동할때
    // 코틀린은 아래와 같다.
    super1 as SubClass41    // 자바의 super1 = (SubClass41)super1 명령과 같음
    inter1 as SubClass42    // 자바의 inter1 = (SubClass42)inter1 명령과 같음
    // 위 명령은 super1 과 inter1 에 있는 레퍼런스 값을 옮기려는
    // 자식 클래스 자료형의 "다른 변수에 형변환과 함께 옮기는 것이 아니라" 해당 자료형으로 변경시켜버린다.
    // 이 명령 이후로 super1 변수의 자료형은 SubClass41 이 되고, inter1 변수의 자료형은 SubClass42 가 된다.
    // "새로운 자식 클래스 레퍼런스 변수"로 값을 옮겨 담는 것이 아니라
    // 저장된 참조값은 놔두고 "현재변수의 자료형을 변경"해 버린다는 뜻이다.
    println("변경 후 super1 : $super1")
    println("변경 후 inter1 : $inter1")
    // 형변환의 유효영역은 현재 프로그램 안쪽이다.

    // 자바의 경우 위 두개의 형변환 전에 안전한 실행을 위해 점검을 했었다.
 /*   if(super1 instanceof SubClass41){
        val sub1:SubClass41 = (SubClass41)super1    // 형변환 명령
    }*/
    // 코틀린에서는 아래와 같은 명령을 쓴다.
//    if(super1 is SubClass41){
//          super1 as SubClass41 // 코틀린 강제 형변환 명령
//    }

    val super2:SuperClass4 = SubClass41()
    val inter2:Inter4 = SubClass42()

    if(super2 is SubClass41){
        super2 as SubClass41    // 형변환 가능 여부를 판단후 가능하면 영구적으로 변환
    }else{
        println("형변환이 불가능합니다.")
    }   // 검사결과가 참이면 변환, 거짓이면 변환하지 않음

    if(inter2 is SubClass42){
        // is 에 의해 열린 if문 안에서는 as를 쓰지 않아도
        // is 연산자 값이 true 라면 형변환이 가능한 상황이므로 자동으로 스마트 캐스팅 실행된다.
        // 현재위치 중괄호{} 안에서는 이미 inter2 는 SubClass42 의 레퍼런스로 변경된 상태이며, 그 상태로 사용이 가능하다.
        // 다만 중괄호를 벗어나면 다시 Inter2(부모인터페이스) 의 레퍼런스로 되돌아간다.
        // 중괄호가 끝나도 계속 변경상태를 유지하려면 inter4 as SubClass42 를 사용한다.
    }
}

open class SuperClass4
interface Inter4

class SubClass41:SuperClass4(){
    fun subMethod1(){
        println("SubClass41 의 subMethod1입니다.")
    }
}

class SubClass42:Inter4{
    fun subMethod2(){
        println("SubClass41 의 subMethod2입니다.")
    }
}

