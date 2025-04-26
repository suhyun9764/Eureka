import config.MyPersistenceUnitInfo;
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
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update");
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();   // 이 시점에 테이블에 반영된다.
        em.close();
    }
}
