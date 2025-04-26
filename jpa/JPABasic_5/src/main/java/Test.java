import config.MyPersistenceUnitInfo;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;

// JPQL
// SELECT 수행, insert X, update O, delete O
// transaction begin, commit 사용 안해도됌
public class Test {
    public static void main(String[] args) {
        // EntityManger <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new MyPersistenceUnitInfo(), new HashMap<>()
        );
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
        // #1. normal query
//        {
//            // SQL : "SELECT * FROM employee"
//            String jpql = "SELECT e FROM Employee e"; // Entity를 이용한 query
//            Query query = em.createQuery(jpql);
//            List<Employee> list = query.getResultList();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }
//
//            Employee employee = em.find(Employee.class, 3);
//            System.out.println(employee);
//        }

        // #2 typed query
//        {
//            // SQL : "SELECT * FROM employee"
//            String jpql = "SELECT e FROM Employee e"; // Entity를 이용한 query
//            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//            List<Employee> list = query.getResultList();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }
//        }

        // #3 named parameter
        {
            // SQL : "SELECT * FROM employee where id = 3"
            String jpql = "SELECT e FROM Employee e where id =:id"; // Entity를 이용한 query
            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
            query.setParameter("id",3);
            List<Employee> list = query.getResultList();

            for (Employee e : list) {
                System.out.println(e);
            }
        }

        // #4 positional parameter
//        {
//            // SQL : "SELECT * FROM employee where id = 3"
//            String jpql = "SELECT e FROM Employee e where id >=?1"; // Entity를 이용한 query
//            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//            query.setParameter(1,3);
//            List<Employee> list = query.getResultList();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }
//        }

//        // #5 Single result
//        {
//            // SQL : "SELECT * FROM employee where id = 3"
//            String jpql = "SELECT e FROM Employee e where id =?1"; // Entity를 이용한 query
//            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//            query.setParameter(1,3);
//            Employee employee = query.getSingleResult();
//            System.out.println(employee);
//        }

        // #6 like
        {
            // SQL : "SELECT * FROM employee where name like %길동%"
            String jpql = "SELECT e FROM Employee e where e.name like :searchWord"; // Entity를 이용한 query
            String searchWord = "%길동%";
            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
            query.setParameter("searchWord",searchWord);
            List<Employee> list = query.getResultList();

            for (Employee e : list) {
                System.out.println(e);
            }
        }


//        em.getTransaction().commit();   // 이 시점에 테이블 반영한다.
        em.close();

    }
}
