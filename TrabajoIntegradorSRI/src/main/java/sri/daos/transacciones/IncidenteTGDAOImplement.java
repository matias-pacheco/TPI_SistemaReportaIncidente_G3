/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.transacciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import sri.daos.consultas.IncidenteCGDAOImplement;
import sri.daos.factories.ConsultaGDAOFactory;
import sri.entidades.Cliente;
import sri.entidades.Incidente;
import sri.entidades.Problema;
import sri.entidades.Servicio;
import sri.entidades.Tecnico;

/**
 *
 * @author Matías Pacheco
 */
public class IncidenteTGDAOImplement implements TransaccionGenericaDAO<Incidente, Integer>{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
    private IncidenteCGDAOImplement incConsultaGDAOI;
    
    public IncidenteTGDAOImplement(){
        this.incConsultaGDAOI = ConsultaGDAOFactory.getIncidenteCGDAOI();
    }
    
    private EntityManager obtenerEntitymanagerConfigurado(){
        EntityManager em = emf.createEntityManager();
        incConsultaGDAOI.setEntityManager(em);
        return em;
    }

    @Override
    public void create(Incidente model) {
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        incConsultaGDAOI.create(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Incidente read(Integer idModel) {
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        Incidente incidente = incConsultaGDAOI.read(idModel);
        em.getTransaction().commit();
        em.close();
        return incidente;
    }

    @Override
    public void update(Incidente model) {
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        incConsultaGDAOI.update(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Integer idModel) {
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        Incidente incidente = incConsultaGDAOI.read(idModel);
        incConsultaGDAOI.delete(incidente);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Incidente> readRecords() {
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        List<Incidente> registro = incConsultaGDAOI.readRecords();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public Tecnico readTecnico(int idIncidente){
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        Tecnico tecnico = incConsultaGDAOI.readTecnico(idIncidente);
        em.getTransaction().commit();
        em.close();
        return tecnico;
    }
    
    public Problema readProblema(int idIncidente){
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        Problema problema = incConsultaGDAOI.readProblema(idIncidente);
        em.getTransaction().commit();
        em.close();
        return problema;
    }
    
    public Servicio readServicio(int idIncidente){
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        Servicio servicio = incConsultaGDAOI.readServicio(idIncidente);
        em.getTransaction().commit();
        em.close();
        return servicio;
    }
    
    public Cliente readCliente(int idIncidente){
        EntityManager em = obtenerEntitymanagerConfigurado();
        em.getTransaction().begin();
        Cliente cliente = incConsultaGDAOI.readCliente(idIncidente);
        em.getTransaction().commit();
        em.close();
        return cliente;
    }
}
