/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.entidades;

import java.util.List;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sri.entidades.enumerados.NombreEspecialidad;

/**
 *
 * @author Matías Pacheco
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(of = {"id", "nombre"})

@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(length = 45, nullable = false)
    private NombreEspecialidad nombre; //posible ENUM
    @ManyToMany(mappedBy = "especialidades")
    private List<Tecnico> tecnicos;
    @ManyToMany
    @JoinTable(name = "especialidad_problema",
            joinColumns = @JoinColumn(name = "especialidad_id"),
            inverseJoinColumns = @JoinColumn(name = "problema_id"))
    private List<Problema> problemas;
}
