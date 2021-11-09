package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 메모리가 아닌 실제 디비와 연결된 테스트 - 통합테스트
 */

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행
@Transactional // 테스트가 끝나면 데이터 롤백 - 디비에 반영 안되도록(데이터 일일이 지우는 작업 없이 다음 테스트를 계속 실행 가능하게끔)
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService; // 테스트 코드에서는 필요한 것을 injection 받고 끝이기 때문에 보통 필드 주입을 사용
    @Autowired MemberRepository memberRepository;

    @Test
    // @Commit // 디비에 반영
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}