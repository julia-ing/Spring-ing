package hello.core.singleton;

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
