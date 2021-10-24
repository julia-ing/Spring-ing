package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * DI 종류
 *
 * 1. 필드 주입 - 별로 안좋음. 중간에 바꿀 수가 없음
 *     @Autowired private MemberService memberService;
 * 2. setter 주입 - public 이어야 하기 때문에 노출될 수 있음
 *     @Autowired
 *     public void setMemberService(MemberService memberService) {
 *         this.memberService = memberService;
 *     }
 * 3. 생성자 주입 - 현재 방식, 권장
 *
 * 실무에서는!!
 * 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔 사용
 * 정형화 되지 않거나 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록
 */

@Controller // 스프링 빈 관리, 이 애노테이션을 보고 스프링이 컨트롤러를 인식
public class MemberController {
    private final MemberService memberService;

    // 생성자에 @Autowired 를 사용하면 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입
    @Autowired // 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping({"/members/new"})
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping({"/members/new"})
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        this.memberService.join(member);
        return "redirect:/";
    }

    @GetMapping({"/members"})
    public String list(Model model) {
        List<Member> members = this.memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
