package days03

fun main() {
    var tank:Tank = Tank()
    var dropship = Dropship()
    var marine = Marine()
    var scv:SCV = SCV()

    print("$tank : "); tank.prnHp();    print("$dropship : "); dropship.prnHp();
    print("$marine : "); marine.prnHp();    println("$scv : "); scv.prnHp();
    println()
    marine.move(23,45);   dropship.move(23,45);
    println()
    scv.repaire(tank)
    println()
    scv.repaire(dropship)
}
// Unit 클래스의 HP 하고 max HP 를 대표생성자로 생성
abstract class Unit constructor(var HP:Int, val maxHP:Int){
    constructor(p:Int):this((p*0.8).toInt(),p)
    fun prnHp(){
        println("Max:${maxHP} -Cur:${HP}")
    }
    abstract fun move(x:Int,y:Int)
}
open class GroundUnit(p:Int) : Unit((p*0.8).toInt(),p){
    override fun move(x:Int,y:Int){
        println("x : $x, y : $y 로 뛰어갑니다.")
    }
}
open class AirUnit(p:Int) : Unit((p*0.8).toInt(),p){
    override fun move(x:Int,y:Int){
        println("x : $x, y : $y 로 날아갑니다.")
    }
}
class Tank : GroundUnit(150),Repairable {
    override fun toString (): String {
        return "Tank"
    }
}
class Dropship : AirUnit(120),Repairable{

    override fun toString (): String {
        return "Dropship"
    }
}
class Marine : GroundUnit(50){
    override fun toString (): String {
        return "Marine"
    }
}
class SCV : GroundUnit(40),Repairable{
    override fun toString (): String {
        return "SCV"
    }
    fun repaire (r:Repairable){
        if(r is Unit){
            r.prnHp()
            if(r.HP < r.maxHP){
                println("$r 의 수리를 시작합니다.")
                while(r.HP < r.maxHP){
                    r.HP += 2;
                    println("수리중입니다. 현재 체력 : ${r.HP}")
                }
                println("$r 의 수리가 끝났습니다.")
            }
        }else{
            println("수리할 수 없는 유닛입니다.")
        }
    }
}
interface Repairable