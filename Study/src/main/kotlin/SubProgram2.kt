fun main(args: Array<String>) {
    //컬렉션(Map) 특징 : 순서가 없다(index)
    //map - key , value
    //불변형 vs 가변형
    //불변현 :  요소를 추가 또는 삭제를 할 수 없다.(mapOf)
    val foods : Map<Int,String> = mapOf(2 to "chicken", 1 to "icecream", 3 to "kimchi")
    //key가 1인 value 출력
    println(foods.get(1))

    //value를 전부 출력
    println(foods.values)

    //key를 전부 출력
    println(foods.keys)

    //가변형 : 요소를 얼마든지 추가 또는 삭제를 할 수 있다(mutableMapOf)
    val cars : MutableMap<String,String> = mutableMapOf()
    cars.put("cars1", "benz")
    cars.put("cars2", "avante")
    cars.put("cars3", "k5")

    println(cars.get("cars3"))

    //key값이 "cars1"인 값 삭제
    cars.remove("cars1")
    println(cars.get("cars1")) //null : 비어있다

    cars.put("cars1","ferari")
    cars.put("cars1","truck")

    println(cars.get("cars1"))
}