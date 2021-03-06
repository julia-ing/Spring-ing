package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 현재 아래 코드는 추상화에도 의존하고 구체화에도 의존함: DIP 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;

    @Autowired  // Bean 수동 등록이 아니라 ComponentScan을 쓰면 자동주입 필요
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // for test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
