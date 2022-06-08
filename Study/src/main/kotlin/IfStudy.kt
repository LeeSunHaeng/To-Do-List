fun main(args: Array<String>) {
    // if문 - 조건문
    val a = 10
    val b = 20

    if(a == 20 || a == 40){ //or(또는) 연산자 활용( || )
        println("a는 10 입니다.")
    }else if(a == 13){
        println("a는 13 입니다.")
    }else{
        println("a는 10이 아닙니다")
    }

    if(a == 5 && b== 20){ //and(그리고) 연산자 활용 ( && )
        println("a는 5 이고 b는 20 입니다.")
    }

    //when 조건문 - if 문이랑 동일하게 조건을 비교하는 식을 만드는 것이지만, 좀더 가독성 있게 보여지게 만들 수 있음
    when(a){
        1 -> { println("a는 1입니다.") }
        2 -> { println("a는 2입니다.") }
        5 -> { println("a는 5입니다.") }
        else -> {
            println("a가 뭔지 알 수 없습니다.")
        }
    }
}