package com.venta.utiles.product.entity.dao;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENTE")
@Entity
public class ClientDao implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "ap_paterno")
    private String apPaterno;

    @Column(name = "ap_materno")
    private String apMaterno;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "dni")
    private int dni;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "id_distrito")
    private String idDistrito;
}
