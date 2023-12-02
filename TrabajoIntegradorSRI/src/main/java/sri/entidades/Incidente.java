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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sri.entidades.enumerados.DificultadTecnica;
import sri.entidades.enumerados.IncidenteEstado;
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
@ToString(exclude = {"csi"})

@Entity
@Table(name = "incidente")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
//    @Temporal(TemporalType.DATE)
    private LocalDate ingreso;
    @ManyToOne
    @JoinColumn(name = "problema_id", referencedColumnName = "id", nullable = false)
    private Problema problema;
    @Column(length = 100, nullable = false)
    private String descripcionProblema;
    @ManyToOne
    @JoinColumn(name = "tecnico_id", referencedColumnName = "id")
    private Tecnico tecnico; //en la primera instancia podría ser NULL
//    @Temporal(TemporalType.DATE)
    private LocalDate tiempoEstimado; //en la primera instancia podría ser NULL
    @Column(length = 100)
    private String indicacionesTecnicas; //en la primera instancia podría ser NULL
    @Enumerated(EnumType.STRING)
    @Column(length = 45)
    private DificultadTecnica dificultadTecnica; //en la primera instancia podría ser NULL
//    @Temporal(TemporalType.DATE)
    private LocalDate tiempoMaximo; //en la primera instancia podría ser NULL
//    @Temporal(TemporalType.DATE)
    private LocalDate resolucion; //en la primera instancia podría ser NULL
    @Enumerated(EnumType.STRING)
    @Column(length = 45, nullable = false)
    private IncidenteEstado estado;
//    @ManyToMany
//    @JoinTable(name = "incidente_cliente",
//            joinColumns = @JoinColumn(name = "incidente_id"),
//            inverseJoinColumns = @JoinColumn(name = "cliente_id"))
//    private List<Cliente> clientes;
//    @ManyToMany
//    @JoinTable(name = "incidente_servicio",
//            joinColumns = @JoinColumn(name = "incidente_id"),
//            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
//    private List<Servicio> servicios;
    @OneToMany(mappedBy = "incidente")
    private List<Cliente_Servicio_Incidente> csi;
}
