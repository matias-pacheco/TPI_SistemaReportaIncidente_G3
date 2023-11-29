/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sri.repositorios;

import java.util.List;

/**
 *
 * @author Matías Pacheco
 */
public interface RepositorioGenerico <T, V>{
    public void add(T model);
    public T get(V idModel);
    public void update(T model);
    public void remove(V idModel);
    public List<T> getModels();
}
