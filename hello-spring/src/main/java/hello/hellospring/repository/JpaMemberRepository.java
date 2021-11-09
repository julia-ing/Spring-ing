package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em; // data-jpa 사용하면 스프링이 자동으로 EntityManger 생성해, 디비와의 통신을 내부에서 처리해주는 역할

    public JpaMemberRepository(EntityManager em) { // 엔티티 매니저 주입해주어야 함
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // persist: 영구 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // 조회할 타입과 식별자를 넣어줌
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
