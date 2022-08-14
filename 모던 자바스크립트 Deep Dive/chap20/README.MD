## strict mode 적용에 의한 변화
### 일반 함수의 this
- strict mode에서 함수를 일반 함수로서 호출하면 this에 undefined가 바인딩
- 생성자 함수가 아닌 일반 함수 내부에서는 this를 사용할 필요가 없기 때문
  - [chap20_12.js]
### arguments 객체
- strict mode에서는 매개변수에 전달된 인수를 재할당하여 변경해도 argumnets 객체에 반영되지 않는다.
  - [chap20_13.js]
- 