# Spring Core Basic

- 🌸 [섹션 1. 객체 지향 설계와 스프링](#섹션-1.-객체-지향-설계와-스프링)
- 🧩 [섹션 2. 스프링 핵심 원리 이해1 - 예제 만들기](https://github.com/julia-ing/Spring-ing/blob/main/CoreBasic.md#%EC%84%B9%EC%85%98-2-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EC%9D%B4%ED%95%B41---%EC%98%88%EC%A0%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0)
- 💫 [섹션 3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용](https://github.com/julia-ing/Spring-ing/blob/main/CoreBasic.md#%EC%84%B9%EC%85%98-3-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EC%9D%B4%ED%95%B42---%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%9B%90%EB%A6%AC-%EC%A0%81%EC%9A%A9)
- 🦄 [섹션 4. 스프링 컨테이너와 스프링 빈](https://github.com/julia-ing/Spring-ing/blob/main/CoreBasic.md#%EC%84%B9%EC%85%98-4-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%EC%99%80-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B9%88)
- 🏖 [섹션 5. 싱글톤 컨테이너](https://github.com/julia-ing/Spring-ing/blob/main/CoreBasic.md#%EC%84%B9%EC%85%98-5-%EC%8B%B1%EA%B8%80%ED%86%A4-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88)
- 🦕 [섹션 6. 컴포넌트 스캔](https://github.com/julia-ing/Spring-ing/blob/main/CoreBasic.md#%EC%84%B9%EC%85%98-6-%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8-%EC%8A%A4%EC%BA%94)
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

---

## 섹션 4. 스프링 컨테이너와 스프링 빈
## 🤖 스프링 컨테이너 생성

ApplicationContext 는 스프링 컨테이너(인터페이스) 이다. AnnotationConfigAoolicationContext 가 구현체.

> 스프링 컨테이너 생성 과정

1. 스프링 컨테이너 생성

<img width="776" alt="스크린샷 2022-03-31 오전 2 37 30" src="https://user-images.githubusercontent.com/77239220/160897155-ea414ca8-787a-4314-84b4-a035e319a790.png">

2. 스프링 빈 등록

<img width="779" alt="스크린샷 2022-03-31 오전 2 38 19" src="https://user-images.githubusercontent.com/77239220/160897394-23ec0eb8-adf4-4097-9e98-dde5c50c6c11.png">

스프링 빈 이름은 중복되면 안됨

3. 스프링 빈 의존관계 설정

<img width="780" alt="스크린샷 2022-03-31 오전 2 40 04" src="https://user-images.githubusercontent.com/77239220/160901902-78bbc5f1-a14f-4184-b94d-2ee301a9cee3.png">

스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입함 (= DI). 

원래 스프링은 1. 빈을 생성 2. 의존관계 주입 하는 단계가 나누어져 있다. 하지만 자바 코드로 스프링 빈을 등록하면 생성자를 호출하면서 의존관계 주입도 한번에 처리된다!

## 🍎 스프링 빈 조회

- ac.getBean(빈이름, 타입) -- 기본적으로 빈이름은 생략 가능
- 타입으로 조회시 같은 타입의 스프링 빈이 둘 이상이면 오류가 발생하기 때문에 이때는 빈 이름을 지정해주면 됨. 
- ac.getBeansOfType() 으로 해당 타입의 모든 빈을 조회 가능

<스프링 빈 상속관계>

- 부모 타입으로 조회하면 자식 타입도 함께 조회된다 -> Object 타입으로 조회 시 모든 스프링 빈 조회됨

## 🏭 BeanFactory & ApplicationContext

<img width="781" alt="스크린샷 2022-04-01 오후 1 26 11" src="https://user-images.githubusercontent.com/77239220/161194857-9434a4ee-e147-43ae-ae97-78e8b694c1d2.png">

1. BeanFactory
   
   : 스프링 컨테이너의 최상위 인터페이스로, 빈을 관리/조회한다.

2. ApplicationContext

   : BeanFactory 기능을 모두 상속받아서 제공 + 부가 기능

   - MessageSource (국제화 - 한국에서 들어오면 한국어로)
   - EnvironmentCapable (로컬, 개발, 운영 등을 구분해서 처리)
   - ApplicationEventPublisher (이벤트를 발행하고 구독하는 모델을 편리하게 지원)
   - ResourceLoader (파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회)

이 둘을 모두 스프링 컨테이너라고 하고, 보통 ApplicationContext를 사용한다.

## 🌻 스프링 빈 설정 메타 정보 - BeanDefinition

<스프링은 어떻게 다양한 설정 형식을 지원하는 걸까?>

-> **역할과 구현을 개념적으로 나눴기 때문**

스프링 컨테이너는 자바 코드인지 XML인지 몰라도 되고 오직 **BeanDefinition이라는 인터페이스(추상화)** 에만 의존한다. 

이 BeanDefinition을 빈 설정 메타 정보라고 하며 `@Bean`, `<bean>` 당 각각 하나씩 메타 정보가 생성된다. 스프링 컨테이너는 이 메타정보를 기반으로 스프링 빈을 생성한다.

- AnnotationConfigApplicationContext 는 AnnotatedBeanDefinitionReader 를 사용해 AppConfig.class 를 읽고 BeanDefinition 을 생성한다.

---

## 섹션 5. 싱글톤 컨테이너
## 🦓 싱글톤 패턴

웹 애플리케이션은 보통 많은 고객들이 동시에 요청을 보내는데, 스프링을 사용하지 않은 순수 DI 컨테이너는 요청마다 새로운 객체를 생성한다.
이는 엄청난 메모리의 낭비를 발생시킴

-> 싱글톤 패턴 등장 

- 클래스의 인스턴스가 딱 **1개만** 생성되는 것을 보장하는 디자인 패턴
- how? : **private 생성자**를 사용해 외부에서 임의로 new 키워드를 사용하지 못하도록 함

```java
public class SingletonService {

   // static 영역에 객체를 딱 1개만 생성해둔다
   private static final SingletonService instance = new SingletonService();

   public static SingletonService getInstance() {  // 조회할 때는 이 메서드를 사용한다.
      return instance;
   }

   // private 생성자 -> 외부에서 new 키워드로 새로운 객체 생성을 못하게 막는다
   private SingletonService() {
   }

   public void logic() {
      System.out.println("싱글톤 객체 로직 호출");
   }
}
```

싱글톤 패턴을 사용하는 테스트 코드를 보면, 

`SingletonService singletonService1 = SingletonService.getInstance();`
-- private 생성자로 구현했기 때문에 new 키워드를 사용하지 않는다.

- 싱글톤 패턴을 사용하면 요청이 들어올 때마다 객체를 생성하는게 아니라 이미 만들어진 객체를 **공유**해서 **효율**적 사용이 가능하다.
- 그러나.. 문제점:
  1. 구현 코드 자체가 많이 들어감
  2. 의존관계상 클라이언트가 구체 클래스에 의존 -> DIP 위반
  3. 2번에 의해 OCP 위반 가능성이 높음
  4. 테스트가 어려움
  5. 내부 속성 변경/초기화가 어려움
  6. private 생성자로 자식 클래스를 만들기 어려움
  7. 결론적으로 유연성이 떨어진다..

## 😇 싱글톤 컨테이너

스프링 컨테이너는 싱글톤 패턴의 위와 같은 문제점들을 해결하면서 객체 인스턴스를 싱글톤으로 관리!

스프링 빈 - 싱글톤으로 관리되는 빈

```java
public class SingletonTest {
   @Test
   @DisplayName("스프링 컨테이너와 싱글톤")
   void springContainer() {
//        AppConfig appConfig = new AppConfig();
      ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

      MemberService memberService1 = ac.getBean("memberService", MemberService.class);
      MemberService memberService2 = ac.getBean("memberService", MemberService.class);

      System.out.println("memberService1 = " + memberService1);
      System.out.println("memberService2 = " + memberService2);

      assertThat(memberService1).isSameAs(memberService2);
   }
}
```
<img width="776" alt="스크린샷 2022-04-07 오전 1 53 44" src="https://user-images.githubusercontent.com/77239220/162027246-5bb585f4-60c5-4ead-9b35-137470d577b1.png">

## 🗼 싱글톤 방식의 주의점 -- 중요

객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은 여러 클라이언트가 하나의 같은 인스턴스를 공유하기 때문에
**싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다!**

-> **무상태(stateless)** 로 설계해야 함
   1. 특정 클라에 의존적인 필드가 있으면 안됨
   2. 특정 클라가 값을 변경할 수 있는 필드가 있으면 안됨
   3. 가급적 읽기만 가능해야 함
   4. 필드 대신에 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야 함

스프링 빈의 필드에 공유 값을 설정하면 문제 발생 가능..

- stateful 한 상태
```java
public class StatefulService {

    private int price; //싱태를 유지하는 필드 10000 -> 20000

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;  //여기가 문제
    }

    public int getPrice() {
        return price;
    }
}
```

- stateless 하게 변경한 상태
```java
public class StatefulService {
    public int order(String name, int price) {  // 공유 필드 제거 -> stateless 하게 변경
        System.out.println("name = " + name + " price = " + price);
        return  price;
    }
}
```

## ☕ @Configuration

현재의 AppConfig 를 보면 이상한 점이 있다.

: memberService 빈을 만드는 코드에서 memberRepository() 를 호출하고 여기서 또 new MemoryMemberRepository() 를 호출한다. 
orderService 빈을 만드는 코드도 동일하게 memberRepository() 를 호출하고 new MemoryMemberRepository() 를 호출한다.
-> 결과적으로 각각 다른 2개의 MemoryMemberRepository 가 생성되면서 싱글톤이 깨지는 것처럼 보인다.

그러나!! 테스트 코드로 확인해보면 **모두 같은 memberRepository 인스턴스를 공유**하는 것이 확인된다.

```java
public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
```

스프링 컨테이너는 어떻게 이 문제를 해결한 것일까?

사실 AnnotationConfigApplicationContext 에 파라미터로 넘긴 값은 스프링 빈으로 등록된다. 따라서 AppConfig 도 스프링 빈이 되는데,
AppConfig 스프링 빈을 조회해서 클래스 정보를 출력해보자.

```java
public class ConfigurationSingletonTest {

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$82499f6e
    }
}
```

순수한 클래스라면 `class hello.core.AppConfig` 이렇게 출력되어야 함.

But.. 클래스 명에 ~CGLIB 가 붙음 

-> 내가 만든 클래스가 아니라 스프링이 *CGLIB 라는 바이트코드 조작 라이브러리*를 사용해서 
**AppConfig 클래스를 상속받은 임의의 다른 클래스**를 만들고, 
그 클래스를 스프링 빈으로 등록한 것.

<img width="777" alt="스크린샷 2022-04-07 오후 11 09 55" src="https://user-images.githubusercontent.com/77239220/162218905-40ed9744-18fc-4c96-9aef-16a1a47265be.png">

이 임의의 다른 클래스가 싱글톤 보장!


AppConfig@CGLIB 예상 코드
```
@Bean
public MemberRepository memberRepository() {
    if (memoryMemberRepository가 이미 스프링 컨테이너에 등록되어 있으면?) { 
        return 스프링 컨테이너에서 찾아서 반환;
    } else { //스프링 컨테이너에 없으면
        기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록 
        return 반환
    } 
}
```

Q. <@Configuration 을 붙이면 바이트코드를 조작하는 CGLIB 기술로 싱글톤을 보장하지만, 만약 @Bean 만 적용한다면?>

bean = class hello.core.AppConfig
    : AppConfig가 CGLIB 기술 없이 순수한 AppConfig 로 스프링 빈에 등록되었고,
테스트 코드에서 memberRepository가 3번 호출되면서 싱글톤이 깨진 것을 볼 수 있다.

따라서 스프링 설정 정보는 항상 @Configuration 을 사용해 싱글톤을 보장하자.

---
## 섹션 6. 컴포넌트 스캔
## 🐯 컴포넌트 스캔과 의존관계 자동 주입 시작하기

등록해야 할 스프링 빈이 엄청 많아지면 설정 정보도 커지고 귀찮아짐..

반복을 없애기 위해, 스프링은 자동으로 스프링 빈을 등록하는 컴포넌트 스캔 기능과 의존관계 자동 주입하는 @Autowired 기능 제공

```java
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
```
- 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자는 소문자로 된다. (ex: MemberServiceImpl 클래스 -> memberServiceImpl)
  / 직접 이름 지정도 가능 : @Component("memberService2")


전에는 AppConfig에서 `return new MemberServiceImpl(memberRepository());` 와 같이 명시적으로 주입을 했다면,
이제는
Bean 수동 등록이 아니라 ComponentScan을 쓰기 때문에 자동주입(@Autowired) 필요!

```java
@Component
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired  // Bean 수동 등록이 아니라 ComponentScan을 쓰면 자동주입 필요
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
```

<img width="888" alt="스크린샷 2022-04-08 오전 2 50 42" src="https://user-images.githubusercontent.com/77239220/162265781-4fb1b894-75bc-4219-b33e-fb4de155c8e9.png">

- Autowired 에서 기본적으로 스프링 빈을 조회하는 전략은, **타입이 같은 빈**을 찾아서 주입하는 것!

## 🌿 탐색 위치와 기본 스캔 대상

```java
@ComponentScan(
        basePackages = "hello.core" // core와 core 하위 패키지들만 컴포넌트 스캔의 대싱이 됨
}
```

basePackages 를 따로 지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

보통 basePackages 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 방법을 사용한다.
+ 참고로 스프링 부트를 사용하면 @SpringBootApplication 를 관례적으로 프로젝트 시작 루트 위치에 두는데 이 설정 안에 @ComponentScan 이 들어있다. 
따라서 스프링 부트를 쓰면 @ComponentScan 안 적어도 되긴 함..

<컴포넌트 스캔 기본 대상>
: @Component, @Controller, @Service, @Repository, @Configuration

<부가 기능>

- @Controller : 스프링 MVC 컨트롤러로 인식
- @Repository : 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환
- @Configuration : 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리
- @Service : 특별한 처리는 없지만 @Service로 개발자들이 비즈니스 계층을 쉽게 인식

## 🍖 필터

```java
@ComponentScan(
      includeFilters = {
            @Filter(type = FilterType.ANNOTATION, classes =
    MyIncludeComponent.class),
      },
      excludeFilters = {
            @Filter(type = FilterType.ANNOTATION, classes =
    MyExcludeComponent.class),
            @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class)
      }
)
```

- includeFilters - 컴포넌트 스캔 대상 추가 / 
excludeFilters - 컴포넌트 스캔에서 제외

- FilterType의 5가지 옵션
  
    1. ANNOTATION: 기본값, 애노테이션을 인식해 동작

       ex) org.example.SomeAnnotation 
  
    2. ASSIGNABLE_TYPE: 지정한 타입과 자식 타입을 인식해 동작

       ex) org.example.SomeClass 
  
    3. ASPECTJ: AspectJ 패턴 사용 

       ex) org.example..*Service+ 
  
    4. REGEX: 정규 표현식 
       
       ex) org\.example\.Default.*
  
    5. CUSTOM: TypeFilter 이라는 인터페이스를 구현해서 처리 

       ex) org.example.MyTypeFilter

- @Component 면 충분하기 때문에 includeFilters/excludeFilters 사용할 일은 거의 없음.

  - 최근 스프링 부트는 컴포넌트 스캔을 기본으로 제공하는데, 스프링의 기본 설정에 최대한 맞추어 사용하는 것을 권장

## 🚙 중복 등록과 충돌

컴포넌트 스캔에서 같은 빈 이름을 등록하면 어떻게 될까?

1. 자동 빈 등록 vs 자동 빈 등록
    - 컴포넌트 스캔에 의해 자동으로 스프링 빈이 등록되는데, 그 이름이 같은 경우 스프링은 ConflictingBeanDefinitionException 예외를 발생시킴
2. 수동 빈 등록 vs 자동 빈 등록

    - 수동 빈 등록이 우선권을 가짐 (수동 빈이 자동 빈을 오버라이딩 해버린다.)
    - 최근 스프링 부트에서는 이 경우 기본적으로 오류 발생시킴
