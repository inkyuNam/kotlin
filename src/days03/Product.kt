package days03



fun main() {

    val tv = Tv()
    val computer = Computer()
    val audio = Audio()
    val buyer = Buyer()
    buyer.buy(tv)
    buyer.buy(computer)
    buyer.buy(audio)
    buyer.summary()
    buyer.refund(audio)
    buyer.summary()

}
// Product 클래스는 부모클래스이다.
// 멤버변수 price, bonusPoint 를 대표생성자로 생성
// 보조 생성자는 price 값만 전달하는 함수로 제작
open class Product constructor(var price:Int,var bonusPoint:Int){
    constructor(p:Int):this(p, (p/10).toInt()){
    }
}
// 나머지 세 개의 클래스는 모두 product 클래스를 상속받는다.
// 각 생성자는 부모클래스의 생성자를 각자의 가격을 전달해서 호출
// 각자의 상품이름을 리턴하는 toString 메서드를 오버라이딩하세요.
class Computer : Product(150){
    override fun toString(): String {
        return "computer"
    }
}

class Tv : Product(100){
    override fun toString(): String {
        return "tv"
    }
}

class Audio : Product(60){
    override fun toString(): String {
        return "audio"
    }
}

class Buyer{
    var money:Int = 1000
    var bonusPoint:Int = 0
    // 구매목록 리스트 생성
    var item = mutableListOf<Product>()
    // 구입할 제품이 전달되어 물건을 구입하는 동작을 넣은 buy 함수 제작
    fun buy (p: Product){
        if(this.money<p.price){
            println("잔액이 부족합니다")
            return
        }
        this.money -= p.price
        this.bonusPoint += p.bonusPoint
        println("$p (을)를 구매하였습니다, " +
                "제품가격 : ${p.price}, 보유잔액 : ${this.money}, 보너스 포인트 : ${p.bonusPoint}")
        item.add(p)
    }

    // 구입한 물품과 지출총액이 출력되는 summary 함수 제작
    fun summary(){
        var sum:Int = 0
        var itemList:String = ""
        if(item.isEmpty()){
            println("구매하신 제품이 없습니다.")
            return
        }
        for(p in item){
            // p as Product     // 다시 돌아갈 일이 없어서 영구 형변환 as 로 처리해도 상관없다.
            // sum += p.price
            // itemList += p
            if(p is Product){
                sum += p.price
                itemList = itemList + " " + p
            }
        }
        println("지출총액 : $sum, 구매목록 : $itemList, 잔액 : ${this.money}, 보너스 포인트 : ${this.bonusPoint}")
    }
    // 환불 refund 함수 제작
    fun refund(p:Product){
        if(item.remove(p)){
            this.money += p.price
            this.bonusPoint -= p.bonusPoint
            println("$p 를(을) 환불했습니다.")
        }else{
            println("구입하신 해당 제품이 없습니다.")
        }
    }
}