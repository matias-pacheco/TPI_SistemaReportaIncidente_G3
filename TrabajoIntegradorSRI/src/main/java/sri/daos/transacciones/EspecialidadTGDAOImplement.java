/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.transacciones;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sri.entidades.Especialidad;
import sri.entidades.Tecnico;
import sri.daos.factories.ConsultaGDAOFactory;
import sri.daos.consultas.ConsultaGenericaDAO;
import sri.daos.consultas.EspecialidadCGDAOImplement;
import sri.entidades.Problema;

/**
 *
 * @author Matías Pacheco
 */
public class EspecialidadTGDAOImplement implements TransaccionGenericaDAO<Especialidad, Integer> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
    private EspecialidadCGDAOImplement espConsultaGDAOI;
//    private TecnicoDAO tecnicoDAO;
    
    public EspecialidadTGDAOImplement(){
        this.espConsultaGDAOI = ConsultaGDAOFactory.getEspecialidadCGDAOI();
//        this.tecnicoDAO = ConsultaGDAOFactory.getTecnicoCGDAOI();
    }
    
    private EntityManager obtenerEntityManagerConfigurado(){
        EntityManager em = emf.createEntityManager();
        espConsultaGDAOI.setEntityManager(em);
//        tecnicoDAO.setEntityManager(em);
        return em;
    }

    @Override
    public void create(Especialidad model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        espConsultaGDAOI.create(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Especialidad read(Integer idmodel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Especialidad especialidad = espConsultaGDAOI.read(idmodel);
        em.getTransaction().commit();
        em.close();
        return especialidad;
    }

    @Override
    public void update(Especialidad model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        espConsultaGDAOI.update(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Especialidad especialidad = espConsultaGDAOI.read(idModel);
        espConsultaGDAOI.delete(especialidad);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Especialidad> readRecords() {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Especialidad> registro = espConsultaGDAOI.readRecords();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicos(int idEspecialidad){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = espConsultaGDAOI.readTecnicos(idEspecialidad);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Problema> readProblemas(int idEspecialidad){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Problema> registro = espConsultaGDAOI.readProblemas(idEspecialidad);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
}
