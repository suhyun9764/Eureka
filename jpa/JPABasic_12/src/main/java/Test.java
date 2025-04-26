import config.MyPersistenceUnitInfo;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

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
        props.put("hibernate.hbm2ddl.auto", "update"); // create : drop & create,  update : 있으면 안 건드리고 없으면 만든다.


        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // 테이블 데이터 -> 객체화
        // JPQL 사용 안하고 em의 메서드 사용 <= 단 건만 select
//        Product p = em.find(Product.class,1);
//        System.out.println(p);

        // 테이블 데이터 -> 객체화(목록)은 Find()cjfl x => jpql
        // jpql은 select only
        // 표준 sql 과 비슷하지만, 객체 표현

        // #2. query
//        String jpql = "select p from Product p";
//        Query q = em.createQuery(jpql);
//        List<?> list = q.getResultList();
//        for (Object o : list) {
//            Product p = (Product)   o;
//            System.out.println(p);
//        }

        // #3. TypedQuery
//        String jpql = "select p from Product p";
//        TypedQuery<Product> q = em.createQuery(jpql,Product.class);
//        List<Product> list = q.getResultList();
//        for (Product o : list) {
//            Product p = o;
//            System.out.println(p);
//        }

        // 위 코드를 간략히 표현
//        em.createQuery(jpql, Product.class)
//                .getResultList()
//                .forEach(product -> System.out.println(product));

        // #4. 개별 필드 (id, name, price) <= Product 받을 수 없다 Object[]로 처리
//        String jpql = "select p.id, p.name, p.price from Product p";
//        em.createQuery(jpql, Object[].class)
//                .getResultList()
//                .forEach(objArray -> System.out.println(objArray[0] + ","+objArray[1]+","+objArray[2]));

        // #5. select + where
//        String jpql  = "select p from Product p where p.price > 2000";
//
//        em.createQuery(jpql, Product.class)
//                .getResultList()
//                .forEach(product -> System.out.println(product));

        // #6. select + where + and + param
//        String jpql  = "select p from Product p where p.price > :price and p.quantity>:quantity";
//
//        em.createQuery(jpql, Product.class)
//                .setParameter("price",2000)
//                .setParameter("quantity",20)
//                .getResultList()
//                .forEach(product -> System.out.println(product));

        // #7. select + where + and +param + using index
//        String jpql  = "select p from Product p where p.price > ?1 and p.quantity>?2";
//
//        em.createQuery(jpql, Product.class)
//                .setParameter(1,2000)
//                .setParameter(2,20)
//                .getResultList()
//                .forEach(product -> System.out.println(product));


//        // #8 select + where + and +param + like
//        String jpql  = "select p from Product p where p.price > :price and p.country like : country";
//
//        em.createQuery(jpql, Product.class)
//                .setParameter("price",2000)
//                .setParameter("country","%ko%")
//                .getResultList()
//                .forEach(product -> System.out.println(product));

        // #9. select + aggregation function count()
        // aggregation function은 1개의 row 리턴 getResultList (복수개) 대신 getSingleResult(단수) 사용
//        String jpql = "select count(p) from Product p";
//
//        Long cnt = em.createQuery(jpql, Long.class)
//                .getSingleResult();
//
//        System.out.println(cnt);

        // #10 select + aggregation function avg() (실수형)
        // aggregation function은 1개의 row 리턴 getResultList (복수개) 대신 getSingleResult(단수) 사용
//        String jpql = "select avg(p.price) from Product p";
//
//        double cnt = em.createQuery(jpql, double.class)
//                .getSingleResult();
//
//        System.out.println(cnt);

        // #11 select + aggregation function sum(), min(), max() 한번에
        // aggregation function은 1개의 row 리턴 getResultList (복수개) 대신 getSingleResult(단수) 사용
//        String jpql = "select sum(p.quantity), min(p.quantity), max(p.quantity) from Product p";
//
//        Object[] objArray = em.createQuery(jpql, Object[].class)
//                .getSingleResult();
//
//        System.out.println(objArray[0]+", "+objArray[1]+", "+objArray[2]);
//        em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

        // #12 select + aggregation function sum(), min(), max() 한번에
        // aggregation function은 1개의 row 리턴 getResultList (복수개) 대신 getSingleResult(단수) 사용
        String jpql = "select p.country, sum(p.quantity), min(p.quantity), max(p.quantity) from Product p group by p.country";

        List<Object[]> objArrayList = em.createQuery(jpql, Object[].class)
                .getResultList();

        objArrayList.forEach(
                objArray->{
                    System.out.println(objArray[0]+", "+objArray[1]+", "+objArray[2]+", "+objArray[3]);
                }
        );

        em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

        em.close();
    }

}