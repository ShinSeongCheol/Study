# 다양한 효과와 애니메이션
## 효과 및 애니메이션 메서드
### 효과 메서드
---
#### hide() / show() 메서드
- hide() 메서드는 선택한 요소를 숨길 때 사용
- show() 메서드는 선택한 요소가 숨겨져 있을 경우 노출
- jquery_effect_1_test.html
#### toggle() 메서드
- 선택한 요소가 보이면 숨기고, 숨겨져있으면 나타나도록 만든다.
- jquery_effect_2_test.html
#### fadeOut(), fadeIn(), fadeToggle() 메서드
- fadeOut() 메서드는 선택한 요소를 숨길 때 사용
- fadeIn() 메서드는 선택한 요소가 숨겨져 있었다면 다시 나타나게 한다.
- fadeToggle() 메서드는 선택한 요소가 보이면 숨기고, 숨겨져 있으면 나타나게 한다.
- 투명해지게 만들어 숨기거나 점점 선명하게 만드는 효과
- jquery_effect_3_test.html
#### fadeTo() 메서드
- 선택한 요소를 지정한 투명도의 값까지 숨긴다.
- 투명도는 0에서 1사이의 값을 가질 수 있으며, 1에 가까울수록 선명하다.
- jquery_effect_4_test.html
#### slideUp(), slideDown(), slideToggle() 메서드
- slideUp() 메서드는 선택한 요소를 숨길 때 사용한다.
- slideDown() 메서드는 선택한 요소가 숨겨져 있으면 나타나게 한다.
- slideToggle() 메서드는 선택한 요소가 보이면 숨기고, 숨겨져 있으면 나타나게 한다.
- 위로 점차 접히면 숨겨지고, 드러날때는 점차 아래로 펼쳐지면서 노출된다.
- jquery_effect_5_test.html
#### animate() 메서드
- 선택한 요소에 다양한 동작 효과를 적용
- jquery_animate_1_test.html
### 효과 제어 메서드
---
#### stop() / delay() 메서드
- stop() 메서드는 선택한 요소에 효과 또는 애니메이션이 적용된 효과를 정지
- delay() 메서드는 선택한 요소에 효과 또는 애니메이션이 실행될 때 시작되는 시간을 지연
- jquery_animate_2_test.html
#### queue() / clearQueue() 메서드
- queue() 메서드는 큐에 저장된 함수 또는 메서드를 반환하거나 큐에 함수를 저장하고 저장한 이후에 적용된 메서드는 모두 제거
- clearQueue() 메서드는 큐에 들어와 대기중인 메서드 중 최초에 들어와 실행 중인 메서드만 제외하고 모든 대기중인 메서드는 제거
- jquery_animate_6_test.html
#### dequeue() 메서드
- 선택한 요소 큐에 대기 중인 모든 메서드 또는 함수를 제거
- jquery_animate_7_test.html
#### finish() 메서드
- 선택한 요소에 애니메이션 동작 과정은 모두 생략하고, 최종 완료 시점만 보여주고 종료
- jquery_animate_8_test.html
### 애니메이션을 이용한 롤링 슬라이드 배너 만들기
---
#### 롤링 슬라이드 배너
- rorrling_slider_banner_test.html
### Mission
---
#### Mission
- jquery_effect_test1_a.html
- jquery_effect_test2_a.html