import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// HashMap 옵션
public class Test {
    public static void main(String[] args) {
        // EntityManger <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml
        Map<String,String > props = new HashMap<>();
        props.put("hibernate.show_sql","true");
//        props.put("hibernate.hbm2ddl.auto","create");   // create : drop & create;
        props.put("hibernate.hbm2ddl.auto","update");   // update : 있으면 안 건드리고 없으면 만든다.
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
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
//            em.persist(employee);    // 영속화( 이 시점에 insert 되지 않는다)
//        }

        // #2. find
        // 현재 테이블에 있는 데이터를 객체로 전환 (select) 영속화
//        {
//            Employee e  = em.find(Employee.class,2);
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
//            Employee e  = new Employee();
//            e.setId(2);
//            e.setName("이길동2");
//            e.setAddress("창원 어디");
//
//            em.merge(e);
        }

        // create, update 테스트후 데이터가 없다
        // #4.
//        {
//            Employee e = em.find(Employee.class,2);
//            em.remove(e);
//        }
//        try {
//            Thread.sleep(5000);
//        }catch (Exception ee){
//            ee.printStackTrace();
//        }

        // #1. persist
        // 현재 영속화 되어 있는 객체를 find()
        {
            Employee e = new Employee();
            e.setId(3);
            e.setName("삼길동");
            e.setAddress("제주 어디");

            em.persist(e);    // 영속화( 이 시점에 insert 되지 않는다)
            Employee e2 = em.find(Employee.class,3);
            System.out.println(e2);
        }
        em.getTransaction().commit();   // 이 시점에 테이블 반영한다.
        em.close();

    }
}
