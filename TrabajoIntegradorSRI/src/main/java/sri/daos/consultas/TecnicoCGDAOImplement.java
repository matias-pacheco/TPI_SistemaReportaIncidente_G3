/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.consultas;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.time.LocalDate;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.Tecnico;
import sri.entidades.enumerados.IncidenteEstado;
import sri.entidades.enumerados.NombreEspecialidad;

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
    
//    public Tecnico readTecnicoConMasIncidentesResueltoEnLosUltimosNDias(int nDias){
//        LocalDate fechaMenor = LocalDate.now().minusDays(nDias);
//        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes i WHERE i.resolucion <= CURRENT_DATE "
//                + "AND i.resolucion >= :fechaMenor AND (i.estado = :estadoRes OR i.estado = :estadoCer)", 
//                Tecnico.class);
////        consulta.setParameter("dias", nDias);
//        consulta.setParameter("fechaMenor", fechaMenor);
//        consulta.setParameter("estadoRes", IncidenteEstado.RESUELTO);
//        consulta.setParameter("estadoCer", IncidenteEstado.CERRADO);
//        return consulta.getSingleResult();
//    }
    
//        public Tecnico readTecnicoConMasIncidentesResueltoEnLosUltimosNDias(int nDias){
//        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes i WHERE i.resolucion <= CURRENT_DATE "
//                + "AND i.resolucion >= DATE_SUB(CURRENT_DATE, :dias, 'DAY') AND (i.estado = :estadoRes OR i.estado = :estadoCer)", 
//                Tecnico.class);
//        consulta.setParameter("dias", nDias);
//        consulta.setParameter("estadoRes", IncidenteEstado.RESUELTO);
//        consulta.setParameter("estadoCer", IncidenteEstado.CERRADO);
//        return consulta.getSingleResult();
//    }
    
    public Tecnico readTecnicoConMasIncidentes(){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE 1 IN("
                    + "SELECT COUNT(i.tecnico) FROM Incidente i GROUP BY i.tecnico"
                + ") GROUP BY t", Tecnico.class);
        consulta.setMaxResults(1);
        return consulta.getSingleResult();
    }
    
    //Consulta readTecnicoConMasIncidentes() (mejora el resultado de la consulta teniendo en cuenta la posibilidad de que
    //haya más de un tecnico con la misma cantidad, mayor, de incidentes).
    public List<Tecnico> readTecnicosConMasIncidentes(){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti GROUP BY t "
                + "HAVING COUNT(ti.tecnico) = ("
                    + "SELECT MAX(contador) FROM("
                        + "SELECT COUNT(i.tecnico) AS contador FROM Incidente i GROUP BY i.tecnico"
                    + ")"
                + ")", Tecnico.class);
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosConMasIncidentesResueltos(){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE ti.estado = :estadoA "
                + "OR ti.estado = :estadoB GROUP BY t HAVING COUNT(ti.tecnico) = ("
                    + "SELECT MAX(contador) FROM("
                        + "SELECT COUNT(i.tecnico) AS contador FROM Incidente i WHERE i.estado = :estadoA2 "
                        + "OR i.estado = :estadoB2 GROUP BY i.tecnico"
                    + ")"
                + ")", Tecnico.class);
        consulta.setParameter("estadoA", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoB", IncidenteEstado.CERRADO);
        consulta.setParameter("estadoA2", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoB2", IncidenteEstado.CERRADO);
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosConMasIncidentesResueltosEnLosUltimosNDias(int nDias){
        //Para restar Ndias a fecha en SQL:
        //DATE_SUB(CURRENT_DATE, INTERVAL Ndias DAY)
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE ti.estado "
                + "IN(:estadoA, :estadoB) AND ti.resolucion <= CURRENT_DATE "
                + "AND ti.resolucion >= :fechaMenor GROUP BY t HAVING COUNT(ti.tecnico) = ("
                    + "SELECT MAX(contador) FROM("
                        + "SELECT COUNT(i.tecnico) AS contador FROM Incidente i WHERE i.estado IN(:estadoA, :estadoB) "
                        + "AND i.resolucion <= CURRENT_DATE AND i.resolucion >= :fechaMenor GROUP BY i.tecnico"
                    + ")"
                + ")", Tecnico.class);
        consulta.setParameter("estadoA", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoB", IncidenteEstado.CERRADO);
        consulta.setParameter("fechaMenor", LocalDate.now().minusDays(nDias));
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosDeUnaDeterminadaEspecialidadConMasIncidentesResueltosEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        //Para restar Ndias a fecha en SQL:
        //DATE_SUB(CURRENT_DATE, INTERVAL Ndias DAY)
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti JOIN t.especialidades te "
                + "WHERE ti.estado IN(:estadoA, :estadoB) AND ti.resolucion <= CURRENT_DATE "
                + "AND ti.resolucion >= :fechaMenor AND te.nombre = :especialidad GROUP BY t HAVING COUNT(ti.tecnico) = ("
                    + "SELECT MAX(contador) FROM("
                        + "SELECT COUNT(i.tecnico) AS contador FROM Incidente i JOIN i.tecnico.especialidades ite "
                        + "WHERE i.estado IN(:estadoA, :estadoB) AND i.resolucion <= CURRENT_DATE "
                        + "AND i.resolucion >= :fechaMenor AND ite.nombre = :especialidad GROUP BY i.tecnico"
                    + ")"
                + ")", Tecnico.class);
        consulta.setParameter("estadoA", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoB", IncidenteEstado.CERRADO);
        consulta.setParameter("fechaMenor", LocalDate.now().minusDays(nDias));
        consulta.setParameter("especialidad", nombreEspecialidad);
        return consulta.getResultList();
    }
    
    public List<Incidente> readIncidentesResueltosMasRapido(){
        TypedQuery<Incidente> consulta = em.createQuery("SELECT i FROM Incidente i WHERE DATEDIFF(i.resolucion, i.ingreso) IN("
                    + "SELECT MIN(DATEDIFF(inc.resolucion, inc.ingreso)) FROM Incidente inc"
                + ")", Incidente.class);
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosDeIncidentesResueltosMasRapido(){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE "
                + "DATEDIFF(ti.resolucion, ti.ingreso) IN("
                    + "SELECT MIN(DATEDIFF(i.resolucion, i.ingreso)) FROM Incidente i"
                + ")", Tecnico.class);
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDias(int nDias){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE "
                + "DATEDIFF(ti.resolucion, ti.ingreso) IN("
                    + "SELECT MIN(DATEDIFF(i.resolucion, i.ingreso)) FROM Incidente i WHERE i.resolucion <= CURRENT_DATE "
                    + "AND i.resolucion >= :fechaMenor"
                + ") AND ti.resolucion <= CURRENT_DATE AND resolucion >= :fechaMenor", Tecnico.class);
        consulta.setParameter("fechaMenor", LocalDate.now().minusDays(nDias));
        return consulta.getResultList();
    }
    
    //DATEDIFF recupera la diferencia en dias de las fechas recibidas por parametro. La razón por la que la condición de
    //fechas solo esta puesta en la subconsulta, a diferencia de otras consultas, es que la menor diferencia (que es lo que
    //recupera la subconsulta) se va a encontrar en la consulta principal, es decir, la condición de fechas en la subconsulta 
    //no altera el valor recuperado (como lo hacen otras consultas) de una manera que sea irreconocible para la consulta
    //principal.
    public List<Tecnico> readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDiasV2(int nDias){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE "
                + "DATEDIFF(ti.resolucion, ti.ingreso) IN("
                    + "SELECT MIN(DATEDIFF(i.resolucion, i.ingreso)) FROM Incidente i WHERE i.resolucion <= CURRENT_DATE "
                    + "AND i.resolucion >= :fechaMenor"
                + ")", Tecnico.class);
        consulta.setParameter("fechaMenor", LocalDate.now().minusDays(nDias));
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosDeUnaDeterminadaEspecialidadConIncidentesResueltosMasRapidoEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti JOIN t.especialidades te "
                + "WHERE te.nombre = :especialidad AND DATEDIFF(ti.resolucion, ti.ingreso) IN("
                    + "SELECT MIN(DATEDIFF(i.resolucion, i.ingreso)) FROM Incidente i JOIN i.tecnico.especialidades ite "
                    + "WHERE i.resolucion <= CURRENT_DATE AND i.resolucion >= :fechaMenor AND ite.nombre = :especialidad"
                + ")", Tecnico.class);
        consulta.setParameter("fechaMenor", LocalDate.now().minusDays(nDias));
        consulta.setParameter("especialidad", nombreEspecialidad);
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosConPromedioDeIncidentesResueltosMasRapido(){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE ti.estado "
                + "IN(:estadoA, :estadoB) GROUP BY t HAVING SUM(DATEDIFF(ti.resolucion, ti.ingreso)) / COUNT(t) IN("
                    + "SELECT MIN(promedio) FROM("
                        + "SELECT SUM(DATEDIFF(i.resolucion, i.ingreso)) / COUNT(i.tecnico) AS promedio FROM Incidente i "
                        + "WHERE i.estado IN(:estadoA, :estadoB) GROUP BY i.tecnico"
                    + ")"
                + ")", Tecnico.class);
        consulta.setParameter("estadoA", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoB", IncidenteEstado.CERRADO);
        return consulta.getResultList();
    }
    
    public List<Tecnico> readTecnicosConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(int nDias){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti WHERE ti.estado "
                + "IN(:estadoA, :estadoB) AND ti.resolucion <= CURRENT_DATE AND ti.resolucion >= :fechaMenor "
                + "GROUP BY t HAVING SUM(DATEDIFF(ti.resolucion, ti.ingreso)) / COUNT(t) IN("
                    + "SELECT MIN(promedio) FROM("
                        + "SELECT SUM(DATEDIFF(i.resolucion, i.ingreso)) / COUNT(i.tecnico) AS promedio FROM Incidente i "
                        + "WHERE i.estado IN(:estadoA, :estadoB) AND i.resolucion <= CURRENT_DATE AND i.resolucion >= :fechaMenor "
                        + "GROUP BY i.tecnico"
                    + ")"
                + ")", Tecnico.class);
        consulta.setParameter("estadoA", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoB", IncidenteEstado.CERRADO);
        consulta.setParameter("fechaMenor", LocalDate.now().minusDays(nDias));
        return consulta.getResultList();
    }

    public List<Tecnico> readTecnicosDeUnaDeterminadaEspecialidadConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        TypedQuery<Tecnico> consulta = em.createQuery("SELECT t FROM Tecnico t JOIN t.incidentes ti JOIN t.especialidades te "
                + "WHERE ti.estado IN(:estadoA, :estadoB) AND ti.resolucion <= CURRENT_DATE AND ti.resolucion >= :fechaMenor "
                + "AND te.nombre = :especialidad GROUP BY t HAVING SUM(DATEDIFF(ti.resolucion, ti.ingreso)) / COUNT(t) IN("
                    + "SELECT MIN(promedio) FROM("
                        + "SELECT SUM(DATEDIFF(i.resolucion, i.ingreso)) / COUNT(i.tecnico) AS promedio FROM Incidente i "
                        + "JOIN i.tecnico.especialidades ite WHERE i.estado IN(:estadoA, :estadoB) AND i.resolucion <= "
                        + "CURRENT_DATE AND i.resolucion >= :fechaMenor AND ite.nombre = :especialidad GROUP BY i.tecnico"
                    + ")"
                + ")", Tecnico.class);
        consulta.setParameter("estadoA", IncidenteEstado.RESUELTO);
        consulta.setParameter("estadoB", IncidenteEstado.CERRADO);
        consulta.setParameter("fechaMenor", LocalDate.now().minusDays(nDias));
        consulta.setParameter("especialidad", nombreEspecialidad);
        return consulta.getResultList();
    }
}
