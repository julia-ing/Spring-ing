package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
