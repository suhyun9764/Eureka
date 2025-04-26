import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Period;

public class Test {
    public static void main(String[] args) {
        // EntityManger <= EntityManagerFactory
        // src/main/resources/META-INF/persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // persistance 작업
        // class - table
        // Product - product
        Product product = new Product();
        product.setId(1L);
        product.setName("Phone");

        em.persist(product);    // 영속화( 이 시점에 insert 되지 않는다)
        em.getTransaction().commit();
        em.close();
    }
}
