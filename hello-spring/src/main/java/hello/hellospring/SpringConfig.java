package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    public SpringConfig() {
    }

    /**
     * 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때 기본으로 싱글톤으로 등록(유일하게 하나만 등록해서 공유)
     * 따라서 같은 스프링 빈이면 모두 같은 인스턴스임
     */
    @Bean
    public MemberService memberService() {
        return new MemberService(this.memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
