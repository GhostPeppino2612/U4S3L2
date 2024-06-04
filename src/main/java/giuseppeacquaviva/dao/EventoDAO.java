package giuseppeacquaviva.dao;

import giuseppeacquaviva.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'Evento " + evento.getTitolo() + " è stato correttamente salvato nel db!");
    }
   public Evento getById(long id) {
        Evento evento = em.find(Evento.class, id);
        return evento;
   }

    public void delete(long id) {
        Evento found = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'Evento " + found.getTitolo() + " è stato correttamente eliminato dal db!");

    }
}
