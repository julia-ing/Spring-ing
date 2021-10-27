package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 스프링의 DI를 사용하면 기존 코드를 전혀 손대지 않고 설정만으로 구현 클래스 변경 가능
 * 객체지향의 장점 - 기존 코드를 변경하지 않으면서도 인터페이스 구현체를 바꿀 수 있는 것!
 */

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
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
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
