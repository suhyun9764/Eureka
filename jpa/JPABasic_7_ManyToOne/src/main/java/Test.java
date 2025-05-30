import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// @OneToOne 연관관계를 통해 Person 테이블에 FK로 Passport가 설정된다.
public class Test {

    public static void main(String[] args) {

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create"); // create : drop & create,  update : 있으면 안 건드리고 없으면 만든다.


        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Post p = new Post();
        p.setTitle("제목 1");
        p.setContent("내용 1");

        Comment c1 = new Comment();
        c1.setContent("코멘트 1");

        Comment c2 = new Comment();
        c2.setContent("코멘트 2");

        // 1. 연결없이 Post 만
//		em.persist(p);
////		Hibernate: insert into Post (content,title) values (?,?)

        // 2. 연결없이 Comment 만
//		em.persist(c1);
//		Hibernate: insert into Comment (content,post_id) values (?,?)

        // 3. 연결하고 Post 만
//		c1.setPost(p);
//		c2.setPost(p);
//
//		em.persist(p);
//		Hibernate: insert into Post (content,title) values (?,?)

        // 4. 연결하고 Comment 만
//		c1.setPost(p);
//		c2.setPost(p);
//
//		em.persist(c1);
//		org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Post' (save the transient instance before flushing)

        // 5. 연결하고 Post, Comment 모두, c1 -> c2 -> p
//		c1.setPost(p);
//		c2.setPost(p);
//
//		em.persist(c1);
//		em.persist(c2);
//		em.persist(p);
//		Hibernate: insert into Comment (content,post_id) values (?,?)
//		Hibernate: insert into Comment (content,post_id) values (?,?)
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: update Comment set content=?,post_id=? where id=?
//		Hibernate: update Comment set content=?,post_id=? where id=?

        // 6. 연결하고 Post, Comment 모두, p ->  c1 -> c2
//		c1.setPost(p);
//		c2.setPost(p);
//
//		em.persist(p);
//		em.persist(c1);
//		em.persist(c2);
//		Hibernate: insert into Post (content,title) values (?,?)
//		Hibernate: insert into Comment (content,post_id) values (?,?)
//		Hibernate: insert into Comment (content,post_id) values (?,?)


        // 7. 연결하고 Comment 에 @ManyToOne(cascade=CascadeType.PERSIST) 추가
        // c1, c2 만 persist
        c1.setPost(p);
        c2.setPost(p);

        em.persist(c1);
        em.persist(c2);

        em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

        em.close();
    }

}