/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.repositorios;

import java.util.List;
import sri.daos.factories.TransaccionGDAOFactory;
import sri.daos.transacciones.TecnicoTGDAOImplement;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.Tecnico;

/**
 *
 * @author Matías Pacheco
 */
public class TecnicoRImplement implements RepositorioGenerico<Tecnico, Integer>{
    private TecnicoTGDAOImplement tecTransaccionGDAOI;
    
    public TecnicoRImplement(){
        this.tecTransaccionGDAOI = TransaccionGDAOFactory.getTecnicoTGDAOI();
    }
    
    @Override
    public void add(Tecnico model) {
        tecTransaccionGDAOI.create(model);
    }

    @Override
    public Tecnico get(Integer idModel) {
        return (Tecnico)tecTransaccionGDAOI.read(idModel);
    }

    @Override
    public void update(Tecnico model) {
        tecTransaccionGDAOI.update(model);
    }

    @Override
    public void remove(Integer idModel) {
        tecTransaccionGDAOI.delete(idModel);
    }

    @Override
    public List<Tecnico> getModels() {
        return tecTransaccionGDAOI.readRecords();
    }
    
    public List<Especialidad> getEspecialidades(int idTecnico){
        return tecTransaccionGDAOI.readEspecialidades(idTecnico);
    }
    
    public List<Incidente> getIncidentes(int idTecnico){
        return tecTransaccionGDAOI.readIncidentes(idTecnico);
    }
    
    public Tecnico getTecnicoConMasIncidentesResueltosEnNdias(int nDias){
        return tecTransaccionGDAOI.readTecnicoConMasIncidentesResueltEnNDias(nDias);
    }
}
