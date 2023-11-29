/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.factories;

import sri.daos.consultas.CSICGDAOImplement;
import sri.daos.consultas.ClienteCGDAOImplement;
import sri.daos.consultas.EspecialidadCGDAOImplement;
import sri.daos.consultas.TecnicoCGDAOImplement;
import sri.daos.consultas.ConsultaGenericaDAO;
import sri.daos.consultas.IncidenteCGDAOImplement;
import sri.daos.consultas.ProblemaCGDAOImplement;
import sri.daos.consultas.ServicioCGDAOImplement;

/**
 *
 * @author Matías Pacheco
 */
public class ConsultaGDAOFactory {
    public static TecnicoCGDAOImplement getTecnicoCGDAOI(){
        return new TecnicoCGDAOImplement();
    }
    
    public static EspecialidadCGDAOImplement getEspecialidadCGDAOI(){
        return new EspecialidadCGDAOImplement();
    }
    
    public static ProblemaCGDAOImplement getProblemaCGDAOI(){
        return new ProblemaCGDAOImplement();
    }
    
    public static ServicioCGDAOImplement getServicioCGDAOI(){
        return new ServicioCGDAOImplement();
    }
    
    public static ClienteCGDAOImplement getClienteCGDAOI(){
        return new ClienteCGDAOImplement();
    }
    
    public static IncidenteCGDAOImplement getIncidenteCGDAOI(){
        return new IncidenteCGDAOImplement();
    }
    
    public static CSICGDAOImplement getCSICGDAOI(){
        return new CSICGDAOImplement();
    }
}
