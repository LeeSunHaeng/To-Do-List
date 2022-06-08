class Benz : Car() {
    //메소드 오버라이드 (Method Override)
    override fun start(){
        println("벤츠 ")
        super.start()
    }

    override fun stop() {
        println("벤츠 ")
        super.stop()
    }
    // ()가 있는 이유는 파라미터를 받아오기 위해
    fun calculateNumber(speed : Int, hour : Int) : Int{
        println("${speed*hour}Km를 이동하였습니다.")
        return speed*hour
    }
}