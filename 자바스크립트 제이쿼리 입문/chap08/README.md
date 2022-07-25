# 제이쿼리 이벤트
## 로딩 이벤트 메서드
---
### load()
- 이미지나 프레임에서 사용
### ready()
- 문서 객체에서 사용
### 관련 소스 코드
- jquery_event_1_test.html
## 마우스 이벤트
---
### click()
- 선택한 요소를 클릭했을 때 발생하는 이벤트
### dblclick()
- 선택한 요소를 연속으로 두 번 클릭했을 때 이벤트를 발생
### 관련 소스 코드
- jquery_event_2_test.html
### a 태그에 click dblclick 메서드를 등록했을때 이동하지 않게 하는 방법
- return flase를 사용
- preventDefault()메서드를 사용
### 관련 소스 코드
- jquery_event_3_test.html
### mouseover()
- 선택한 요소에 마우스가 올렸을 때 발생하는 이벤트
### mouseout()
- 선택한 요소에서 마우스가 벗어났을 때 발생하는 이벤트
### hover()
- 선택한 요소에 마우스가 올라가고 벗어날 때마다 발생하는 이벤트
### 관련 소스 코드
- jquery_event_4_test.html
### mouseenter()
- 선택한 요소 경계 범위내에 마우스가 올라갔을때 발생하는 이벤트
### mouseleave()
- 선택한 요소 경계 범위내에 마우스가 벗어났을때 발생하는 이벤트
### 관련 소스 코드
- jquery_event_5_test.html
### mousemove()
- 선택한 요소 영역에서 마우스를 움직일때마다 발생하는 이벤트
### 관련 소스 코드
- jquery_event_6_test.html
## 포커스 이벤트
---
### focus()
- 선택한 요소에 포커스가 이동되었을 때 이벤트를 발생
### focusin()
- 선택한 요소에 포커스가 이동되었을 때 이벤트를 발생 (강제 발생시킬 수 없다)
### blur()
- 선택한 요소에 포커스가 다른 요소로 이동되어 사라졌을때 이벤트가 발생
### focusout()
- 선택한 요소에 포커스가 다른 요소로 이동되어 사라졌을때 이벤트가 발생 (강제 발생시킬 수 없다.)
### 관련 소스 코드
- jquery_event_7_test.html
### on()
- 여러가지 이벤트를 한번에 사용하고 싶을 때 사용
### 관련 소스 코드
- jquery_event_11_test.html
## 키보드 이벤트
--- 
### keydown()
- 선택한 요소에서 키보드 자판을 눌럿을 때 이벤트를 발생
### keypress()
- 선택한 요소에서 키보드 자판을 눌렀을 때 이벤트를 발생(자판에 대한 고유 키값을 전부 받아오지 못함)
### keyup()
- 선택한 요소에서 키보드에 자판을 눌렀다 떼었을 때 이벤트가 발생
### 관련 소스 코드
- jquery_event_8_test.html
## 자주 사용되는 기타 이벤트 메서드
--- 
### change()
- 선택한 입력 요소에 값이 새값으로 바뀌고 포커스가 다른 요소로 이동되었을 때 이벤트가 발생
### 관련 소스 코드
- jquery_event_9_test.html
### scroll()
- 브라우저에 스크롤바가 이동할 때마다 이벤트를 발생
### 관련 소스 코드
- jquery_event_10_test.html
### $(this) 선택자
- 이벤트가 등록된 요소를 가르킨다.
### 관련 소스 코드
- jquery_event_this_test.html
### index()
- 이벤트를 등록한 요소 중 이벤트가 발생한 요소의 인덱스 값을 반환
### 관련 소스 코드
- jquery_event_index_test.html
## 그룹 이벤트 등록 메서드
---
### on()
- 선택한 요소에 한 개 이상의 이벤트를 등록할 수 있다.
### 관련 소스 코드
- jquery_event_12_test.html
### bind()
- 선택한 요소에 여러 개의 이벤트를 등록하는 메서드
### 관련 소스 코드
- jquery event_13_test.html
### delegate()
- 선택한 요소의 하위 요소에 여러 개의 이벤트를 등록할 수 있다.
### 관련 소스 코드
- jquery_event_14_test.html
### one()
- 선택한 요소에 이벤트 등록 한번 이벤트가 발생하면 자동으로 등록된 이벤트가 제거
### 관련 소스 코드
- jquery_event_16_test.html
## 이벤트 제거 메서드
---
### off()
- 선택한 요소에 등록된 이벤트를 제거
### unbind()
- 선택한 요소에 등록된 이벤트 제거
### 관련 소스 코드
- jquery_event_15_test.html
## 이벤트를 이용한 폰트 꾸미기 기능 만들기
---
### 관련 소스 코드
- event_last_test.html
## Mission
---
### 관련 소스 코드
- jquery_event_test1.html
- jquery_event_test3_a.html