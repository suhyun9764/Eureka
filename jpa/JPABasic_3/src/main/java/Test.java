import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // EntityManger <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), new HashMap<>()
        );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // #1. persist
        // 현재 테이블에 없는 객체를 생성한 후 객체의 내용을 테이블에 반영(insert)
//        {
//            Employee employee = new Employee();
//            employee.setId(2);
//            employee.setName("이길동");
//            employee.setAddress("서울 어디");
//
//
//
//            em.persist(employee);    // 영속화( 이 시점에 insert 되지 않는다)
//            employee.setAddress("경기 어디");
//        }

        // #2. find
        // 현재 테이블에 있는 데이터를 객체로 전환 (select) 영속화
//        {
//            Employee e  = em.find(Employee.class,1);
//            System.out.println(e);
//            e.setAddress("광주 어디");
//            System.out.println(e);
//        }

        // #3. merge
        // 현재 테이블에 없는 객체 생성한 경우면 insert, 이미 있는 객체이면 update
        {

            // 테이블에 없는 경(insert)
//            Employee e  = new Employee();
//            e.setId(3);
//            e.setName("삼길동");
//            e.setAddress("춘천 어디");
//
//            em.merge(e);
            Employee e  = new Employee();
            e.setId(1);
            e.setName("홍길동2");
            e.setAddress("창원 어디");

            em.merge(e);
        }
        em.getTransaction().commit();   // 이 시점에 테이블 반영한다.
        em.close();

    }
}
