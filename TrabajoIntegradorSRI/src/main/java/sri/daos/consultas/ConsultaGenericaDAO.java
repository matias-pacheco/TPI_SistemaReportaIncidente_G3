/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sri.daos.consultas;

import java.util.List;
import jakarta.persistence.EntityManager;

/**
 *
 * @author Matías Pacheco
 * @param <T> Clase que corresponde al modelo del dao
 * @param <V> Tipo de dato del id del modelo
 */
public interface ConsultaGenericaDAO<T, V> {
    /**
     * @param model objeto que guardará
     * @return true si se creó el registro, false si falló
     */
    public void create(T model);

    /**
     * @param idModel clave del registro a consultar
     * @return el registro encontrado
     */
    public T read(V idModel);

    /**
     *
     * @param model objeto con nuevos valores a almacenar
//     * @param idModel clave del registro a modificar
     * @return 
     */
    public void update(T model);

    /**
     *
//     * @param idModel clave del registro a eliminar
     * @return 
     */
    public void delete(T model);

    /**
     *
     * @return lista de todos los registros
     */
    public List<T> readRecords();
    public void setEntityManager(EntityManager em);
}
