package days03

// kind 와 number 를 멤버변수로 만들고 생성자에 전달된 값으로 멤버변수의 값을 대입하는 대표생성자를 이용하여 완성
// 전달인수가 없는 보조생성자도 생성(대표생성자에 4와 1을 전달하는 대표생성자 호출 포함)
// 그 외 사항은 코틀린 코드를 이용하여 이전클래스와 같은 동작(toString의 오버라이드)을 할 수 있게 적절히 처리
// spade, diamond, heart, clover 변수는 자바의 static 처럼 생성
class Card constructor(var k:Int, var n:Int){
    constructor():this(4,1){
    }

    companion object{
        val spade:Int = 4
        val diamond:Int = 3
        val heart:Int = 2
        val clover:Int = 1
    }

    override fun toString(): String {
        // 현재 객체가 갖고 있는 카드의 무늬가 무엇인지, 숫자가 무엇인지를 String 으로 리턴하는 함수
        val kinds = arrayOf<String>("", "♣", "♥", "◆", "♠")
        val numbers = arrayOf<String>("","A", "2", "3", "4", "5", "6", "7", "8","9","10","J","Q","K")
        val str:String = "["+kinds[k]+":"+numbers[n]+"]"
        return str
    }


}