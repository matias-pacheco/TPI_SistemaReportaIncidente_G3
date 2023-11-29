/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sri.test;

import java.util.List;
import sri.entidades.Especialidad;
import sri.entidades.Problema;
import sri.entidades.Tecnico;
import sri.entidades.enumerados.NombreEspecialidad;
import sri.entidades.enumerados.TipoProblema;
import sri.repositorios.EspecialidadRImplement;
import sri.repositorios.ProblemaRImplement;
import sri.repositorios.TecnicoRImplement;

/**
 *
 * @author Matías Pacheco
 */
public class Test {

    public static void main(String[] args) {
        TecnicoRImplement tecnicoRI = new TecnicoRImplement();
        
//        Tecnico t1 = Tecnico.builder()
//                .matricula(11111)
//                .dni(50666777)
//                .apellido("Rosa")
//                .nombre("Dario")
//                .estado(true)
//                .build();
//        
//        System.out.println(t1);
//        
//        tecnicoRI.add(t1);
//
//        Tecnico t2 = tecnicoRI.get(1);
//        System.out.println(t2.getDni());
//        
//        t2.setApellido("Blanco");
//        tecnicoRI.update(t2);
//        
//        System.out.println(tecnicoRI.get(1).getApellido());

//        Tecnico t1 = Tecnico.builder()
//                .matricula(11111)
//                .dni(50666777)
//                .apellido("Rosa")
//                .nombre("Dario")
//                .estado(true)
//                .build();
//        
//        System.out.println(t1);
//        tecnicoRI.add(t1);
//        
//        Tecnico t2 = Tecnico.builder()
//                .matricula(22222)
//                .dni(10222333)
//                .apellido("Rosa")
//                .nombre("Dario")
//                .estado(true)
//                .build();
//        
//        System.out.println(t2);
//        tecnicoRI.add(t2);
//        
//        Tecnico t3 = Tecnico.builder()
//                .matricula(33333)
//                .dni(20333444)
//                .apellido("Rosa")
//                .nombre("Dario")
//                .estado(true)
//                .build();
//        
//        System.out.println(t3);
//        tecnicoRI.add(t3);
//        
//        Tecnico t4 = Tecnico.builder()
//                .matricula(44444)
//                .dni(30444555)
//                .apellido("Rosa")
//                .nombre("Dario")
//                .estado(true)
//                .build();
//        
//        System.out.println(t4);
//        tecnicoRI.add(t4);
//        
//        Tecnico t5 = Tecnico.builder()
//                .matricula(66666)
//                .dni(60777888)
//                .apellido("Rosa")
//                .nombre("Dario")
//                .estado(true)
//                .build();
//        
//        System.out.println(t5);
//        tecnicoRI.add(t5);

//-------------------------------------------------------------------------------
        EspecialidadRImplement especialidadRI = new EspecialidadRImplement();
////        
//        Especialidad especialidad = Especialidad.builder()
//                .nombre(NombreEspecialidad.SAP)
//                .build();
//        especialidadRI.add(especialidad);
//
//        System.out.println(tecnicoRI.getModels().size());
//        
//        List<Tecnico> registro = tecnicoRI.getModels();
//        
//        registro.stream().forEach(System.out::println);
//        registro.stream()
//                .map(t -> {t.setEspecialidades(especialidadRI.getModels()); return t;})
//                .forEach(t -> tecnicoRI.update(t));
        
//        List<Especialidad> registro2 = tecnicoRI.getEspecialidades();
//        registro2.stream().forEach(System.out::println);

//        registro.stream().forEach(t -> tecnicoRI.update(t));
//        registro.stream().forEach(t -> System.out.println(t.getEspecialidades().toString()));

//        List<Tecnico> registro3 = especialidadRI.getTecnicos();
//        registro3.stream().forEach(System.out::println);

//-----------------------------------------------------------------------------------
//-------------------- P R U E B A S   C R U D   P R O B L E M A --------------------
//-----------------------------------------------------------------------------------
        ProblemaRImplement problemaRI = new ProblemaRImplement();
//---------------------------------- C R E A T E ------------------------------------
//---------- PROBLEMA1 ----------
//        Problema problema1 = Problema.builder()
//                .tipo(TipoProblema.CONEXION)
//                .build();
//        problemaRI.add(problema1);
//        
////---------- PROBLEMA2 ----------
//        Problema problema2 = Problema.builder()
//                .tipo(TipoProblema.ACTUALIZACION)
//                .build();
//        problemaRI.add(problema2);
//        
////---------- PROBLEMA3 ----------
//        Problema problema3 = Problema.builder()
//                .tipo(TipoProblema.FUNCIONAMIENTO)
//                .build();
//        problemaRI.add(problema3);
//        
//        Especialidad especialidad3 = Especialidad.builder()
//                .nombre(NombreEspecialidad.TANGO)
//                .build();
//        especialidadRI.add(especialidad3);

        
   }
}
