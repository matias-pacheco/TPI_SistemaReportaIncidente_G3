/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import sri.entidades.intermedias.Cliente_Servicio_Incidente;

/**
 *
 * @author Matías Pacheco
 */
public class CSICGDAOImplement implements ConsultaGenericaDAO<Cliente_Servicio_Incidente, Integer>{
    private EntityManager em;
    
    @Override
    public void create(Cliente_Servicio_Incidente model) {
        em.persist(model);
    }

    @Override
    public Cliente_Servicio_Incidente read(Integer idModel) {
        return em.find(Cliente_Servicio_Incidente.class, idModel);
    }

    @Override
    public void update(Cliente_Servicio_Incidente model) {
        em.merge(model);
    }

    @Override
    public void delete(Cliente_Servicio_Incidente model) {
        em.remove(model);
    }

    @Override
    public List<Cliente_Servicio_Incidente> readRecords() {
        TypedQuery<Cliente_Servicio_Incidente> consulta = em.createQuery("SELECT csi FROM Cliente_Servicio_Incidente csi", 
                Cliente_Servicio_Incidente.class);
        return consulta.getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
