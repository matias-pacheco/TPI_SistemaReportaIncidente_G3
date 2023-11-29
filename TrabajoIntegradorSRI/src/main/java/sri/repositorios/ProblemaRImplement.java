/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.repositorios;

import java.util.List;
import sri.daos.factories.TransaccionGDAOFactory;
import sri.daos.transacciones.ProblemaTGDAOImplement;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.Problema;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ProblemaRImplement implements RepositorioGenerico<Problema, Integer>{
    private ProblemaTGDAOImplement proTransaccionGDAOI;
    
    public ProblemaRImplement(){
        this.proTransaccionGDAOI = TransaccionGDAOFactory.getProblemaTGDAOI();
    }

    @Override
    public void add(Problema model) {
        proTransaccionGDAOI.create(model);
    }

    @Override
    public Problema get(Integer idModel) {
        return proTransaccionGDAOI.read(idModel);
    }

    @Override
    public void update(Problema model) {
        proTransaccionGDAOI.update(model);
    }

    @Override
    public void remove(Integer idModel) {
        proTransaccionGDAOI.delete(idModel);
    }

    @Override
    public List<Problema> getModels() {
        return proTransaccionGDAOI.readRecords();
    }
    
    public List<Especialidad> getEspecialidades(int idProblema){
        return proTransaccionGDAOI.readEspecialidades(idProblema);
    }
    
    public List<Servicio> getServicios(int idProblema){
        return proTransaccionGDAOI.readServicios(idProblema);
    }
    
    public List<Incidente> getIncidentes(int idProblema){
        return proTransaccionGDAOI.readIncidentes(idProblema);
    }
}
