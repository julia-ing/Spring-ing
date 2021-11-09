package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 스프링 데이터 jpa 가 구현체를 자동으로 만들어주고 스프링 빈에 자동으로 등록해준다 (프록시 기술 이용)
 * 기본 crud 와 단순 조회, 페이지 기능 등 자동 제공해줌
 * 실무에서는 JPA + 스프링 데이터 JPA 기본 사용, 복잡한 동적 쿼리는 Querydsl 사용 -> 이걸로 해결 안되면 네이티브 쿼리나 JdbcTemplate
 */

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    // 메서드 이름만으로 조회 기능을 제공해줌 ex) findByNameAndEmail ...
    Optional<Member> findByName(String name); // JPQL select m from Member m where m.name = ?
}
