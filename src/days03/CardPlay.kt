package days03

fun main() {

    // CardDedk 생성
    var deck:CardDeck = CardDeck()


    // 세 명의 플레이어가 받을 5장의 카드 배열 생성 p1 p2 p3
    var p1 = Array<Card>(5,{Card()})
    var p2 = Array<Card>(5,{Card()})
    var p3 = Array<Card>(5,{Card()})

    // CardDeck 내부에 카드 섞어서 배치
    deck.shuffle()

    // 카드를 나눠주고 출력
    var i:Int = 0
    var k:Int = 0

    while(i<5){
        p1[i] = deck.pick(k++)
        p2[i] = deck.pick(k++)
        p3[i] = deck.pick(k++)
        i++
    }

    for(item in p1) print("$item ")
    println()
    for(item in p2) print("$item ")
    println()
    for(item in p3) print("$item ")


}