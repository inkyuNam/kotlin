package days01

import java.text.DecimalFormat

fun main() {
    print("국어점수 입력 : ")
    val kor:Int = readLine()!!.toInt()
    print("영어점수 입력: ")
    val eng:Int = readLine()!!.toInt()
    print("수학점수 입력 : ")
    val mat:Int = readLine()!!.toInt()

    val tot:Int = sumscore(kor,eng,mat)
    val avg:Double = averagescore(tot)
    prnscore(kor,eng,mat,tot,avg)
}
val sumscore : (Int,Int,Int) -> Int = {a1:Int,a2:Int,a3:Int -> a1+a2+a3}
// val averagescore : (Int) -> Double = {a1:Int -> a1/3.0}
val averagescore = {tot:Int -> tot/3.0}
val prnscore = {kor:Int,eng:Int,mat:Int,tot:Int,avg:Double->
    val df1 = DecimalFormat("#,##0.0")
    println("\t\t=== 성적표 ===")
    println("---------------------------------------------")
    println("국어\t영어\t수학\t총점\t평균")
    println("---------------------------------------------")
    println("$kor\t\t$eng\t\t$mat\t\t$tot\t\t${df1.format(avg)}\t")
    println("---------------------------------------------")
}

/*
val prnscore : (Int,Int,Int,Int,Double) -> Unit = {kor:Int,eng:Int,mat:Int,tot:Int,avg:Double->
    val df1 = DecimalFormat("#,##0.0")
    println("\t\t=== 성적표 ===")
    println("---------------------------------------------")
    println("국어\t영어\t수학\t총점\t평균")
    println("---------------------------------------------")
    println("$kor\t\t$eng\t\t$mat\t\t$tot\t\t${df1.format(avg)}\t")
    println("---------------------------------------------")
}*/
