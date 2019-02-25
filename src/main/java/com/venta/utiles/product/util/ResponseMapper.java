package com.venta.utiles.product.util;

import com.venta.utiles.product.business.output.ClientResponse;
import com.venta.utiles.product.entity.dao.ClientDao;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {
    public ClientResponse responseMapper(ClientDao byDni) {
        ClientResponse response = new ClientResponse();
        response.setApPaterno(byDni.getApPaterno());
        response.setApMaterno(byDni.getApMaterno());
        response.setDni(byDni.getDni());
        response.setNombres(byDni.getNombres());
        response.setFechaRegistro(byDni.getFechaRegistro().substring(0,10));
        response.setState(byDni.getState());
        response.setIdDistrito(byDni.getIdDistrito());
        return response;
    }
}
