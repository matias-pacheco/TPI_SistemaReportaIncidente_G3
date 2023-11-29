/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sri.daos.transacciones;

import java.util.List;

/**
 *
 * @author Matías Pacheco
 * @param <T>
 * @param <V>
 */
public interface TransaccionGenericaDAO<T, V> {
    public void create(T model);
    public T read(V idModel);
    public void update(T model);
    public void delete(V idModel);
    public List<T> readRecords();
}
