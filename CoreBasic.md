# Spring Core Basic

- 🌸 [섹션 1. 객체 지향 설계와 스프링](#섹션-1.-객체-지향-설계와-스프링)
- 🧩 [섹션 2. 스프링 핵심 원리 이해1 - 예제 만들기](https://github.com/julia-ing/Spring-ing/blob/main/CoreBasic.md#%EC%84%B9%EC%85%98-2-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EC%9D%B4%ED%95%B41---%EC%98%88%EC%A0%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0)
- 💫 [섹션 3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용](https://github.com/julia-ing/Spring-ing/blob/main/CoreBasic.md#%EC%84%B9%EC%85%98-3-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EC%9D%B4%ED%95%B42---%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%9B%90%EB%A6%AC-%EC%A0%81%EC%9A%A9)

---

## 섹션 1. 객체 지향 설계와 스프링
## 🌱 스프링이란?
Spring Framework, Spring Boot(스프링을 편리하게 사용할 수 있도록 도와줌), Spring Data, Spring Cloud 등 여러 프로젝트들의 집합

스프링은 객체 지향 언어인 자바 기반 프레임워크로, **좋은 객체 지향** 애플리케이션을 개발할 수 있게 해주는 프레임워크

### 기술 요약
- 핵심 기술: 스프링 DI 컨테이너, AOP, 이벤트
- 웹 기술: 스프링 MVC, 스프링 WebFlux
- 데이터 접근 기술: 트랜잭션, JDBC, ORM 지원, XML 지원
- 기술 통합: 캐시, 이메일, 원격접근, 스케줄링
- 테스트: 스프링 기반 테스트 지원
- 언어: 코틀린, 그루비

최근 Spring Boot 등장
### Spring Boot의 장점
Tomcat 같은 **웹 서버**를 내장해서 별도 웹 서버를 설치하지 않아도 되고, 손쉬운 빌드 구성을 위한 **starter 종속성**을 제공해주고, **외부 라이브러리**를 자동 구성해주는 등 단독으로 실행할 수 있는 Spring 애플리케이션을 **쉽게** 생성!!

## 👀 좋은 객체 지향 프로그래밍이란?
### 객체 지향 프로그래밍
컴퓨터 프로그램을 명령어의 목록이 아닌 "객체"들의 모임으로 보는 것. OOP가 대규모 소프트웨어 개발에 많이 사용되는 이유는 프로그램은 유연하고 변경이 용이하게 만들기 때문이다.

### 다형성
개념 : **역할**과 **구현**을 분리 

-> 장점 (핵심은 클라이언트!!)

    - 클라이언트에 영향을 주지 않고 새로운 기능을 제공할 수 있음
    - 클라이언트는 대상의 역할만 알면 되고 구현 대상의 내부 구조는 몰라도 됨
    - 클라이언트는 구현 대상의 내부 구조나 구현 대상 자체가 변경되어도 영향을 받지 않음
    - 유연하고 변경이 용이 -> 확장 가능한 설계

자바에서는 ..

역할 = 인터페이스, 구현 = 인터페이스를 구현한 클래스 (구현 객체)

**오버라이딩**을 떠올려보자. 다형성으로 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.
-> 다형성의 본질 : **클라이언트를 변경하지 않고 서버의 구현 기능을 유연하게 변경할 수 있다!!**

결론은 인터페이스를 안정적으로 잘 설계하는 것이 중요

## 🖐 좋은 객체 지향 설계의 5가지 원칙 (SOLID)

1. SRP(Single Responsibility principle): 단일 책임 원칙

   - 하나의 클래스는 하나의 책임만 가져야 함. "하나의 책임"의 중요 기준은 "변경".

   : 변경이 있을 때 파급 효과가 적어야 한다.


2. **OCP(Open-Closed Principle): 개방 폐쇄의 원칙**

   - 소프트웨어 요소는 **확장에는 열려** 있으나 **변경에는 닫혀** 있어야 함

   How? - 다형성 활용 (구현 클래스를 추가해서 새로운 기능을 구현)

   그러나 이때 클라이언트가 구현 클래스를 선택하면서 클라이언트 코드를 변경해야 하기 때문에 OCP가 위반된다.
   이를 해결하기 위해 객체를 생성하고 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다. (-> DI와 IoC 컨테이너 개념)


3. LSP(Liskov Substitution Principle): 리스코프 치환 원칙

   - 다형성을 지원하기 위한 원칙, 구현 클래스는 인터페이스 규약을 모두 지켜야 함


4. ISP(Interface Segregation Principle): 인터페이스 분리 원칙

   - 특정 클라이언트를 위한 인터페이스 여러 개가 하나의 범용 인터페이스보다 좋음

   분리하면 인터페이스가 변해도 클라이언트에 영향을 주지 않으며, 인터페이스가 명확해지고 대체 가능성이 높아진다는 장점이 있다.


5. **DIP(Dependency Inversion Principle): 의존관계 역전 원칙**

   - 구체화가 아닌 추상화에 의존해야 함 - 클라이언트 코드가 구현 클래스가 아닌 인터페이스를 바라보아야 함

   그러나 클라이언트가 구현 클래스를 직접 선택하게 되면서 인터페이스뿐만 아니라 구현 클래스에도 동시에 의존하게 되어 DIP가 위반된다. 해결 방법은 나중에..

   `ex) MemberRepository m = new MemoryMemberRepository();`

## 🔮 객체 지향 설계와 스프링

위에서 본 것처럼 **다형성만으로는 OCP, DIP를 지킬 수 없다.**

```
스프링은 다형성 + OCP, DIP를 가능하게 지원한다!
-> DI 컨테이너 제공
-> 클라이언트의 코드 변경 없이 기능 확장 
```

---

## 섹션 2. 스프링 핵심 원리 이해1 - 예제 만들기
## ✨ 요구사항과 설계

<회원 / 주문 도메인 협력 관계> - 기획자들도 볼 수 있는 그림

<img width="593" alt="스크린샷 2022-03-14 오후 5 25 10" src="https://user-images.githubusercontent.com/77239220/158133090-189c0e23-37b7-4046-9085-9728f221898a.png">
<img width="593" alt="스크린샷 2022-03-14 오후 6 20 30" src="https://user-
images.githubusercontent.com/77239220/158142385-0edd691f-043f-4146-af48-73b84f9f916e.png">

<회원 / 주문 클래스 다이어그램> - 도메인 협력 관계를 바탕으로 개발자가 설계, 서버를 실행하지 않고 클래스들만 분석

      참고: 인터페이스 구현체가 하나밖에 없으면 관습적으로 뒤에 Impl 을 붙인다.

<img width="593" alt="스크린샷 2022-03-14 오후 5 33 02" src="https://user-images.githubusercontent.com/77239220/158134292-3dc75b22-7cbd-49fb-b14a-06106faef685.png">
<img width="593" alt="스크린샷 2022-03-14 오후 6 20 39" src="https://user-images.githubusercontent.com/77239220/158142421-68aabebc-d704-469c-bc76-6d3bd6f93bf3.png">

<회원 / 주문 객체 다이어그램> - 서버가 뜰 때 결정되는. 클라이언트가 실제 사용하는 것들을 표시

<img width="596" alt="스크린샷 2022-03-14 오후 5 34 18" src="https://user-images.githubusercontent.com/77239220/158134501-c2633c88-736e-4b4f-985d-1dcd3a246543.png">
<img width="594" alt="스크린샷 2022-03-14 오후 6 20 47" src="https://user-images.githubusercontent.com/77239220/158142445-84ba4eaa-9a36-4d27-ada6-dfb99e1385fc.png">

## ❓ 현재 코드의 문제점

```java
public class MemberServiceImpl implements MemberService {

   private final MemberRepository memberRepository = new MemoryMemberRepository();
}
```

현재 코드는 추상화에도 의존하고 구체화에도 의존하기 때문에 DIP를 위반한다. 

---

## 섹션 3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용
## 🌚 새로운 할인 정책 적용과 문제점

```java
public class OrderServiceImpl implements OrderService {

   //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
   private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
}
```

1. 다형성도 활용하고, 역할(인터페이스)과 구현을 잘 분리했다. -> OK!
2. OCP, DIP 객체지향 설계 원칙을 잘 준수했다. -> NO..

   > WHY? 
   1. DIP
      
      'OrderServiceImpl는 DiscountPolicy 인터페이스에 의존하며 DIP를 잘 지킨 것 같은데?'
      1. but.. 인터페이스뿐 아니라 구현 클래스(FixDiscountPolicy, RateDiscountPolicy)에도 의존하고 있다.
   2. OCP
      1. FixDiscountPolicy를 Rate 로 바꾸는 순간 OrderServiceImpl 코드를 함께 변경해야 하므로 OCP 위반이다.

## 🔥 관심사의 분리

AppConfig -> 애플리케이션의 전체 동작 방식을 구성하기 위해 **구현 객체를 생성 및 연결**하는 책임을 갖는 별도의 설정 클래스

```java
public class AppConfig {

    /**
     * OCP, DIP 를 만족하기 위해 기존 코드에서 추상과 구현을 분리 -> 전체 설정 파일인 AppConfig 에서 설정
     * AppConfig 는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
     * 생성자 주입을 함으로써 추상화(인터페이스)에만 의존하게 됨
      */

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
```
<의존관계 주입 - DI(Dependency Injection)>

<img width="579" alt="스크린샷 2022-03-24 오후 9 07 35" src="https://user-images.githubusercontent.com/77239220/159912892-3c23161d-9223-4aea-9858-d49b6afeaaf3.png">
<img width="581" alt="스크린샷 2022-03-24 오후 9 03 42" src="https://user-images.githubusercontent.com/77239220/159912317-581b37db-1d36-484a-a86e-811cf899a6da.png">

-> 이제 클라이언트인 MemberServiceImpl은 추상인 MemberReposiroty에만 의존하면 됨. 즉 구체 클래스를 몰라도 된다!
-> SRP, OCP, DIP 더 잘 지키는 구조

## 🛠 AppConfig 리팩터링

위의 AppConfig 는 중복도 있고, 역할에 따른 구현이 잘 보이지 않는다.

```java
public class AppConfig {

   public MemberService memberService() { // 추상
      return new MemberServiceImpl(memberRepository()); // 구현
   }

   private MemberRepository memberRepository() { // 추상
      return new MemoryMemberRepository(); // 구현
   }

   public OrderService orderService() { // 추상
      return new OrderServiceImpl(memberRepository(), discountPolicy()); // 구현
   }

   public DiscountPolicy discountPolicy() { // 추상
      return new FixDiscountPolicy(); // 구현
   }
}
```

-> MemoryMemberRepository() 중복을 제거했고, 추상/구현이 명확이 분리되어 보인다. 

## 🚥 IoC, DI, 그리고 컨테이너

> 제어의 역전 IoC (Inversion of Control)
   
   프로그램의 제어 흐름을 프로그래머가 직접 제어하는 것이 아닌 외부에서 관리하는 것.

   AppConfig 등장 이후, 구현 객체를 자신의 로직을 실행하는 데에만 집중할 수 있게 됨. 
   클라이언트 입장에서는 어떤 서버 구현 객체가 생성될 지 모름.

   **프레임워크 vs 라이브러리** -> 프레임워크가 내가 작성한 코드를 제어하고 대신 실행하면 프레임워크 (예시: JUnit) / 
   내가 작성한 코드가 직접 제어 흐름을 담당하면 라이브러리

> 의존관계 주입 DI (Dependency Injection)

   애플리케이션 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는 것.

   - DI를 사용하면 클라이언트 코드는 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
   - **정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경 가능하다.**

   의존관계는 **정적인 클래스 의존관계**와, 실행 시점에 결정되는 **동적인 객체 의존관계**를 분리해서 생각해야 한다.

> 컨테이너

   AppConfig 처럼 객체를 생성 및 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너, 혹은 **DI 컨테이너**라고 한다.
   
## 🧚 스프링으로 전환하기

1. AppConfig

   - AppConfig에 설정을 구성한다는 뜻의 @Configuration 을 붙여준다. 
   - 각 메서드에 @Bean 을 붙여준다. -> 스프링 컨테이너에 스프링 빈으로 등록

2. OrderApp
   
   ```java
   public class OrderApp {

    public static void main(String[] args) {

   //        AppConfig appConfig = new AppConfig();
   //        MemberService memberService = appConfig.memberService();
   //        OrderService orderService = appConfig.orderService();
   
           ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
   
           MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
           OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
       }
   }
   ```

   - 이전에는 개발자가 필요한 객체를 AppConfig 를 사용해서 직접 조회했지만, 이제는 스프링
     컨테이너(ApplicationContext)를 통해서 필요한 스프링 빈(객체)를 찾아야 함!
     
     -> **applicationContext.getBean()** 메서드를 사용해 스프링 빈을 찾을 수 있음