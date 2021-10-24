package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// @Repository
public class MemoryMemberRepository implements MemberRepository {
    // 실무에서는 동시성 문제로 concurrentHashMap, atomicLong 을 사용
    private static Map<Long, Member> store = new HashMap();
    private static long sequence = 0L;

    public MemoryMemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // Optional - 널처리 방식, 널을 Optional 로 감싸서 반환함
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable((Member)store.get(id));
    }

    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter((member) -> member.getName().equals(name))
                .findAny();
    }

    public List<Member> findAll() {
        return new ArrayList(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
