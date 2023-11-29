/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sri.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import sri.entidades.Cliente;
import sri.entidades.Especialidad;
import sri.entidades.Incidente;
import sri.entidades.Problema;
import sri.entidades.Servicio;
import sri.entidades.Tecnico;
import sri.entidades.enumerados.App;
import sri.entidades.enumerados.DificultadTecnica;
import sri.entidades.enumerados.IncidenteEstado;
import sri.entidades.enumerados.NombreEspecialidad;
import sri.entidades.enumerados.SO;
import sri.entidades.enumerados.TipoProblema;
import sri.entidades.intermedias.Cliente_Servicio_Incidente;
import sri.repositorios.CSIRImplement;
import sri.repositorios.ClienteRImplement;
import sri.repositorios.EspecialidadRImplement;
import sri.repositorios.IncidenteRImplement;
import sri.repositorios.ProblemaRImplement;
import sri.repositorios.ServicioRImplement;
import sri.repositorios.TecnicoRImplement;

/**
 *
 * @author Matías Pacheco
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TecnicoRImplement tecnicoRI = new TecnicoRImplement();
        EspecialidadRImplement especialidadRI = new EspecialidadRImplement();
        ProblemaRImplement problemaRI = new ProblemaRImplement();
        ServicioRImplement servicioRI = new ServicioRImplement();
        ClienteRImplement clienteRI = new ClienteRImplement();
        IncidenteRImplement incidenteRI = new IncidenteRImplement();
        CSIRImplement csiRI = new CSIRImplement();
        
//-----------------------------------------------------------------------------------------------------
//---------------------------- P R U E B A S   C R U D   T E C N I C O --------------------------------

//------------------------------------------ C R E A T E ----------------------------------------------
//        Tecnico tec1 = Tecnico.builder()
//                .matricula(12345)
//                .dni(10222333)
//                .apellido("Medina")
//                .nombre("Florencia")
//                .estado(true)
//                .build();
//        
//        tecnicoRI.add(tec1);
//        
//        Tecnico tec2 = Tecnico.builder()
//                .matricula(23456)
//                .dni(20333444)
//                .apellido("Sosa")
//                .nombre("Guillermo")
//                .estado(true)
//                .build();
//        
//        tecnicoRI.add(tec2);
//        
//        Tecnico tec3 = Tecnico.builder()
//                .matricula(34567)
//                .dni(30444555)
//                .apellido("Fernandez")
//                .nombre("Bruno")
//                .estado(true)
//                .build();
//        
//        tecnicoRI.add(tec3);

//------------------------------------- create tecnico_especialidad ---------------------------------
//------------------------------------------ R E A D ------------------------------------------------
//        Tecnico tec1R1 = tecnicoRI.get(1);
//        Tecnico tec2R1 = tecnicoRI.get(2);
//        Tecnico tec3R1 = tecnicoRI.get(3);
        
//------------------------------------------ U P D A T E ------------------------------------------------
//        List<Especialidad> registroEsp1 = new ArrayList<>();
//        registroEsp1.add(especialidadRI.get(1));
//        tec1R1.setEspecialidades(registroEsp1);
//        
//        tecnicoRI.update(tec1R1);
//
//        List<Especialidad> registroEsp2 = new ArrayList<>();
//        registroEsp2.add(especialidadRI.get(2));
//        tec2R1.setEspecialidades(registroEsp2);
//        
//        tecnicoRI.update(tec2R1);
//
//        List<Especialidad> registroEsp3 = new ArrayList<>();
//        registroEsp3.add(especialidadRI.get(3));
//        tec3R1.setEspecialidades(registroEsp3);
//        
//        tecnicoRI.update(tec3R1);

//-----------------------------------------------------------------------------------------------------
//----------------------- P R U E B A S   C R U D   E S P E C I A L I D A D ---------------------------

//------------------------------------------ C R E A T E ----------------------------------------------
//        Especialidad esp1 = Especialidad.builder()
//                .nombre(NombreEspecialidad.SAP)
//                .build();
//        
//        especialidadRI.add(esp1);
//        
//        Especialidad esp2 = Especialidad.builder()
//                .nombre(NombreEspecialidad.TANGO)
//                .build();
//        
//        especialidadRI.add(esp2);
//        
//        Especialidad esp3 = Especialidad.builder()
//                .nombre(NombreEspecialidad.SIP)
//                .build();
//        
//        especialidadRI.add(esp3);

//------------------------------------ create especialidad_problema ---------------------------------
//------------------------------------------ R E A D ------------------------------------------------
//        Especialidad esp1R1 = especialidadRI.get(1);
//        Especialidad esp2R1 = especialidadRI.get(2);
//        Especialidad esp3R1 = especialidadRI.get(3);
        
//------------------------------------------ U P D A T E ------------------------------------------------
//        List<Problema> registroPro1 = new ArrayList<>();
//        registroPro1.add(problemaRI.get(1));
//        registroPro1.add(problemaRI.get(2));
//        esp1R1.setProblemas(registroPro1);
//        
//        especialidadRI.update(esp1R1);
//
//        List<Problema> registroPro2 = new ArrayList<>();
//        registroPro2.add(problemaRI.get(2));
//        registroPro2.add(problemaRI.get(3));
//        esp2R1.setProblemas(registroPro2);
//        
//        especialidadRI.update(esp2R1);
//
//        List<Problema> registroPro3 = new ArrayList<>();
//        registroPro3.add(problemaRI.get(3));
//        registroPro3.add(problemaRI.get(1));
//        esp3R1.setProblemas(registroPro3);
//        
//        especialidadRI.update(esp3R1);

//-------------------------------- R E A D (consultas especializadas)----------------------------------
        System.out.println(tecnicoRI.getTecnicoConMasIncidentesResueltosEnNdias(10));


//-----------------------------------------------------------------------------------------------------
//------------------------------ P R U E B A S   C R U D   P R O B L E M A ----------------------------
        
//-------------------------------------------- C R E A T E --------------------------------------------
//        Problema prob1 = Problema.builder()
//                .tipo(TipoProblema.CONEXION)
//                .build();
//        
//        problemaRI.add(prob1);
//        
//        Problema prob2 = Problema.builder()
//                .tipo(TipoProblema.ACTUALIZACION)
//                .build();
//        
//        problemaRI.add(prob2);
//        
//        Problema prob3 = Problema.builder()
//                .tipo(TipoProblema.FUNCIONAMIENTO)
//                .build();
//        
//        problemaRI.add(prob3);
        
//-----------------------------------------------------------------------------------------------------
//----------------------------- P R U E B A S   C R U D   S E R V I C I O -----------------------------

//-------------------------------------------- C R E A T E --------------------------------------------
//        Servicio ser1 = Servicio.builder()
//                .app(App.SAP)
//                .so(SO.MACOS)
//                .estado(true)
//                .build();
//        
//        servicioRI.add(ser1);
//        
//        Servicio ser2 = Servicio.builder()
//                .app(App.TANGO)
//                .so(SO.WINDOWS)
//                .estado(true)
//                .build();
//        
//        servicioRI.add(ser2);
//        
//        Servicio ser3 = Servicio.builder()
//                .app(App.SIP)
//                .so(SO.LINUX_UBUNTU)
//                .estado(true)
//                .build();
//        
//        servicioRI.add(ser3);

//------------------------------------ create servicio_problema -------------------------------------
//------------------------------------------ R E A D ------------------------------------------------
//        Servicio ser1R1 = servicioRI.get(1);
//        Servicio ser2R1 = servicioRI.get(2);
//        Servicio ser3R1 = servicioRI.get(3);
        
//------------------------------------------ U P D A T E ------------------------------------------------
//        List<Problema> registroPro4 = new ArrayList<>();
//        registroPro4.add(problemaRI.get(1));
//        ser1R1.setProblemas(registroPro4);
//        
//        servicioRI.update(ser1R1);
//
//        List<Problema> registroPro5 = new ArrayList<>();
//        registroPro5.add(problemaRI.get(2));
//        ser2R1.setProblemas(registroPro5);
//        
//        servicioRI.update(ser2R1);
//
//        List<Problema> registroPro6 = new ArrayList<>();
//        registroPro6.add(problemaRI.get(3));
//        ser3R1.setProblemas(registroPro6);
//        
//        servicioRI.update(ser3R1);
        
//----------------------------------------------------------------------------------------------------
//----------------------------- P R U E B A S   C R U D   C L I E N T E ------------------------------

//------------------------------------------- C R E A T E --------------------------------------------
//        Cliente cli1 = Cliente.builder()
//                .cuit("11405556661")
//                .razonSocial("RS.srl")
//                .dni(40555666)
//                .apellido("Godoy")
//                .nombre("Lautaro")
//                .estado(true)
//                .build();
//        
//        clienteRI.add(cli1);
//        
//        Cliente cli2 = Cliente.builder()
//                .cuit("22506667772")
//                .razonSocial("Razon.srl")
//                .dni(50666777)
//                .apellido("Brito")
//                .nombre("Tomas")
//                .estado(true)
//                .build();
//        
//        clienteRI.add(cli2);
//        
//        Cliente cli3 = Cliente.builder()
//                .cuit("33607778883")
//                .razonSocial("Social.srl")
//                .dni(60777888)
//                .apellido("Cristaldo")
//                .nombre("Ruben")
//                .estado(true)
//                .build();
//        
//        clienteRI.add(cli3);
        
//--------------------------------------------------------------------------------------------------------
//----------------------------- P R U E B A S   C R U D   I N C I D E N T E ------------------------------

//---------------------------------------------- C R E A T E ---------------------------------------------
//        Incidente inc1 = Incidente.builder()
//                .ingreso(LocalDate.of(2023, Month.OCTOBER, 15))
//                .problema(problemaRI.get(1))
//                .descripcionProblema("Hace una semana que bla bla bla bla bla")
//                .estado(IncidenteEstado.ABIERTO)
//                .build();
//        
//        incidenteRI.add(inc1);
//        
//        Incidente inc2 = Incidente.builder()
//                .ingreso(LocalDate.of(2023, Month.OCTOBER, 20))
//                .problema(problemaRI.get(2))
//                .descripcionProblema("Hola mi problema es que bla bla bla bla bla")
//                .estado(IncidenteEstado.ABIERTO)
//                .build();
//        
//        incidenteRI.add(inc2);
//        
//        Incidente inc3 = Incidente.builder()
//                .ingreso(LocalDate.of(2023, Month.OCTOBER, 25))
//                .problema(problemaRI.get(3))
//                .descripcionProblema("Me gustaria saber por que bla bla bla bla bla")
//                .estado(IncidenteEstado.ABIERTO)
//                .build();
//        
//        incidenteRI.add(inc3);

//---------------------------------------------- R E A D ---------------------------------------------
//        Incidente inc1R = incidenteRI.get(1);
//        System.out.println(inc1R);
//        
//        Incidente inc2R = incidenteRI.get(2);
//        System.out.println(inc2R);
//
//        Incidente inc3R = incidenteRI.get(3);
//        System.out.println(inc3R);
        
//---------------------------------------------- U P D A T E ---------------------------------------------
//        inc1R.setTecnico(tecnicoRI.get(1));
//        inc1R.setTiempoEstimado(LocalDate.of(2023, Month.OCTOBER, 25));
//        inc1R.setIndicacionesTecnicas("Tenes que...");
//        inc1R.setDificultadTecnica(DificultadTecnica.INTERMEDIO);
//        inc1R.setResolucion(LocalDate.of(2023, Month.OCTOBER, 25));
//        inc1R.setEstado(IncidenteEstado.RESUELTO);
//        
//        incidenteRI.update(inc1R);
//
//        inc2R.setTecnico(tecnicoRI.get(2));
//        inc2R.setTiempoEstimado(LocalDate.of(2023, Month.OCTOBER, 30));
//        inc2R.setIndicacionesTecnicas("Primero ...");
//        inc2R.setDificultadTecnica(DificultadTecnica.INTERMEDIO);
//        inc2R.setResolucion(LocalDate.of(2023, Month.OCTOBER, 30));
//        inc2R.setEstado(IncidenteEstado.RESUELTO);
//        
//        incidenteRI.update(inc2R);
//
//        inc3R.setTecnico(tecnicoRI.get(3));
//        inc3R.setTiempoEstimado(LocalDate.of(2023, Month.NOVEMBER, 05));
//        inc3R.setIndicacionesTecnicas("Lo que tenes que hacer es...");
//        inc3R.setDificultadTecnica(DificultadTecnica.INTERMEDIO);
//        inc3R.setResolucion(LocalDate.of(2023, Month.NOVEMBER, 05));
//        inc3R.setEstado(IncidenteEstado.RESUELTO);
//        
//        incidenteRI.update(inc3R);

//-----------------------------------------------------------------------------------------------------
//----------- P R U E B A S   C R U D   C L I E N T E _ S E R V I C I O _ I N C I D E N T E -----------

//-------------------------------------------- C R E A T E -------------------------------------------- 
//---------------------------------- create cliente_servicio_incidente --------------------------------
//        Incidente inc1R1 = incidenteRI.get(1);
//        Cliente cli1R1 = clienteRI.get(1);
//        Servicio ser1R1 = servicioRI.get(1);
//        
//        Cliente_Servicio_Incidente csi1 = new Cliente_Servicio_Incidente(inc1R1, cli1R1, ser1R1);
//        csiRI.add(csi1);
//        
//        
//        Incidente inc2R1 = incidenteRI.get(2);
//        Cliente cli2R1 = clienteRI.get(2);
//        Servicio ser2R1 = servicioRI.get(2);
//        
//        Cliente_Servicio_Incidente csi2 = new Cliente_Servicio_Incidente(inc2R1, cli2R1, ser2R1);
//        csiRI.add(csi2);
//        
//        
//        Incidente inc3R1 = incidenteRI.get(3);
//        Cliente cli3R1 = clienteRI.get(3);
//        Servicio ser3R1 = servicioRI.get(3);
//        
//        Cliente_Servicio_Incidente csi3 = new Cliente_Servicio_Incidente(inc3R1, cli3R1, ser3R1);
//        csiRI.add(csi3);
    }
}
