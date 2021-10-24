package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member var1);

    Optional<Member> findById(Long var1);

    Optional<Member> findByName(String var1);

    List<Member> findAll();
}
