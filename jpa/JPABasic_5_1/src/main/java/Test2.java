import config.MyPersistenceUnitInfo;
import entity.Employee;
import entity.Product;
import entity.Student;
import entity.key.ProductKey;
import entity.key.StudentKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// HashMap 옵션
// key 컬럼에 대한 다양한 방법이 있지만 , @GeneratedValue(strategy=GenerateType.IDENTITY) 기본으로 사용
// multi-key
// jpa 2가지 방법
public class Test2 {
    public static void main(String[] args) {
        Map<String,String > props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");   // update : 있으면 안 건드리고 없으면 만든다.
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), props
        );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // @IdClass
//        {
//            Product p = new Product();
//            p.setCode("uplus");
//            p.setNumber(1);
//            p.setColor("blue");
//
//            em.persist(p);

//            ProductKey key =  new ProductKey();
//            key.setCode("uplus");
//            key.setNumber(1);
//            Product p = em.find(Product.class, key);
//            System.out.println(p);
//        }

        {
//            StudentKey key = new StudentKey();
//            key.setCode("uplus");
//            key.setNumber(1);
//
//            Student s = new Student();
//            s.setId(key);
//            s.setName("홍길동");
//
//            em.persist(s);

            StudentKey key = new StudentKey();
            key.setCode("uplus");
            key.setNumber(1);

            Student student = em.find(Student.class, key);
            System.out.println(student);

        }
        em.getTransaction().commit();
        em.close();
    }
}
