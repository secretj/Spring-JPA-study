package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스에 JpaRepository를 상속받으면 구현체를 JPA가 스스로 만들어내고 BEAN에 등록해둔다.
//-> 그래서 MemberRepository를 따로 등록하지않아도 SpringConfig에서 꺼내쓰는걸 볼 수 있음
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //save나 findById같이 우리가 만들었던 메소드들을 전부 JpaRepository에서 똑같이 제공하기때문에 findByName만 구성해놓은 모습
    @Override
    Optional<Member> findByName(String name);
}