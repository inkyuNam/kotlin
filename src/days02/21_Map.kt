package days02

fun main() {

    // Map : key 와 value 로 데이터를 관리하는 컬렉션

    // mapOf : 불변형 Map 을 생성
    // mutableMapOf : 가변형 Map 을 생성

    // <String,Int> : String-key 값의 자료형 Int-value 값의 자료형
    val map1 = mapOf<String,Int>("key1" to 10, "key2" to 20,"key3" to 30)
    println("map1 : $map1")

    val map2 = mutableMapOf<String,Int>()
    println("map2 : $map2")

    // <String,Any> : String-key 값의 자료형 Any-value 값의 자료형
    val map3 = mapOf<String,Any>("key1" to 10, "key2" to 11.11, "key3" to true)
    println("map3 : $map3")

    println("----------------------------------------------------")
    // 맵의 자료에 접근하는 방법
    // get : 이름을 통해 객체를 추출할 수 있다.
    // Kotlin 의 Map 은 [] 를 사용할 수 있다.
    println("map1 key1 : ${map1.get("key1")}")
    println("map1 key2 : ${map1["key2"]}")
    println("----------------------------------------------------")
    // 기타 메서드
    // size : 관리하는 요소의 갯수
    // keys : key 를 배열로 반환
    // values : 객체들을 배열로 반환
    // containsKey : 지정된 이름으로 저장된 객체가 있는지 확인
    // containsValue : 지정된 값으로 저장된 객체가 있는지 확인
    println("map1 size : ${map1.size}")
    println("map1 keys : ${map1.keys}")
    println("map1 values : ${map1.values}")
    println("map1 contains key1 : ${map1.containsKey("key1")}")
    println("map1 contains key100 : ${map1.containsKey("key100")}")
    println("map1 contains value 10 : ${map1.containsValue(10)}")
    println("map1 contains value 100 : ${map1.containsValue(100)}")

    println("----------------------------------------------------")

    // 가변형 Map 에 요소 추가 삭제
    // put : 객체를 추가한다. 기존 이름과 동일할 경우 덮어씌운다.
    // remove : 주어진 이름으로 저장된 객체를 제거한다.
    map2.put("key1",100)    // 키값과 밸류값을 제공하여 추가
    println("map2 : $map2")
    map2["key2"] = 200  // 키값을 인덱스와 같이 사용하여 추가
    println("map2 : $map2")
    map2.put("key1",1000) // 이미 존재하는 키값으로 요소를 추가하면 해당 밸류값이 수정된다.
    println("map2 : $map2")
    map2["key2"] = 2000 // 이미 존재하는 키값으로 요소를 추가하면 해당 밸류값이 수정된다.
    println("map2 : $map2")
    map2.remove("key1")
    println("map2 : $map2")

    println("----------------------------------------------------")

    // 가변형과 불변형간의 변환
    val map100 = map1.toMutableMap()
    map100["key100"] = 1000
    println("map100 : $map100")

    val map200 = map100.toMap()
    // map200["key200"] = 2000

}