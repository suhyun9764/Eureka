import config.MyPersistenceUnitInfo;
import entity.Passport;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// @OneToOne 연관관계를 통해 Person 테이블에 FK로 Passport가 설정된다.
public class Test2 {
    public static void main(String[] args) {
        // EntityManger <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml
        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","create");
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // #1. find Person
//        Person person = em.find(Person.class, 1);
//        // OneToOne의 기본 fetch option이 Eager(즉시 로딩) 이므로 연관관계에 있는 Passport도 join으로 함께 가지고 옴
//        // person 객체의 출력 코드에서 passport 객체를 사용하지만, 다시 select 수행 x
//        System.out.println(person);

        // #2. find Passport
//        Passport passport = em.find(Passport.class, 1);
//        em.getTransaction().commit();   // 이 시점에 테이블에 반영된다.
//        em.close();

        // #3. FetchType.Lazy
        Person person = em.find(Person.class, 1);
        System.out.println(person);
        em.getTransaction().commit();   // 이 시점에 테이블에 반영된다.
        em.close();
    }
}
