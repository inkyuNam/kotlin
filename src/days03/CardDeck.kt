package days03

class CardDeck {
    // 멤버변수 : cards 라는 이름의 배열. 배열 안에는 52칸이 있고,
    // 최초는 임의 카드객체로 초기화 - 매개변수가 없는 보조 생성자를 호출해서 생성
    var cards = Array<Card>(52,{Card()})    // 52 장의 카드는 모두 Spade, A 로 설정
    // 매개변수가 없는 보조 생성자 호출 -> 4,1 을 대표생성자를 호출하면서 전달

    // 생성자 : 배열에 있는 Card52 장을 스페이드1(A) ~ 클로버13(K) 까지 카드의 무늬와 숫자를 설정하는 동작

    constructor(){
        var i = 0          // 52 장의 카드 번호(0~51) 제어용 변수
        var k = 1     // kind 값 제어용 변수(1~4)
        var n = 1     // number 값 제어용 변수(1~13 반복)
        while(k<=4){
            n=1
            while(n<=13){
                cards[i].k = k
                cards[i].n = n
                n++
                i++
            }
            k++
        }
        // 52번 반복으로 Spade:A ~ Clover:13 각 카드 무늬와 숫자를 세트
    }

    // shuffle 메서드 : 52 장을 골고루 섞는 메서드
    // (Math.random()*52).toInt() : 0~51 중 랜덤 정수 선택 명령
    fun shuffle (){
        // 0~51 번 카드를 순서대로 작업 : 여기서 작업이란 0~51 중 랜덤한 숫자를 골라서 현재 카드와
        // 랜덤번째 카드를 맞바꾸는 동작
        var temp:Card = Card()   // 랜덤카드와 현재 카드를 맞바꿀 때 필요한 임시카드
        var i:Int = 0
        while(i<=51){
          var r:Int = (Math.random()*52).toInt()    // 0~51 중 랜덤숫자 생성 & 저장
            temp = cards[i]
            cards[i] = cards[r]
            cards[r] = temp
            i++
        }
    }

    // pick 메서드 : 전달인수로 온 정수 번째의 카드를 리턴해주는 메서드
    fun pick (i:Int):Card {
        return cards[i]
    }
}