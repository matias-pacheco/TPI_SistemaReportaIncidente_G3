/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.factories;

import sri.daos.transacciones.CSITGDAOImplement;
import sri.daos.transacciones.ClienteTGDAOImplement;
import sri.daos.transacciones.EspecialidadTGDAOImplement;
import sri.daos.transacciones.IncidenteTGDAOImplement;
import sri.daos.transacciones.ProblemaTGDAOImplement;
import sri.daos.transacciones.ServicioTGDAOImplement;
import sri.daos.transacciones.TecnicoTGDAOImplement;
import sri.daos.transacciones.TransaccionGenericaDAO;

/**
 *
 * @author Matías Pacheco
 */
public class TransaccionGDAOFactory {
    public static TecnicoTGDAOImplement getTecnicoTGDAOI(){
        return new TecnicoTGDAOImplement();
    }
    
    public static EspecialidadTGDAOImplement getEspecialidadTGDAOI(){
        return new EspecialidadTGDAOImplement();
    }
    
    public static ProblemaTGDAOImplement getProblemaTGDAOI(){
        return new ProblemaTGDAOImplement();
    }
   
    public static ServicioTGDAOImplement getServicioTGDAOI(){
        return new ServicioTGDAOImplement();
    }
    
    public static ClienteTGDAOImplement getClienteTGDAOI(){
        return new ClienteTGDAOImplement();
    }
   
    public static IncidenteTGDAOImplement getOIncidenteTGDAOI(){
        return new IncidenteTGDAOImplement();
    }
    
    public static CSITGDAOImplement getOCSITGDAOI(){
        return new CSITGDAOImplement();
    }
}
