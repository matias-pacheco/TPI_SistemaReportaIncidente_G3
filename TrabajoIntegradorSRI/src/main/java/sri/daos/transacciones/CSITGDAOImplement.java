/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.transacciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import sri.daos.consultas.CSICGDAOImplement;
import sri.daos.factories.ConsultaGDAOFactory;
import sri.entidades.intermedias.Cliente_Servicio_Incidente;

/**
 *
 * @author Matías Pacheco
 */
public class CSITGDAOImplement implements TransaccionGenericaDAO<Cliente_Servicio_Incidente, Integer>{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
    private CSICGDAOImplement csiConsultaGDAOI;
    
    public CSITGDAOImplement(){
        this.csiConsultaGDAOI = ConsultaGDAOFactory.getCSICGDAOI();
    }
    
    private EntityManager obtenerEntityManagerConfigurado(){
        EntityManager em = emf.createEntityManager();
        csiConsultaGDAOI.setEntityManager(em);
        return em;
    }

    @Override
    public void create(Cliente_Servicio_Incidente model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        csiConsultaGDAOI.create(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Cliente_Servicio_Incidente read(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Cliente_Servicio_Incidente csi = csiConsultaGDAOI.read(idModel);
        em.getTransaction().commit();
        em.close();
        return csi;
    }

    @Override
    public void update(Cliente_Servicio_Incidente model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        csiConsultaGDAOI.update(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Cliente_Servicio_Incidente csi = csiConsultaGDAOI.read(idModel);
        csiConsultaGDAOI.create(csi);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Cliente_Servicio_Incidente> readRecords() {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Cliente_Servicio_Incidente> registro = csiConsultaGDAOI.readRecords();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
}
