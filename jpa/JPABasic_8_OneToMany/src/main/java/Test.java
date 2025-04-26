import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @OneToMany
// 1. 테이블이 3개, 엔티티 각각 1개씩, 연과관계를 표현하는 테이블 1개
// 2. ManyToOne은 One이 Owing Entity이므로  Many를 표현하는 테이블에 One에 해당하는 컬럼 추가
// 3.
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
        p.setTitle("게시글 1");
        p.setContent("게시글 1 내용");

        Comment c1 = new Comment();
        c1.setContent("코멘트 1 내용");

        Comment c2 = new Comment();
        c2.setContent("코멘트 2 내용");

        // #1 Post 1건만 persist
//        em.persist(p);

        // #2 Comment 2건만 persist
//        em.persist(c1);
//        em.persist(c2);


        // #3 연결 없이,Post 1건 comment 2건
//        em.persist(p);
//        em.persist(c1);
//        em.persist(c2);

        // #4 Post에 comment를 연결, post 1건만 persist
//        p.setComments(List.of(c1,c2));
//        em.persist(p);
//        em.persist(c1);
//        em.persist(c2);

        // #5 Post에 comment를 연결, post , comment 다 영속화
//        p.setComments(List.of(c1,c2));
//        em.persist(p);
//        em.persist(c1);
//        em.persist(c2);

        // #6 Post에 comment를 연결, post , comment 다 영속화
        // cascade.perst를 OneToMany에 추가
        p.setComments(List.of(c1,c2));
        em.persist(p);


        em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.


        em.close();
    }

}