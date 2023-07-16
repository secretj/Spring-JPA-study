package me.whiteship.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws  Exception{
       /* Account account = new Account();
        account.setUsername("whiteship");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);*/

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
/*        session.save(account);
        session.save(study);*/
    }

}