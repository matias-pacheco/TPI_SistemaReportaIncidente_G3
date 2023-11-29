/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.repositorios;

import java.util.List;
import sri.daos.factories.TransaccionGDAOFactory;
import sri.daos.transacciones.EspecialidadTGDAOImplement;
import sri.entidades.Especialidad;
import sri.entidades.Problema;
import sri.entidades.Tecnico;

/**
 *
 * @author Matías Pacheco
 */
public class EspecialidadRImplement implements RepositorioGenerico<Especialidad, Integer>{
    private EspecialidadTGDAOImplement espTransaccionGDAOI;
    
    public EspecialidadRImplement(){
        this.espTransaccionGDAOI = TransaccionGDAOFactory.getEspecialidadTGDAOI();
    }
    
    @Override
    public void add(Especialidad model) {
        espTransaccionGDAOI.create(model);
    }

    @Override
    public Especialidad get(Integer idModel) {
        return (Especialidad)espTransaccionGDAOI.read(idModel);
    }

    @Override
    public void update(Especialidad model) {
        espTransaccionGDAOI.update(model);
    }

    @Override
    public void remove(Integer idModel) {
        espTransaccionGDAOI.delete(idModel);
    }

    @Override
    public List<Especialidad> getModels() {
        return espTransaccionGDAOI.readRecords();
    }
    
    public List<Tecnico> getTecnicos(int idEspecialidad){
        return espTransaccionGDAOI.readTecnicos(idEspecialidad);
    }
    
    public List<Problema> getProblemas(int idEspecialidad){
        return espTransaccionGDAOI.readProblemas(idEspecialidad);
    }
}
