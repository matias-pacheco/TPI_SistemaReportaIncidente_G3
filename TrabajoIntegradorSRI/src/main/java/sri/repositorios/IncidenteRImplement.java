/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.repositorios;

import java.util.List;
import sri.daos.factories.TransaccionGDAOFactory;
import sri.daos.transacciones.IncidenteTGDAOImplement;
import sri.entidades.Cliente;
import sri.entidades.Incidente;
import sri.entidades.Problema;
import sri.entidades.Servicio;
import sri.entidades.Tecnico;

/**
 *
 * @author Matías Pacheco
 */
public class IncidenteRImplement implements RepositorioGenerico<Incidente, Integer>{
    private IncidenteTGDAOImplement incTransaccionGDAOI;
    
    public IncidenteRImplement(){
        this.incTransaccionGDAOI = TransaccionGDAOFactory.getOIncidenteTGDAOI();
    }

    @Override
    public void add(Incidente model) {
        incTransaccionGDAOI.create(model);
    }

    @Override
    public Incidente get(Integer idModel) {
        return incTransaccionGDAOI.read(idModel);
    }

    @Override
    public void update(Incidente model) {
        incTransaccionGDAOI.update(model);
    }

    @Override
    public void remove(Integer idModel) {
        incTransaccionGDAOI.delete(idModel);
    }

    @Override
    public List<Incidente> getModels() {
        return incTransaccionGDAOI.readRecords();
    }
    
    public Tecnico readTecnico(int idIncidente){
        return incTransaccionGDAOI.readTecnico(idIncidente);
    }
    
    public Problema readProblema(int idIncidente){
        return incTransaccionGDAOI.readProblema(idIncidente);
    }
    
    public Servicio readServicio(int idServicio){
        return incTransaccionGDAOI.readServicio(idServicio);
    }
    
    public Cliente readCliente(int idCliente){
        return incTransaccionGDAOI.readCliente(idCliente);
    }
}
