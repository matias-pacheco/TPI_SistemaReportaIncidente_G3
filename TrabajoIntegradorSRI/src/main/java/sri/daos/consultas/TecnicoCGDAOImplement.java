/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.Tecnico;
import sri.entidades.enumerados.IncidenteEstado;

/**
 *
 * @author Matías Pacheco
 */
public class TecnicoCGDAOImplement implements ConsultaGenericaDAO<Tecnico, Integer> {
    private EntityManager em;

    @Override
    public void create(Tecnico model) {
        em.persist(model);
    }

    @Override
    public Tecnico read(Integer idModel) {
        return em.find(Tecnico.class, idModel);
    }

    @Override
    public void update(Tecnico model) {
        em.merge(model);
    }

    @Override
    public void delete(Tecnico model) {
        em.remove(model);
    }

    @Override
    public List<Tecnico> readRecords() {
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t", Tecnico.class);
        return consulta.getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<Especialidad> readEspecialidades(int idTecnico){
        TypedQuery<Especialidad> consulta = em.createQuery("SELECT e FROM Especialidad e JOIN e.tecnicos t WHERE t.id = :idTecnico", 
                Especialidad.class);
        consulta.setParameter("idTecnico", idTecnico);
        return consulta.getResultList();
    }
    
    public List<Incidente> readIncidentes(int idTecnico){
        TypedQuery<Incidente> consulta = em.createQuery("SELECT i FROM Incidente i JOIN i.tecnico t WHERE t.id = :idTecnico", 
                Incidente.class);
        consulta.setParameter("idTecnico", idTecnico);
        return consulta.getResultList();
    }
    
    public Tecnico readTecnicoConMasIncidentesResueltoEnNDias(int nDias){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes i WHERE i.resolucion <= CURRENT_DATE "
                + "AND i.resolucion >= CURRENT_DATE - :dias AND (i.estado = :estadoRes OR i.estado = :estadoCer)", 
                Tecnico.class);
        consulta.setParameter("dias", nDias);
        consulta.setParameter("estadoRes", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoCer", IncidenteEstado.CERRADO);
        return consulta.getSingleResult();
    }
}
