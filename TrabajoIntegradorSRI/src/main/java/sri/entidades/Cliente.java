/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sri.entidades.intermedias.Cliente_Servicio_Incidente;

/**
 *
 * @author Matías Pacheco
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"servicios", "incidentes"})

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 11, nullable = false, unique = true)
    private String cuit;
    @Column(length = 45, nullable = false)
    private String razonSocial;
    @Column(nullable = false, unique = true)
    private int dni;
    @Column(length = 45, nullable = false)
    private String apellido;
    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private boolean estado;
    @ManyToMany
    @JoinTable(name = "cliente_servicio_incidente",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> servicios;
//    @OneToMany(mappedBy = "clientes")
//    private List<Incidente> incidentes;
    @OneToMany(mappedBy = "cliente")
    private List<Cliente_Servicio_Incidente> csi;
}