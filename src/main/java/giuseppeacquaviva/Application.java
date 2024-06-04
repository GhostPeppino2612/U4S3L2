package giuseppeacquaviva;

import giuseppeacquaviva.dao.EventoDAO;
import giuseppeacquaviva.entities.Evento;
import giuseppeacquaviva.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);
        System.out.println("Hello World!");

        String titolo = "Conferenza sulla Tecnologia";
        LocalDate dataEvento = LocalDate.of(2024, 6, 15); // Anno, Mese, Giorno
        String descrizione = "Una conferenza sulle ultime novità tecnologiche.";
        TipoEvento tipoEvento = TipoEvento.PUBBLICO;
        int numeroMassimoPartecipanti = 200;

        Evento evento = new Evento(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
       // sd.save(evento);
        Evento evento1 = sd.getById(1);
        System.out.println(evento1);
        em.close();
        emf.close();
    }
}
