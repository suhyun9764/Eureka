import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// N+1
/* 어떤 entity A가 연관관계를 가진 상태 entity B에 대해 FetchType이 lazy일 때,
A의 목록을 가져오는 경우, B는 가져오지 않는다.
A의 목록을 가져와서 각각의 A에 대해 연관관계에 있는 B를 사용하면 B를 가져오게 된다.
이 때 A의 목록에 포함된 A의 수만큼 B를 가져오는 select가 수행된다.
결국 이과정에서 A목록 가져오는 select 1회, A목록 수 (N) 만큼 B를 select N회 수행 => N+1;

// 유사품 주의!!
// Eage->Lazy, Lazy ->eage ... (x)
 */
public class Test {


    public static void main(String[] args) {

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update"); // create : drop & create,  update : 있으면 안 건드리고 없으면 만든다.


        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        // #1 N+1 확인
//        String jpql = "select p from Post p";
//        List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post 목록
//// Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0
//
//        postList.forEach(post -> post.getComments().size());
        // 3건에 대한 쿼리 발생
        //Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
        //Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
        //Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?

//        // #2 해결 시도 : Post의 Comment에 대한 연관관계 FetchType.EAGER
//        // 여전히 N+1 문제 발생
//        String jpql = "select p from Post p";
//        List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post 목록
//        // Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0
//
//        postList.forEach(post -> post.getComments().size());
        // 3건에 대한 쿼리 발생
        //Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
        //Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
        //Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?


        // #3 해결 시도 : Post의 Comment에 대한 연관관계 FetchType.EAGER
        // #2에 대한 결과를 가지고, find()와 비교, find() 형태의 목록을 가져오는 메서드 x
        // find() != jpql
//        em.find(Post.class,1);
//        em.find(Post.class,2);
//        em.find(Post.class,3);
//    //Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.post_id,c1_0.id,c1_0.content from Post p1_0 left join Comment c1_0 on p1_0.id=c1_0.post_id where p1_0.id=?
//    //Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.post_id,c1_0.id,c1_0.content from Post p1_0 left join Comment c1_0 on p1_0.id=c1_0.post_id where p1_0.id=?
//    //Hibernate: select p1_0.id,p1_0.content,p1_0.title,c1_0.post_id,c1_0.id,c1_0.content from Post p1_0 left join Comment c1_0 on p1_0.id=c1_0.post_id where p1_0.id=?


        // #4
        // Post 목록 대신 Pk로 조건을 줘서 select <= find()와 동일하게 EAGER로 가져오는지
        // 여전히 N+1 문제 발생
//        String jpql = "select p from Post p where p.id = 1";
//        List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post 목록
//        //Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 where p1_0.id=1
//        //Hibernate: select c1_0.post_id,c1_0.id,c1_0.content from Comment c1_0 where c1_0.post_id=?
//        postList.forEach(post -> post.getComments().size());

        // 중견 결론
        // #2, #3, #4의 테스트 결과
        // FetchType 을 LAZY -> EAGER로 해도 안됌

        // 최종 결론
        // Post목록을 가져와서 Post만 사용하려는 목적이라면 N+1문제 발생 x
        // Post목록을 가져와서 Post의 연관관계인 Comment를 사용하려면 미리 comment도 가져오는것이 N+1 문제 해결

        // #5
        // N+1에 대해 join fetch로 미리 가져와서 해결
        String jpql = "select p from Post p join fetch p.comments";
        List<Post> postList = em.createQuery(jpql, Post.class).getResultList();//Post 목록
        //Hibernate: select p1_0.id,p1_0.content,p1_0.title from Post p1_0 join Comment c1_0 on p1_0.id=c1_0.post_id
        //select p1_0.id,c1_0.post_id,c1_0.id,c1_0.content,p1_0.content,p1_0.title from Post p1_0 join Comment c1_0 on p1_0.id=c1_0.post_id
        postList.forEach(post -> post.getComments().size());
        em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

        em.close();
    }

}