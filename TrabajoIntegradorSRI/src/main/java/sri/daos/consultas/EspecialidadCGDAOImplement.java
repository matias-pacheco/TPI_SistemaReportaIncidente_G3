/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sri.entidades.Especialidad;
import sri.entidades.Problema;
import sri.entidades.Tecnico;

/**
 *
 * @author Matías Pacheco
 */
public class EspecialidadCGDAOImplement implements ConsultaGenericaDAO<Especialidad, Integer> {
    private EntityManager em;

    @Override
    public void create(Especialidad model) {
        em.persist(model);
    }

    @Override
    public Especialidad read(Integer idModel) {
        return em.find(Especialidad.class, idModel);
    }

    @Override
    public void update(Especialidad model) {
        em.merge(model);
    }

    @Override
    public void delete(Especialidad model) {
        em.remove(model);
    }

    @Override
    public List<Especialidad> readRecords() {
        TypedQuery<Especialidad> consulta = em.createQuery("SELECT e FROM Especialidad e", Especialidad.class);
        return consulta.getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<Tecnico> readTecnicos(int idEspecialidad){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.especialidades e WHERE e.id = :idEspecialidad", 
                Tecnico.class);
        consulta.setParameter("idEspecialidad", idEspecialidad);
        return consulta.getResultList();
    }
    
    public List<Problema> readProblemas(int idEspecialidad){
        TypedQuery<Problema> consulta = em.createQuery("SELECT p FROM Problema p JOIN p.especialidades e WHERE e.id = :idEspecialidad",
                Problema.class);
        consulta.setParameter("idEspecialidad", idEspecialidad);
        return consulta.getResultList();
    }
}
