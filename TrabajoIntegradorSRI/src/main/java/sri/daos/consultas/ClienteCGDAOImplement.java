/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import sri.entidades.Cliente;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ClienteCGDAOImplement implements ConsultaGenericaDAO<Cliente, Integer>{
    private EntityManager em;
    
    @Override
    public void create(Cliente model) {
        em.persist(model);
    }

    @Override
    public Cliente read(Integer idModel) {
        return em.find(Cliente.class, idModel);
    }

    @Override
    public void update(Cliente model) {
        em.merge(model);
    }

    @Override
    public void delete(Cliente model) {
        em.remove(model);
    }

    @Override
    public List<Cliente> readRecords() {
        TypedQuery<Cliente> consulta = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return consulta.getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<Servicio> readServiciosQueReportaronIncidentesPorCliente(int idCliente){
        TypedQuery<Servicio> consulta = em.createQuery("SELECT s FROM Servicio s JOIN s.csi csi JOIN csi.cliente c "
                + "WHERE c.id = :idCliente", Servicio.class);
        consulta.setParameter("idCliente", idCliente);
        return consulta.getResultList();
    }
    
    public List<Cliente> readClientesQueReportaronIncidentesPorServicio(int idServicio){
        TypedQuery<Cliente> consulta = em.createQuery("SELECT c FROM Cliente c JOIN c.csi csi JOIN csi.servicio s "
                + "WHERE s.id = :idServicio", Cliente.class);
        consulta.setParameter("idServicio", idServicio);
        return consulta.getResultList();
    }
}
