fun main(args: Array<String>) {

    val person = Person("이선행", 26)   //클래스 인스턴스 생성
    //setter를 활용
    person.name = "김선행"
    person.age = 78

    //getter를 활용해서 설정된 값을 가져와 출력
    println(person.name + " " +person.age)

    val person2 = Person("김동동", 245,98)

}