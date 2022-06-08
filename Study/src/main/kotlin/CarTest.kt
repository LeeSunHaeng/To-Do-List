fun main(args: Array<String>) {
    //클래스 인스턴스 생성!
    var car = Car()
    car.carName = "K5"
    car.carColor = "black"
    println(car.carName)

    var benz = Benz()
    benz.start()
    val distance = benz.calculateNumber(100,2)
    println(distance)
}