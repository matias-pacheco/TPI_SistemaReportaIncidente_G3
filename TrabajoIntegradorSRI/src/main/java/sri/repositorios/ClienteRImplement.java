/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.repositorios;

import java.util.List;
import sri.daos.factories.TransaccionGDAOFactory;
import sri.daos.transacciones.ClienteTGDAOImplement;
import sri.entidades.Cliente;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ClienteRImplement implements RepositorioGenerico<Cliente, Integer>{
    private ClienteTGDAOImplement cliTransaccionGDAOI;
   
    public ClienteRImplement(){
        this.cliTransaccionGDAOI = TransaccionGDAOFactory.getClienteTGDAOI();
    }
    
    @Override
    public void add(Cliente model) {
        cliTransaccionGDAOI.create(model);
    }

    @Override
    public Cliente get(Integer idModel) {
        return cliTransaccionGDAOI.read(idModel);
    }

    @Override
    public void update(Cliente model) {
        cliTransaccionGDAOI.update(model);
    }

    @Override
    public void remove(Integer idModel) {
        cliTransaccionGDAOI.delete(idModel);
    }

    @Override
    public List<Cliente> getModels() {
        return cliTransaccionGDAOI.readRecords();
    }
    
    public List<Servicio> getServiciosQueReportaronIncidentesPorCliente(int idCliente){
        return cliTransaccionGDAOI.readServiciosQueReportaronIncidentesPorCliente(idCliente);
    }
    
    public List<Cliente> getClientesQueReportaronIncidentesPorServicio(int idServicio){
        return cliTransaccionGDAOI.readClientesQueReportaronIncidentesPorServicio(idServicio);
    }
}
