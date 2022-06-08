fun main(args: Array<String>) {
    //프로그램이 처음 시작되는 수행 지점, (메인 함수)
    println("Hello 이선행")

    // 변수
    //1. 변할 수 있는 수(값)
    //2. 값을 저장해 놓는 공간간
    var a = 1   // 1+1 = 2의 '='의 표현과는 다르게 이해해야 한다.
    println(a)

    var a2 = "홍드로이드"
    println(a2)

    //변수명을 지을때에는 관련된 의미를 부여하는 것이 헷갈림을 방지한다.
    var fruitName = "사과"

    //선언(값이 할당되기 전에 타빙 지정을 하고 변수를 선언하는 과정)
    var a3 : String //String은 문자열 타입

    //초기화 (값을 최초로 할당을 함)
    a3 = "가라나나"

    //val은 값을 재할당 할 수 없다
    val abc = 350
    println(abc)

    var b: String
    var b2: Int
    var b3: Boolean = false //True OR False
    var b4: Float = 0.111222F //실수(소수) 접미어로 F가 붙어야 한다.
    println(b4)



}