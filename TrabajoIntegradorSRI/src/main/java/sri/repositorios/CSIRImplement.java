/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.repositorios;

import java.util.List;
import sri.daos.factories.TransaccionGDAOFactory;
import sri.daos.transacciones.CSITGDAOImplement;
import sri.entidades.intermedias.Cliente_Servicio_Incidente;

/**
 *
 * @author Matías Pacheco
 */
public class CSIRImplement implements RepositorioGenerico<Cliente_Servicio_Incidente, Integer>{
    private CSITGDAOImplement csiTransaccionGDAOI;
    
    public CSIRImplement(){
        this.csiTransaccionGDAOI = TransaccionGDAOFactory.getOCSITGDAOI();
    }
    
    @Override
    public void add(Cliente_Servicio_Incidente model) {
        csiTransaccionGDAOI.create(model);
    }

    @Override
    public Cliente_Servicio_Incidente get(Integer idModel) {
        return csiTransaccionGDAOI.read(idModel);
    }

    @Override
    public void update(Cliente_Servicio_Incidente model) {
        csiTransaccionGDAOI.update(model);
    }

    @Override
    public void remove(Integer idModel) {
        csiTransaccionGDAOI.delete(idModel);
    }

    @Override
    public List<Cliente_Servicio_Incidente> getModels() {
        return csiTransaccionGDAOI.readRecords();
    }
}
