import config.MyPersistenceUnitInfo;
import entity.Passport;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// @OneToOne 연관관계를 통해 Person 테이블에 FK로 Passport가 설정된다.
public class Test {
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
        Person person = new Person();
        person.setName("홍길동");

        Passport passport = new Passport();
        passport.setNumber("KOR124");
        // #1. 각각 따로 persist 하면 오류 없이 insert 된다.
//        em.persist(person);
        //Hibernate: insert into Person (name,passport) values (?,?)
        //passport는 null

//        em.persist(passport);
        //Hibernate: insert into Passport (number) values (?)

        // #2. 객체 연결
        // passport 영속화 되지 않은 상태 => 오류 발생

//        em.persist(person);

//        em.persist(passport);

        // 3. 객체 연결, person, passport persist
//        em.persist(passport);
//        person.setPassport(passport);
//        em.persist(person);
//        Person이 먼저 insert되는 과정에서 Passport의 id 값을 모르므로
        // Passport가 insert되는 과정에서 획득한 AI Key 값을 이용해 다시 한번 update수행

        // 5. 객체 연결, Person에 Cascade.Persist 추가
        person.setPassport(passport);
        em.persist(person);
        em.getTransaction().commit();   // 이 시점에 테이블에 반영된다.
        em.close();

    }
}
