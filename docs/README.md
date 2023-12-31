### MODEL
#### 식당 방문 날짜
  - [x] 1~31 숫자 검증 함수
    - 아니면 `[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.` 발생
  - [x] 방문 날짜가 숫자로만 이뤄져있는지 검증하는 함수
  - [x] 크리스마스가 다가올 수록 늘어나는 할인 금액 반환
    -  1~25 만 가능
  - [x] 평일인지 주말인지 반환하는 함수
  - [x] 별이 있는 날짜인지 반환하는 함수
  
#### 메뉴 enum (메뉴(금액))
  - [x] String enum으로 반환하는 함수
####  카테코리 enum (항목(리스트(메뉴)))
  - [x] 메뉴가 어느 카테고리인지 반환하는 함수
####  주문한 메뉴들
  - Map에서 Key가 메뉴 Value 는 숫자 
  - [x] 주문한 메뉴 생성시 메뉴 enum의 반환함수 사용
    - [x] enum이 EMPTY면 `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.` 발생
    - [x] 숫자가 0 이하면 `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
  - [x] 음료만 주문했는지 확인하는 함수
     - 음료만 주문했음 `[ERROR]` 발생
  - [x] 메뉴개수 검증 함수 (최대 20개)
    -  21개 이상시 `[ERROR]` 발생
  - [x] 중목메뉴 입력 검증 함수 -> `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요`
  - [x] 할인 전 주문 금액
  - [x] 디저트 메뉴 개수 반환
  - [x] 메인 메뉴 개수 반환
####  배지 enum (배지(가격))
  -  [x] 배지 반환 함수
### VIEW
#### InputView
  - [ ] 식당 방문 날짜(숫자만 입력)
    - `[ERROR]` 잡기
  - [ ] 주문할 메뉴와 개수 (메뉴-개수 형식)
    - [ ] 메뉴 형식이 예시와 다른지 검증하는 함수 -> `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
      - `[ERROR]` 잡기
#### OutputView
  - [ ] 식당 방문 날짜에 받을 이벤트 혜택 머릿글 출력
  - [ ] 주문한 메뉴 재확인 출력
  - [ ] 할인전 총 주문 금액 출력
  - [ ] 증정 메뉴 출력 (메뉴 숫자개 형식)
  - [ ] 혜택 내역 출력 (할인명: -금액원 형식)
  - [ ] 총혜택 금액 출력 (-금액원 형식)
  - [ ] 할인 후 예상 결제 금액 출력 (금액원 형식)
  - [ ] 배지 출력
### Service
- [x] 할인 전 주문 금액이 10000 이상이면 이벤트 적용
    - [x] 크리스마스 할인
    - [x] 별이 있는 날짜 반환 함수를 통해 특별 할인
    - [x] 할인 전 주문 금액을 통해 증정 이벤트 반환
    - [x] 디저트 메뉴 할인
    - [x] 메인메뉴 할인
### Utils
- [ ] input에서 받은 주문할 메뉴와 개수 -,로 split 하기
##### 고민
- `[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.`
