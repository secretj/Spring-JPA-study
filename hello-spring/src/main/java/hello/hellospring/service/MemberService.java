package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
//CTRL+SHIFT+T 테스트작성 단축키
//@Service
@Transactional   //JPA는 모든 데이터의 변경이 Transactional안에서 실행되어야한다.
public class MemberService {

    private final MemberRepository memberRepository;
    //memberRepository는 전역적으로 같이 쓰는 객체기 때문에 새롭게 생성하지않고 기존에 생성된 memberRepository를 주입하여 사용한다.
    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     **/
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X -> CTRL+ALT+M하면 메소드로 따로 빼준다.(extract method 기능)
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

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
            return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
