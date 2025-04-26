import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// HashMap 옵션
// key 컬럼에 대한 다양한 방법이 있지만 , @GeneratedValue(strategy=GenerateType.IDENTITY) 기본으로 사용
// multi-key
// jpa 2가지 방법
public class Test {
    public static void main(String[] args) {
        // EntityManger <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml
        Map<String,String > props = new HashMap<>();
        props.put("hibernate.show_sql","true");
//        props.put("hibernate.hbm2ddl.auto","create");   // create : drop & create;
        props.put("hibernate.hbm2ddl.auto","create");   // update : 있으면 안 건드리고 없으면 만든다.
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setName("홍길동");
        employee.setAddress("서울 어디");

        Employee employee2 = new Employee();
        employee2.setName("홍길동2");
        employee2.setAddress("서울 어디2");
        em.persist(employee);
        em.persist(employee2);
        em.getTransaction().commit();
        em.close();
    }
}
