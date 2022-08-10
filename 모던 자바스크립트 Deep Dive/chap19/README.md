# 프로토 타입
## 프로토 타입의 교체
### 생성자 함수에 의한 프로토 타입의 교체
- 프로토 타입에 객체 리터럴을 할당하면 construct 프로퍼티가 없는데 construct 프로퍼티는 자바스크립트 엔진이 프로토타입을 생성할 때 암묵적으로 추가된다.   
- 프로토 타입을 교체하면 construct 프로퍼티와 생성자 함수 간의 연결이 파괴된다.   
- chap19_41.js
- 프로토 타입으로 교체한 객체 리터럴에 constructor 프로퍼티를 추가하여 프로토 타입의 constructor 프로퍼티를 되살릴 수 있다.
### 인스턴스에 의한 프로토타입의 교체
- 프로토타입은 인스턴스의 __proto__ 접근자 프로퍼티(Object.getPrototypeOf)를 통해 접근 가능
- __proto__ 접근자 프로퍼티(Object.setPrototypeOf)를 통해 프로토타입을 교체 가능
- prototype 프로퍼티에 다른 임의의 객체를 바인딩하는 것은 미래의 생성할 인스턴스의 프로토 타입을 교체
- __proto__ 접근자 프로퍼티를 통해 교체하는 것은 이미 생성된 객체의 프로토 타입을 변경하는 것
- chap19_43.js
- chap19_44.js
- 생성자 함수와 프로토 타입 간의 연결 되살리기
- chap19_45.js
### instanceof 연산자
- 우변의 생성자 함수의 prototype에 바인딩된 객체가 좌변의 객체의 프로토타입 체인 상에 존재하면 true로 평가되고 그렇지 않으면 false로 평가
- chap19_46.js
- chap19_47.js
- instanceof 연산자는 생성자 함수의 prototype에 바인딩된 객체가 프로토타입 체인 상에 존재하는지 확인
- chap19_48.js
- 연산자 함수 구현 [chap19_49.js]
- 프로퍼티와 생성자 함수의 연결이 파괴되어도 생성자 함수의 prototype 프로토타입 간의 연결은 파괴되지 않으므로 instanceof는 아무런 영향을 받지않는다. [chap19_50.js]
### 직접 상속
- Object.create() 메서드는 명시적으로 프로토 타입을 지정하여 새로운 객체를 생성
- 다른 객체 생성 방식과 마찬가지로 추상 연산 OrdinaryObjectCreate를 호출
- Object.create() 메서드의 첫 번째 매개변수에는 생성할 객체의 프로토타입으로 지정할 객체 전달
- 두번째 매개변수에는 생성할 객체의 프로퍼티 키와 프로퍼티 디스크립터로 이루어진 객체 전달
- [chap19_51.js]
- Object.create() 메서드의 장점
  - new 연산자가 없어도 객체를 생성할 수 있다.
  - 프로토타입을 지정하면서 객체를 생성할 수 있다.
  - 객체 리터럴에 의해 생성된 객체도 상속받을 수 있다.

- Object.prototype 빌트인 메서드 
  - Object.hasOwnProperty
  - Object.prototype.isPrototypeOf
  - Object.prototype.propertyIsEnumerable
  - [chap19_52.js]

- Object.prototype의 빌트인 메서드를 객체가 직접 호출하는 것은 권장하지 않는다.
  - Object.create 메서드를 통해 프로토타입 체인의 종점에 위치하는 객체를 생성할 수 있기 때문
  - 프로토 타입체인의 종점에 위치하는 객체는 Object.prototype의 빌트인 메서드를 사용할 수 없다.
  - [chap19_53.js]

- Object.prototype의 빌트인 메서드는 다음과 같이 간접적으로 호출하는 것이 좋다.
  - [chap19_54.js]

### 객체 리터럴 내부에서 __proto__에 의한 직접 상속
- ES6에서는 객체 리터럴 내부에서 \_\_proto__ 접근자 프로퍼티를 사용하여 직접 상속을 구현할 수 있다.
  - [chap19_55.js]

## 정적 프로퍼티/메서드
- 생성자 함수로 인스턴스를 생성하지 않아도 참조/호출할 수 있는 프로퍼티/메서드
  - [chap19_56.js]
    - Person 생성자 함수는 객체이므로 자신의 프로퍼티/메서드를 소유할 수 있다.
    - 정적 프로퍼티/메서드는 생성자 함수가 생성한 인스턴스로 참조/호출할 수 없다.
  - Object.create 메서드는 Object 생성자 함수의 정적 메서드
  - Object.hasOwnPropery 메서드는 Object.prototype의 메서드
  - Object.create 메서드는 Object 생성자 함수가 생성한 인스턴스로 호출할 수 없다.
  - Object.prototype.hasOwnProperty 메서드는 Object.prototype의 메서드 이므로 모든 객체가 호출할 수 있다.
    - [chap19_57.js]
  - 
## 프로퍼티 열거
### for ... in 문
- 객체의 모든 프로퍼티를 순회하며 열거 하려면 for ... in 문을 사용한다.
- for (변수 선언문 in 객체)
- for ... in 예제 [chap19_64.js]
- Object.prototype의 toString메서드는 열거할 수 없도록 정의되어 있다.
- Object.prototype.toString 프로퍼티의 프로퍼티 어트리뷰트의 [[Enumerable]]값이 false이기 때문이다. [chap19_65.js] 
- false 확인 예제 [[Enumerable]]
- **for ... in 문은 객체의 프로토 타입 체인 상에 존재하는 모든 프로토타입의 프로퍼티 중에서 프로퍼티 어트리뷰트 [[Enumerable]]의 값이 true인 프로퍼티를 순회하며 열거한다.**
- [chap19_67.js]