fun main(args: Array<String>) {
    // Nullable : null을 허용한다.(null은 값이 비어있다는 뜻)
    // Non-Null : null이 아니다

    //코틀린은 기본적으로 변수 초기화시 non-null type이다.
    var a : String = "abcdef"
    println(a)

    //null을 허용하려면 변수 타입 뒤에 ? 마크를 붙여줘야함
    var b:String? = "abcdef2"
    b = null
    println(b)

    // non-null
    // !!는 개발자가 스스로 절대로 null값이 아니라고 판단할때 사용한다 하지만 null이 발생하면 런타임시 에러가 난다
    // !!의 사용은 최대한 피해야 한다
    var c:String? = null
    println(c!!.length)
}