import config.MyPersistenceUnitInfo;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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

        // persistance 작업
        // class - table
        // Product - product
        Product product = new Product();
        product.setId(2L);
        product.setName("Book");

        em.persist(product);    // 영속화( 이 시점에 insert 되지 않는다)
        em.getTransaction().commit();
        em.close();
    }
}
