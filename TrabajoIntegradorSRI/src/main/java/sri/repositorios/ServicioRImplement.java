/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.repositorios;

import java.util.List;
import sri.daos.factories.TransaccionGDAOFactory;
import sri.daos.transacciones.ServicioTGDAOImplement;
import sri.entidades.Cliente;
import sri.entidades.Problema;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ServicioRImplement implements RepositorioGenerico<Servicio, Integer>{
    private ServicioTGDAOImplement serTransaccionGDAOI;
    
    public ServicioRImplement(){
        this.serTransaccionGDAOI = TransaccionGDAOFactory.getServicioTGDAOI();
    }

    @Override
    public void add(Servicio model) {
        serTransaccionGDAOI.create(model);
    }

    @Override
    public Servicio get(Integer idModel) {
        return serTransaccionGDAOI.read(idModel);
    }

    @Override
    public void update(Servicio model) {
        serTransaccionGDAOI.update(model);
    }

    @Override
    public void remove(Integer idModel) {
        serTransaccionGDAOI.delete(idModel);
    }

    @Override
    public List<Servicio> getModels() {
        return serTransaccionGDAOI.readRecords();
    }
    
    public List<Problema> getProblemas(int idServicio){
        return serTransaccionGDAOI.readProblemas(idServicio);
    }
    
    public List<Cliente> getClientesQueReportaronIncidentesPorServicio(int idServicio){
        return serTransaccionGDAOI.readClientesQueReportaronIncidentesPorServicio(idServicio);
    }
    
    public List<Servicio> getServiciosQueReportaronIncidentesPorCliente(int idCliente){
        return serTransaccionGDAOI.readServiciosQueReportaronIncidentesPorCliente(idCliente);
    }
}
