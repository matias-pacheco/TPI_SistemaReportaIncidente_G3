/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import sri.entidades.enumerados.App;
import sri.entidades.enumerados.SO;
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
@ToString(exclude = {"problemas", "clientes", "csi"})

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(length = 45, nullable = false, unique = true)
    private App app;
    @Enumerated(EnumType.STRING)
    @Column(length = 45, nullable = false, unique = true)
    private SO so;
    @Column(nullable = false)
    private boolean estado;
    @ManyToMany
    @JoinTable(name = "servicio_problema",
            joinColumns = @JoinColumn(name = "servicio_id"),
            inverseJoinColumns = @JoinColumn(name = "problema_id"))
    private List<Problema> problemas;
    @ManyToMany(mappedBy = "servicios")
    private List<Cliente> clientes;
//    @OneToMany(mappedBy = "servicios")
//    private List<Incidente> incidentes;
    @OneToMany(mappedBy = "servicio")
    private List<Cliente_Servicio_Incidente> csi;
}