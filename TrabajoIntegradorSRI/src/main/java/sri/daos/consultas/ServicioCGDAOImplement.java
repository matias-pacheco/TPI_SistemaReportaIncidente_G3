/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import sri.entidades.Cliente;
import sri.entidades.Problema;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ServicioCGDAOImplement implements ConsultaGenericaDAO<Servicio, Integer>{
    private EntityManager em;
    
    @Override
    public void create(Servicio model) {
        em.persist(model);
    }

    @Override
    public Servicio read(Integer idModel) {
        return em.find(Servicio.class, idModel);
    }

    @Override
    public void update(Servicio model) {
        em.merge(model);
    }

    @Override
    public void delete(Servicio model) {
        em.remove(model);
    }

    @Override
    public List<Servicio> readRecords() {
        TypedQuery<Servicio> consulta = em.createQuery("SELECT s FROM Servicio s", Servicio.class);
        return consulta.getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<Problema> readProblemas(int idServicio){
        TypedQuery<Problema> consulta = em.createQuery("SELECT p FROM Problema p JOIN p.servicios s WHERE s.id = :idServicio",
                Problema.class);
        consulta.setParameter("idServicio", idServicio);
        return consulta.getResultList();
    }
    
    public List<Cliente> readClientesQueReportaronIncidentesPorServicio(int idServicio){
        TypedQuery<Cliente> consulta = em.createQuery("SELECT c FROM Cliente c JOIN c.csi csi JOIN csi.servicio s "
                + "WHERE s.id = :idSevicio", Cliente.class);
        consulta.setParameter(idServicio, idServicio);
        return consulta.getResultList();
    }
    
    public List<Servicio> readServiciosQueReportaronIncidentePorCliente(int idCliente){
        TypedQuery<Servicio> consulta = em.createQuery("SELECT s FROM Servicio s JOIN s.csi csi JOIN csi.cliente c "
                + "WHERE c.id = :idCliente", Servicio.class);
        consulta.setParameter("idCliente", idCliente);
        return consulta.getResultList();
    }
}
