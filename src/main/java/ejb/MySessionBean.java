package ejb;

import entities.PersonEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@jakarta.ejb.Stateless(name = "MySessionBeanEJB")
public class MySessionBean {
    @PersistenceContext(unitName = "DAdemoPU")
    EntityManager em;

    public MySessionBean() {
    }

    /*
    public void problem1(int limit){
        int sum = 0;

        for (int x = 0; x < limit; x++){
            if (x%3 == 0 || x%5 == 0){
                sum += x;
            }
        }

        System.out.println(sum);
    }

     */
    public int doSomethingReallyDifficult(int a, int b ){
        return a+b;
    }
    public List<PersonEntity> findPersonByName(String name){

        Query query = em.createQuery("SELECT p from PersonEntity p WHERE p.name LIKE :searchname", PersonEntity.class);
        query.setParameter("searchname", "%" + name + "%");
        return query.getResultList();
    }

}
