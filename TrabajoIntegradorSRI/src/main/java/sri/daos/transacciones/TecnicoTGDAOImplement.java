/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.transacciones;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sri.entidades.Tecnico;
import sri.daos.factories.ConsultaGDAOFactory;
import sri.daos.consultas.TecnicoCGDAOImplement;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.enumerados.NombreEspecialidad;

/**
 *
 * @author Matías Pacheco
 */
public class TecnicoTGDAOImplement implements TransaccionGenericaDAO<Tecnico, Integer> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
    private TecnicoCGDAOImplement tecConsultaGDAOI;
//    private EspecialidadDAO especialidadDAO;
    
    public TecnicoTGDAOImplement(){
        this.tecConsultaGDAOI = ConsultaGDAOFactory.getTecnicoCGDAOI();
//        this.especialidadDAO = ConsultaGDAOFactory.getEspecialidadCGDAOI();
    }
    
    private EntityManager obtenerEntityManagerConfigurado(){
        EntityManager em = emf.createEntityManager();
        tecConsultaGDAOI.setEntityManager(em);
//        especialidadDAO.setEntityManager(em);
        return em;
    }

    @Override
    public void create(Tecnico model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        tecConsultaGDAOI.create(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Tecnico read(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Tecnico tecnico = tecConsultaGDAOI.read(idModel);
        em.getTransaction().commit();
        em.close();
        return tecnico;
    }

    @Override
    public void update(Tecnico model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        tecConsultaGDAOI.update(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Tecnico tecnico = tecConsultaGDAOI.read(idModel);
        tecConsultaGDAOI.delete(tecnico);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Tecnico> readRecords() {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readRecords();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Especialidad> readEspecialidades(int idTecnico){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
//        TecnicoCGDAOImplement tec = new TecnicoCGDAOImplement();
//        tec.setEntityManager(em);
        List<Especialidad> registro = tecConsultaGDAOI.readEspecialidades(idTecnico);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Incidente> readIncidentes(int idTecnico){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Incidente> registro = tecConsultaGDAOI.readIncidentes(idTecnico);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public Tecnico readTecnicoConMásIncidentes(){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Tecnico tecnico = tecConsultaGDAOI.readTecnicoConMasIncidentes();
        em.getTransaction().commit();
        em.close();
        return tecnico;
    }
    
    public List<Tecnico> readTecnicosConMásIncidentes(){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosConMasIncidentes();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosConMásIncidentesResueltos(){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosConMasIncidentesResueltos();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosConMásIncidentesResueltosEnLosUltimosNDias(int nDias){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosConMasIncidentesResueltosEnLosUltimosNDias(nDias);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosDeUnaDeterminadaEspecialidadConMásIncidentesResueltosEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosDeUnaDeterminadaEspecialidadConMasIncidentesResueltosEnLosUltimosNDias(
                nombreEspecialidad, nDias);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Incidente> readIncidentesResueltosMasRapido(){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Incidente> registro = tecConsultaGDAOI.readIncidentesResueltosMasRapido();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosDeIncidentesResueltosMasRapido(){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosDeIncidentesResueltosMasRapido();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDias(int nDias){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDias(nDias);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDiasV2(int nDias){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDiasV2(nDias);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosDeUnaDeterminadaEspecialidadConIncidentesResueltosMasRapidoEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosDeUnaDeterminadaEspecialidadConIncidentesResueltosMasRapidoEnLosUltimosNDias(
                nombreEspecialidad, nDias);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosConPromedioDeIncidentesResueltosMasRapido(){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosConPromedioDeIncidentesResueltosMasRapido();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(int nDias){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(nDias);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Tecnico> readTecnicosDeUnaDeterminadaEspecialidadConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Tecnico> registro = tecConsultaGDAOI.readTecnicosDeUnaDeterminadaEspecialidadConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(
                nombreEspecialidad, nDias);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
}
