fun main(args: Array<String>) {
    // for - 반복문
    var arrayTest = IntArray(10)
    arrayTest[0] = 1
    arrayTest[1] = 2
    arrayTest[2] = 3
    arrayTest[3] = 4
    arrayTest[4] = 5
    arrayTest[5] = 6
    arrayTest[6] = 7
    arrayTest[7] = 8
    arrayTest[8] = 9
    arrayTest[9] = 10

    //for문 예제1 : 배열의 데이터를 반복
    for(item in arrayTest){
        println(item)
    }
    //for문 예제2 : 배열의 index 번호를 반복
    for(item in arrayTest.indices){
        println(arrayTest[item])
    }

    //for문 예제3 : 범위 지정하는 경우
    //동적 배열
    var arrayList = arrayListOf<Int>()
    for(item in 1..10){
        arrayList.add(item)
    }
    for(item in arrayList){
        println(item)
    }

    //for문 예제4 : for문과 if문 같이 쓸때
    for(item in arrayList){
        if(item > 5){
            println(item)
        }
    }

    //while문 - 무한 반복문
    //while - ~~하는 동안...

    var a = 10
    //a가 50보다 작은것이 true 일 동안 반복
    while(a < 50){
        println("a는${a}입니다.")
        a++
    }


}