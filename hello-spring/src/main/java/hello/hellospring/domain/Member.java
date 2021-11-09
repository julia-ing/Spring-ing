package hello.hellospring.domain;

import javax.persistence.*;

@Entity // jpa 가 관리하는 엔티티. jpa 는 인터페이스, hibernate 가 구현체
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 디비가 알아서 생성해주는 아이덴티티 전략
    private Long id;
//    @Column(name = "username") // 디비에 있는 username 컬럼과 매핑해줌
    private String name;

    public Member() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}