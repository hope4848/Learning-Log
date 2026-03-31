# ⚔️ Java RPG Character System (OOP 실습)

자바의 **추상 클래스(Abstract Class)**와 **인터페이스(Interface)**를 활용하여 확장성 있는 RPG 캐릭터 시스템을 구현한 저장소입니다.

## 🚀 프로젝트 핵심 개념
본 프로젝트는 다음과 같은 자바의 객체지향 원칙을 준수하여 설계되었습니다.

*   **추상화 (Abstraction)**: `Character` 추상 클래스를 통해 공통 속성과 동작(`levelUp`)을 정의했습니다.
*   **상속 (Inheritance)**: `Warrior`, `Wizard`, `Paladin` 클래스가 부모의 기능을 물려받아 코드 중복을 최소화했습니다.
*   **인터페이스 (Interface)**: `Healable`(치료), `pumping`(광역 버프) 등 특정 기능을 독립된 규격으로 분리했습니다.
*   **다형성 (Polymorphism)**: `instanceof`와 `ArrayList`를 활용하여 각 캐릭터의 정체성에 맞는 기술을 동적으로 실행합니다.

---

## 🛠️ 시스템 구조

### 1. 부모 클래스
*   **Character (Abstract)**: 이름, 레벨 관리 및 공통 레벨업 로직 담당.

### 2. 인터페이스 (자격증)
*   **Healable**: 아군을 치료할 수 있는 능력 정의.
*   **pumping**: 파티원 전체의 능력치를 증폭시키는 광역 버프 능력 정의.

### 3. 직업별 특징
| 직업 | 상속/구현 | 고유 기능 |
| :--- | :--- | :--- |
| **전사 (Warrior)** | Character | 힘(strength) 기반 공격, 함성(shout) |
| **마법사 (Wizard)** | Character, pumping | 지능(intelligence) 기반 공격, 광역 버프(pumpALL) |
| **성기사 (Paladin)** | Character, Healable | 둔기 공격, 아군 치료(heal) |

---

## 🔍 핵심 로직 설명

### 광역 버프 시스템 (pumping)
마법사가 시전하는 `pumpALL` 메서드는 `ArrayList<Character>`를 인자로 받아 파티원 전체를 순회하며, `instanceof`를 통해 직업별 맞춤형 버프를 제공합니다.

```java
public void pumpALL(ArrayList<Character> targets) {
    for (Character c : targets) {
        if (c instanceof Warrior w) {
            w.setStrength(w.getStrength() + 30); 
        } else if (c instanceof Wizard t) {
            t.setIntelligence(t.getIntelligence() + 30);
        }
    }
}
```
