/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.entidades;

import java.util.List;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Matías Pacheco
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"especialidades", "incidentes"})

@Entity
@Table(name = "tecnico")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private int matricula;
    @Column(nullable = false, unique = true)
    private int dni;
    @Column(length = 45, nullable = false)
    private String apellido;
    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private boolean estado;
    @ManyToMany
    @JoinTable(name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "tecnico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private List<Especialidad> especialidades;
    @OneToMany(mappedBy = "tecnico")
    private List<Incidente> incidentes;
}
