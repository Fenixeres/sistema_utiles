package com.venta.utiles.product.business.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponse extends ResponseEmpty {

    private String apPaterno;
    private String apMaterno;
    private String nombres;
    private String dni;
    private String idDistrito;
    private String fechaRegistro;
    private String state;

}
