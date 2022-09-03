package days02

fun main() {
    // Set
    // 중복된 객체를 담을 수 없는 컬렉션
    // 순서에 관계 없고 중복된 객체를 담지 않을 경우 사용한다.

    // Set 생성
    // setOf : 불변형 set 을 생성
    // mutableSetOf : 가변형 set 을 생성
    val set1 = setOf(1,5,10,1,5,10)
    println("set1 : $set1")
    val set2 = mutableSetOf<Int>()
    println("set2 : $set2")

    println("-----------------------------------------------")

    // 요소의 접근
    // println("set1 0 : ${set1.get(0)}") // 순서 및 인덱스가 없으므로 에러
//    println("set1 1 : ${set1[1]}") // 순서, 인덱스, 중복이 없으므로 에러
    // Set 의 접근은 반복실행문으로
    for(item in set1){
        println("set1 : $item")
    }

    println("-----------------------------------------------")
    // 사이즈를 얻어내는 메서드
    println("set1 size : ${set1.size}")

    println("-----------------------------------------------")

    // 가변형의 요소 추가 제거
    set2.add(10);   set2.add(20)
    set2.addAll(listOf(30,40,50))
    println("set2 : $set2")
    set2.add(20)    // 중복된 값의 추가는 무시
    println("set2 : $set2")
    set2.addAll(listOf(40,50,60,70))
    println("set2 : $set2")
    set2.remove(30)
    println("set2 : $set2")

    println("-----------------------------------------------")

    // 가변형 불변형간의 변환
    val set3 = set1.toMutableSet()
    set3.add(1000)
    println("set3 : $set3")
    val set4 = set3.toSet()
}