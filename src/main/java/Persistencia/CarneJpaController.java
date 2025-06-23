
package Persistencia;

import Logica.Carne;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jarav
 */
public class CarneJpaController implements Serializable {

    public CarneJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

        //Conector a base de datos, HACERLO SIEMPRE, conecta a la logica
    public CarneJpaController(){
    
        emf = Persistence.createEntityManagerFactory("AppCarnesProyectoFinal");
    }
    
    public void create(Carne carne) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carne);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carne carne) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carne = em.merge(carne);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = carne.getId();
                if (findCarne(id) == null) {
                    throw new NonexistentEntityException("The carne with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carne carne;
            try {
                carne = em.getReference(Carne.class, id);
                carne.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carne with id " + id + " no longer exists.", enfe);
            }
            em.remove(carne);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carne> findCarneEntities() {
        return findCarneEntities(true, -1, -1);
    }

    public List<Carne> findCarneEntities(int maxResults, int firstResult) {
        return findCarneEntities(false, maxResults, firstResult);
    }

    private List<Carne> findCarneEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carne.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Carne findCarne(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carne.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarneCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carne> rt = cq.from(Carne.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
