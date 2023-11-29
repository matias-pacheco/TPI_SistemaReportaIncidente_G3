/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.transacciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import sri.daos.consultas.ProblemaCGDAOImplement;
import sri.daos.factories.ConsultaGDAOFactory;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.Problema;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ProblemaTGDAOImplement implements TransaccionGenericaDAO<Problema, Integer>{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
    private ProblemaCGDAOImplement proConsultaGDAOI;
    
    public ProblemaTGDAOImplement(){
        this.proConsultaGDAOI = ConsultaGDAOFactory.getProblemaCGDAOI();
    }
    
    private EntityManager obtenerEntityManagerConfigurado(){
        EntityManager em = emf.createEntityManager();
        proConsultaGDAOI.setEntityManager(em);
        return em;
    }
    
    @Override
    public void create(Problema model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        proConsultaGDAOI.create(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Problema read(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Problema problema = proConsultaGDAOI.read(idModel);
        em.getTransaction().commit();
        em.close();
        return problema;
    }

    @Override
    public void update(Problema model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        proConsultaGDAOI.update(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Problema problema = proConsultaGDAOI.read(idModel);
        proConsultaGDAOI.delete(problema);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Problema> readRecords() {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Problema> registro = proConsultaGDAOI.readRecords();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Especialidad> readEspecialidades(int idProblema){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Especialidad> registro = proConsultaGDAOI.readEspecialidades(idProblema);
        em.getTransaction().begin();
        em.close();
        return registro;
    }
    
    public List<Servicio> readServicios(int idProblema){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Servicio> registro = proConsultaGDAOI.readServicios(idProblema);
        em.getTransaction().begin();
        em.close();
        return registro;
    }
    
    public List<Incidente> readIncidentes(int idProblema){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Incidente> registro = proConsultaGDAOI.readIncidentes(idProblema);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
}
