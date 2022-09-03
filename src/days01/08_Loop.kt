package days01

fun main() {
    // 코틀린의 for 문은 자바에서처럼 시작 값 끝값 증감량 등을 사용하지 않고, 범위데이터만 사용한다.
    val a1 = 1..10
    for(item in a1){
        print("$item\t")
    }

    // 범위 데이터로 사용되는 대상은 배열, 리스트, Map, .. 을 이용한 범위데이터 등이 사용된다.
    println("\n-------------------------------------------")
    val a2 = 1..10 step 2 // 2씩 증가하는 범위 데이터
    for(item in a2){
        print("$item\t")
    }

    println("\n-------------------------------------------")
    // 10부터 1까지 줄어드는 범위데이터 사용
    // val a3 = 10..1  은 사용 불가능하다.
    val a3 = 10 downTo 1
    for(item in a3){
        print("$item\t")
    }

    println("\n-------------------------------------------")
    val a4 = 10 downTo 1 step 2
    for(item in a4){
        print("$item\t")
    }

    println("\n-------------------------------------------")
    var a5 = 0
    print("while : ")
    while(a5<10){
        print("$a5\t")
        a5++
    }

    println("\n-------------------------------------------")
    var a6 = 0
    print("do - while : ")
    do{
        print("$a6\t")
        a6++
    }while(a6<10)

    println("\n-------------------------------------------")
    var a7 = 100
    while(a7 < 10)
        print("$a7\t")
        a7++

    println("\n-------------------------------------------")
    var a8=100
    do{
        print("$a8\t")
        a8++
    }while(a8<10)
    
}
