package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//테스트 코드 생성 단축키 - command shift t

/**
 * 1. 컴포넌트 스캔과 자동 의존관계 설정
 *      "@Component" 애노테이션이 있으면 스프링 빈으로 자동 등록됨, hello.hellospring 패키지 하위 것들을 스캔
 *      "@Service, @Controller" 애노테이션 사용
 * 2. 자바 코드로 직접 스프링 빈 등록하기
 */
// @Service

@Transactional  // jpa 사용 시 항상 transaction 있어야 함
public class MemberService {
    private final MemberRepository memberRepository;

    // dependency injection(DI) - 의존관계 주입
    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {
        //중복 회원 검증
        /**
        long start = System.currentTimeMillis();
        try {
            validateDuplicateMember(member);  // 핵심 관심 사항
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();  // 공통 관심 사항
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");  // AOP 를 안쓰면 이렇게 모든 메서드에 코드 넣어줘야 함
            // 시간을 측정하는 로직과 핵심 비즈니스의 로직이 섞여서 유지보수가 어려움 -> AOP 등장
       }
       */
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return this.memberRepository.findById(memberId);
    }
}
