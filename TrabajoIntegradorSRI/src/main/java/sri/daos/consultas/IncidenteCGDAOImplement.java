/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import sri.entidades.Cliente;
import sri.entidades.Incidente;
import sri.entidades.Problema;
import sri.entidades.Servicio;
import sri.entidades.Tecnico;

/**
 *
 * @author Matías Pacheco
 */
public class IncidenteCGDAOImplement implements ConsultaGenericaDAO<Incidente, Integer>{
    private EntityManager em;
    
    @Override
    public void create(Incidente model) {
        em.persist(model);
    }

    @Override
    public Incidente read(Integer idModel) {
        return em.find(Incidente.class, idModel);
    }

    @Override
    public void update(Incidente model) {
        em.merge(model);
    }

    @Override
    public void delete(Incidente model) {
        em.remove(model);
    }

    @Override
    public List<Incidente> readRecords() {
        TypedQuery<Incidente> consulta = em.createQuery("SELECT i FROM Incidente i", Incidente.class);
        return consulta.getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public Tecnico readTecnico(int idIncidente){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes i "
                + "WHERE i.id = :idIncidente", Tecnico.class);
        consulta.setParameter("idIncidente", idIncidente);
        return consulta.getSingleResult();
    }
    
    public Problema readProblema(int idIncidente){
        TypedQuery<Problema> consulta = em.createQuery("SELECT p FROM Problema p JOIN p.incidentes i "
                + "WHERE i.id = :idIncidente", Problema.class);
        consulta.setParameter("idIncidente", idIncidente);
        return consulta.getSingleResult();
    }
    
    public Servicio readServicio(int idIncidente){
        TypedQuery<Servicio> consulta = em.createQuery("SELECT s FROM Servicio s JOIN s.csi csi JOIN csi.incidente i "
                + "WHERE i.id = :idIncidente", Servicio.class);
        consulta.setParameter("idIncidente", idIncidente);
        return consulta.getSingleResult();
    }
    
    public Cliente readCliente(int idIncidente){
        TypedQuery<Cliente> consulta = em.createQuery("SELECT c FROM Cliente c JOIN c.csi csi JOIN csi.incidente i "
                + "WHERE i.id = :idIncidente", Cliente.class);
        consulta.setParameter("idIncidente", idIncidente);
        return consulta.getSingleResult();
    }
}
