/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.transacciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import sri.daos.consultas.ServicioCGDAOImplement;
import sri.daos.factories.ConsultaGDAOFactory;
import sri.entidades.Cliente;
import sri.entidades.Problema;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ServicioTGDAOImplement implements TransaccionGenericaDAO<Servicio, Integer>{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
    private ServicioCGDAOImplement serConsultaGDAOI;
    
    public ServicioTGDAOImplement(){
        this.serConsultaGDAOI = ConsultaGDAOFactory.getServicioCGDAOI();
    }
    
    private EntityManager obtenerEntityManagerConfigurado(){
        EntityManager em = emf.createEntityManager();
        serConsultaGDAOI.setEntityManager(em);
        return em;
    }
    
    @Override
    public void create(Servicio model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        serConsultaGDAOI.create(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Servicio read(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Servicio servicio = serConsultaGDAOI.read(idModel);
        em.getTransaction().commit();
        em.close();
        return servicio;
    }

    @Override
    public void update(Servicio model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        serConsultaGDAOI.update(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Servicio servicio = serConsultaGDAOI.read(idModel);
        serConsultaGDAOI.delete(servicio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Servicio> readRecords() {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Servicio> registro = serConsultaGDAOI.readRecords();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Problema> readProblemas(int idServicio){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Problema> registro = serConsultaGDAOI.readProblemas(idServicio);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Cliente> readClientesQueReportaronIncidentesPorServicio(int idServicio){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Cliente> registro = serConsultaGDAOI.readClientesQueReportaronIncidentesPorServicio(idServicio);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Servicio> readServiciosQueReportaronIncidentesPorCliente(int idCliente){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Servicio> registro = serConsultaGDAOI.readServiciosQueReportaronIncidentePorCliente(idCliente);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
}
