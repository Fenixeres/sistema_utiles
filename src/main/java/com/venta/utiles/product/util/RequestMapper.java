package com.venta.utiles.product.util;

import com.venta.utiles.product.business.input.Client;
import com.venta.utiles.product.entity.dao.ClientDao;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper {

    public ClientDao requestClient(Client client) {

        ClientDao clientDao = new ClientDao();

        clientDao.setApPaterno(client.getApPaterno().toUpperCase());
        clientDao.setApMaterno(client.getApMaterno().toUpperCase());
        clientDao.setNombres(client.getNombres().toUpperCase());
        clientDao.setDni(client.getDni());
        clientDao.setDireccion(client.getDireccion());
        clientDao.setIdDistrito(client.getIdDistrito());

        return clientDao;
    }

}
