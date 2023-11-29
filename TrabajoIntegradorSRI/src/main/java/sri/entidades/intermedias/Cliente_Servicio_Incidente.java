/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sri.entidades.intermedias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sri.entidades.Cliente;
import sri.entidades.Incidente;
import sri.entidades.Servicio;

/**
 *
 * @author Matías Pacheco
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "cliente_servicio_incidente")
public class Cliente_Servicio_Incidente {
    @Id
    @ManyToOne
    @JoinColumn(name = "incidente_id")
    private Incidente incidente;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
}
