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
import sri.entidades.enumerados.TipoProblema;

/**
 *
 * @author Matías Pacheco
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"especialidades", "servicios", "incidentes"})

@Entity
@Table(name = "problema")
public class Problema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(length = 45, nullable = false, unique = true)
    private TipoProblema tipo; //posible ENUM
    @ManyToMany(mappedBy = "problemas")
    private List<Especialidad> especialidades;
    @ManyToMany(mappedBy = "problemas")
    private List<Servicio> servicios;
    @OneToMany(mappedBy = "problema")
    private List<Incidente> incidentes;
}
