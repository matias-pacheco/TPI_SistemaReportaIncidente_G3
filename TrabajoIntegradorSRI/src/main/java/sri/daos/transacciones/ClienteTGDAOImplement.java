/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.daos.transacciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import sri.daos.consultas.ClienteCGDAOImplement;
import sri.daos.factories.ConsultaGDAOFactory;
import sri.entidades.Cliente;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */
public class ClienteTGDAOImplement implements TransaccionGenericaDAO<Cliente, Integer>{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
    private ClienteCGDAOImplement cliConsultaGDAOI;
    
    public ClienteTGDAOImplement(){
        this.cliConsultaGDAOI = ConsultaGDAOFactory.getClienteCGDAOI();
    }
    
    private EntityManager obtenerEntityManagerConfigurado(){
        EntityManager em = emf.createEntityManager();
        cliConsultaGDAOI.setEntityManager(em);
        return em;
    }
    
    @Override
    public void create(Cliente model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        cliConsultaGDAOI.create(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Cliente read(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Cliente cliente = cliConsultaGDAOI.read(idModel);
        em.getTransaction().commit();
        em.close();
        return cliente;
    }

    @Override
    public void update(Cliente model) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        cliConsultaGDAOI.update(model);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Integer idModel) {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        Cliente cliente = cliConsultaGDAOI.read(idModel);
        cliConsultaGDAOI.delete(cliente);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Cliente> readRecords() {
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Cliente> registro = cliConsultaGDAOI.readRecords();
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Servicio> readServiciosQueReportaronIncidentesPorCliente(int idCliente){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Servicio> registro = cliConsultaGDAOI.readServiciosQueReportaronIncidentesPorCliente(idCliente);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
    
    public List<Cliente> readClientesQueReportaronIncidentesPorServicio(int idServicio){
        EntityManager em = obtenerEntityManagerConfigurado();
        em.getTransaction().begin();
        List<Cliente> registro = cliConsultaGDAOI.readClientesQueReportaronIncidentesPorServicio(idServicio);
        em.getTransaction().commit();
        em.close();
        return registro;
    }
}
