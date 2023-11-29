/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.Problema;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ProblemaCGDAOImplement implements ConsultaGenericaDAO<Problema, Integer>{
    private EntityManager em;
    
    @Override
    public void create(Problema model) {
        em.persist(model);
    }

    @Override
    public Problema read(Integer idModel) {
        return em.find(Problema.class, idModel);
    }

    @Override
    public void update(Problema model) {
        em.merge(model);
    }

    @Override
    public void delete(Problema model) {
        em.remove(model);
    }

    @Override
    public List<Problema> readRecords() {
        TypedQuery<Problema> consulta = em.createQuery("SELECT p FROM Problema p", Problema.class);
        return consulta.getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<Especialidad> readEspecialidades(int idProblema){
        TypedQuery<Especialidad> consulta = em.createQuery("SELECT e FROM Especialidad e JOIN e.problemas p WHERE p.id = :idProblema", 
                Especialidad.class);
        consulta.setParameter("idProblema", idProblema);
        return consulta.getResultList();
    }
    
    public List<Servicio> readServicios(int idProblema){
        TypedQuery<Servicio> consulta = em.createQuery("SELECT s FROM Servicio s JOIN s.problemas p WHERE p.id = :idProblema", 
                Servicio.class);
        consulta.setParameter("idProblema", idProblema);
        return consulta.getResultList();
    }
    
    public List<Incidente> readIncidentes(int idProblema){
        TypedQuery<Incidente> consulta = em.createQuery("SELECT i FROM Incidente i JOIN i.problema p WHERE p.id = :idProblema", 
                Incidente.class);
        consulta.setParameter("idProblema", idProblema);
        return consulta.getResultList();
    }
}
