# 다이나믹 프로그래밍
## 중복되는 연산을 줄이자
- 컴퓨터로도 해결하기 어려운 문제는 최적의 해를 구하기에 시간이 매우 많이 필요하거나 메모리 공간이 매우 많이 필요한 문제등이 어려운 문제다.
- 컴퓨터는 연산 속도의 한계, 메모리 공간을 사용할 수 있는 데이터의 개수도 한정적이라는 점이 많은 제약을 발생
- 우리는 연산 속도와 메모리 공간을 최대한으로 활용할 수 있는 효율적인 알고리즘을 작성해야한다.

- 수학적 점화식을 프로그래밍으로 표현하려면 재귀함수를 사용하면 간단 (피보나치 함수)
- [p01.java]
- 피보나치 수열의 소스코드를 이렇게 작성하면 심각한 문제가 생길 수 있다. f(n)함수에서 n이 커지면 커질수록 기하급수적으로 수행시간이 늘어나기 때문이다.
- 피보나치 수열의 점화식을 재귀 함수를 사용해 만들 수 있지만 단순히 매번 계산하도록 하면 문제를 효율적으로 해결할 수 없다.
- 이러한 문제는 다이나믹 프로그래밍을 사용하면 효율적으로 해결할 수 있다. 
- 다이나믹 프로그래밍은 다음 조건을 만족할 때 사용할 수 있다.
  - 큰 문제를 작은 문제로 나눌 수 있다.
  - 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일

- 메모제이션 기법
  - 다이나믹 프로그래밍을 구현하는 방법 중 한 종류
  - 한 번 구한 결과를 메모리 공간에 메모해두고 같은 식을 다시 호출하면 메모한 결과를 그대로 가져오는 기법
  - 메모제이션은 값을 저장하는 방법이므로 캐싱이라고도 한다.
  - 한 번 구한 정보를 배열에 저장하고 정보가 필요하면 배열에서 가져오면 된다.
  - [p02.java]

- 메모제이션 기법을 사용한 피보나치 수열 알고리즘의 시간복잡도는 O(N)이다.
  - [p03.java]

- 탑다운 방식
  - 재귀 함수를 이용하여 다이나믹 프로그래밍 소소코드를 작성하는 방법을, 큰 문제를 해결하기 위해 작은 문제를 호출한다고 하여 탑다운 방식

- 보텀업 방식
  - 단순히 반복문을 이용하여 소스코드를 작성하는 경우 작은 문제부터 차근차근 답을 도출
  - [p04.java]

### 1로 만들기
- 바텀업 방식으로 다이나믹 프로그래밍을 구현하는 방법을 알았다.
- [p05.java]

### 개미 전사
- 바텀업 방식으로 다이나믹 프로그래밍을 구현하는 방법과 점화식을 세우는 방법을 공부했다.
- [p06.java]

### 바닥 공사
- 바텀업 방식으로 다이나믹 프로그래밍을 구현하는 방법과 점화식을 세우는 방법을 공부했다.
- [p07.java]

### 효율적인 화폐 구성
- 바텀업 방식으로 다이나믹 프로그래밍을 구현하는 방법과 점화식을 세우는 방법을 공부했다.
- [p08.java]