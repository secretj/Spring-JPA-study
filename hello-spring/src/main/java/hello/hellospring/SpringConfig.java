package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;

/**
 * 수동으로 Bean등록을 하기위한 Config 클래스
 */
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /*private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    /*private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

  /*  *//**AOP 스프링 bean 등록
    (컴포넌트 스캔을 통해 사용해도되지만 AOP는 이런 AOP가 있다는 것을 다른 개발자가 알기쉽도록 등록해서 쓰는게 좋다.) **//*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/


 /* SpringDataJpaMemberRepository에서 구현체를 생성해줬으므로 얘는 더이상 필요가 없다.
    @Bean
    public MemberRepository memberRepository(){
       // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    }*/
}
