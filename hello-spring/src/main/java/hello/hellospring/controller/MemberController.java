package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // Spring이 뜰 때, 이 객체를 생성하도록하는 어노테이션 -> 이를 스프링 컨테이너에서 빈이 관리된다 표현
public class MemberController {

    private final MemberService memberService;

    @Autowired  //스프링 컨테이너에서 매칭시켜주는 어노테이션 -> 의존관계 주입 DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
