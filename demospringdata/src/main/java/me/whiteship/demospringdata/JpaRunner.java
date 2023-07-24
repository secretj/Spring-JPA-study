package me.whiteship.demospringdata;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
  /*  @PersistenceContext
    EntityManager entityManager;*/
    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws  Exception{

        Post post = new Post();
        post.setTitle("Spring");

        Comment comment = new Comment();
        comment.setComment("Hello");

        postRepository.save(post);




        /* JPQL 쿼리 작성
        //Type을 지정해주고 쿼리를 짤 수 있음
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post As p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println); //Post 클래스에 toString 메소드를 만들어 놨기 때문에 주소값이 아닌 텍스트로 콘솔에 표출
*/

/*
  Native 쿼리 작성
        List<Post> posts= entityManager.createNativeQuery("Select * from Post", Post.class).getResultList();
        posts.forEach(System.out::println);

*/

/* Criteria 쿼리 작성
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root);

        List<Post> posts = entityManager.createQuery(query).getResultList();
        posts.forEach(System.out::println);
*/



/* 엔티티와 value 맵핑
        Account account = new Account();
        account.setUsername("whiteship");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);
*/

/*관계 맵핑
       Post post = new Post();
        post.setTitle("Spring Data JPA 어려워요");

        Comment comment = new Comment();
        comment.setComment("어려워요");
        post.addComment(comment);

        Comment comment1 =new Comment();
        comment1.setComment("진짜로 어려움");
        post.addComment(comment1);


        Session session = entityManager.unwrap(Session.class);
        session.save(post);
        session.save(account);
        session.save(study);
*/
    }

}