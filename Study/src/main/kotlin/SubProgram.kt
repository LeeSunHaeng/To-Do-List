fun main(args: Array<String>) {
    //메인함수

    //정적 배열 선언 및 초기화
    //정적 배열의 의미 : size를 정해놓았다는 뜻
    var arrayTest = IntArray(10) // 10의 크기(size)를 가진 배열 변수 초기화
    //index 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    arrayTest[0] = 40
    arrayTest[1] = 10
    arrayTest[2] = 20
    arrayTest[3] = 30

    //배열의 사이즈(공간) 체크
    println(arrayTest.size)

    println(arrayTest[0]) //첫번째 인덱스의 데이터 출력
    println(arrayTest[2])

    //동적 배열 (컬렉션)
    var dynamicArrayTest = arrayListOf<String>()
    dynamicArrayTest.add("이선행") //size == 1
    dynamicArrayTest.add("배고프다.")   //size == 2

    //배열의 사이즈(공간) 체크
    println(dynamicArrayTest.size)

    //0번째 인덱스의 값 출력
    println(dynamicArrayTest[0])

    //0번째 인덱스 삭제
    println(dynamicArrayTest.removeAt(0))
    //남은 데이터는 "배고프다" 밖에 안남음.. 즉, 방 역시 1칸 남음

    //0번째 인덱스의 값 출력
    println(dynamicArrayTest[0])

    //배열의 수정하는 방법!
    dynamicArrayTest.set(0,"배부르다.")

    //0번째 인덱스의 값 출력
    println(dynamicArrayTest[0])

    //정적 배열과 동적 배열이 따로 존재하는 이유
    //정적 배열은 크기를 알고 있을때 사용하면 크기를 딱 잡아놓기 때문에 메모리 활용도가 높다
    //배열의 크기를 예측 할 수 없는 경우에는 동적 배열을 사용하면 좋다 하지만 메모리 활용도가 다르다
}