package days02

fun main() {
    // Student 클래스를 제작
    // 매개변수는 bun, name, kor, eng, mat, tot, ave
    // bun, name 는 대표생성자에서 매개변수 생성
    // 아래와 같이 동작하도록 대표생성자와 보조 생성자를 오버로딩하여 제작
    var std1 = Student()
    std1.kor = 70
    std1.mat = 70
    std1.eng = 70
    std1.prnScore() // 간단한 이름과 각 과목점수와 총점 평균 출력 메소드 호출
    // std1 학생의 번호는 1, 이름은 "이름없음1" 로 한다.
    var std2 = Student(1,"홍길동")
    std2.kor = 80
    std2.mat = 85
    std2.eng = 90
    std2.prnScore() // 간단한 이름과 각 과목점수와 총점 평균 출력 메소드 호출
    var std3 = Student(2,"홍길남",50,60,80)
    std3.prnScore() // 간단한 이름과 각 과목점수와 총점 평균 출력 메소드 호출
}
class Student constructor(var bun:Int,var name:String){
    var kor:Int=0
    var mat:Int=0
    var eng:Int=0
    var tot:Int=0
    var avg:Double=0.0

    constructor():this(1,"이름없음1"){
    }
    constructor(b:Int,n:String,k:Int,m:Int,e:Int):this(b,n){
        kor=k; mat=m; eng=e
    }

    fun prnScore(){
        tot = kor+mat+eng
        avg = tot/3.0
        println("번호 : $bun, 성명 : $name, 국어 : $kor, 수학 : $mat, 영어 : $eng, 총점 : $tot, 평균 : $avg")
    }

}
