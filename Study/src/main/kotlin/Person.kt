class Person constructor(name:String,age:Int) {
    //커스텀 getter setter를 만들지 않을 거면 주 생성자의 파라미터에 var, val을 붙여주면 됨
    //ex) -> class Person constructor(var name:String, var age:Int)

    //커스텀 getter setter
    //getter setter는 변수 바로 밑에 만들어야 함
    //field는 마우스 대보면 알 수 있듯이 변수의 값 자체를 의미함
    //value는 인스턴스 생성시 외부로부터 입력받은 정보
    var name : String = name
    get(){
        return field
    }
    set(value) {
        field = value + " haha"
    }

    var age : Int = age
    get(){
        return field
    }
    set(value) {
        field = value + 40
    }

    //주 생성자로부터 받은 매개변수를 초기화 할 때 활용 -> 매개변수를 받아서 인스턴스가 생성 될때 init 실행
    init{
        println(name+ " " + age)
    }

    //보조 생성자
    constructor(_name: String, _age: Int, height : Int) : this(_name, _age){
    println(_name + " " + _age + " " + height)
    }


}