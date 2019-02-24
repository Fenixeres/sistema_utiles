package com.venta.utiles.product.business.input;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Client implements Serializable {

    private String apPaterno;
    private String apMaterno;
    private String nombres;
    private Integer dni;
    private String direccion;
    private String idDistrito;
}
