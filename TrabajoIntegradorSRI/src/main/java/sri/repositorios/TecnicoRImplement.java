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
import sri.entidades.enumerados.NombreEspecialidad;

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
    
    public Tecnico getTecnicoConMasIncidentes(){
        return tecTransaccionGDAOI.readTecnicoConMásIncidentes();
    } 
    
    public List<Tecnico> getTecnicosConMasIncidentes(){
        return tecTransaccionGDAOI.readTecnicosConMásIncidentes();
    }
    
    public List<Tecnico> getTecnicosConMasIncidentesResueltos(){
        return tecTransaccionGDAOI.readTecnicosConMásIncidentesResueltos();
    } 

    public List<Tecnico> getTecnicosConMasIncidentesResueltosEnlosUltimosNDias(int nDias){
        return tecTransaccionGDAOI.readTecnicosConMásIncidentesResueltosEnLosUltimosNDias(nDias);
    }
    
    public List<Tecnico> getTecnicosDeUnaDeterminadaEspecialidadConMasIncidentesResueltosEnlosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        return tecTransaccionGDAOI.readTecnicosDeUnaDeterminadaEspecialidadConMásIncidentesResueltosEnLosUltimosNDias(
                nombreEspecialidad, nDias);
    } 
    
    public List<Incidente> getIncidentesResueltosMasRapido(){
        return tecTransaccionGDAOI.readIncidentesResueltosMasRapido();
    }
    
    public List<Tecnico> getTecnicosDeIncidentesResueltosMasRapido(){
        return tecTransaccionGDAOI.readTecnicosDeIncidentesResueltosMasRapido();
    }
    
    public List<Tecnico> getTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDias(int nDias){
        return tecTransaccionGDAOI.readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDias(nDias);
    }
    
    public List<Tecnico> getTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDiasV2(int nDias){
        return tecTransaccionGDAOI.readTecnicosDeIncidentesResueltosMasRapidoEnLosUltimosNDiasV2(nDias);
    }
    
    public List<Tecnico> getTecnicosDeUnaDeterminadaEspecialidadConIncidentesResueltosMasRapidoEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        return tecTransaccionGDAOI.readTecnicosDeUnaDeterminadaEspecialidadConIncidentesResueltosMasRapidoEnLosUltimosNDias(
                nombreEspecialidad, nDias);
    }
    
    public List<Tecnico> getTecnicosConPromedioDeIncidentesResueltosMasRapido(){
        return tecTransaccionGDAOI.readTecnicosConPromedioDeIncidentesResueltosMasRapido();
    }
    
    public List<Tecnico> getTecnicosConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(int nDias){
        return tecTransaccionGDAOI.readTecnicosConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(nDias);
    }

    public List<Tecnico> getTecnicosDeUnaDeterminadaEspecialidadConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(
            NombreEspecialidad nombreEspecialidad, int nDias){
        return tecTransaccionGDAOI.readTecnicosDeUnaDeterminadaEspecialidadConPromedioDeIncidentesResueltosMasRapidoEnLosUltimosNDias(
                nombreEspecialidad, nDias);
    }
}
