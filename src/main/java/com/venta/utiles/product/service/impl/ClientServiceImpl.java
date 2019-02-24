package com.venta.utiles.product.service.impl;

import com.venta.utiles.product.business.input.Client;
import com.venta.utiles.product.business.output.ResponseEmpty;
import com.venta.utiles.product.entity.dao.ClientDao;
import com.venta.utiles.product.repository.ClientRepository;
import com.venta.utiles.product.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ResponseEmpty addClient(Client client) {
        ResponseEmpty empty = new ResponseEmpty();
        try {
            ClientDao clientDao = new ClientDao();

            clientDao.setApPaterno(client.getApPaterno().toUpperCase());
            clientDao.setApMaterno(client.getApMaterno().toUpperCase());
            clientDao.setNombres(client.getNombres().toUpperCase());
            clientDao.setDni(client.getDni());
            clientDao.setDireccion(client.getDireccion());
            clientDao.setIdDistrito(client.getIdDistrito());
            ClientDao save = clientRepository.save(clientDao);
            if (!save.getIdCliente().isEmpty()) {
                empty.setCode("MB0000");
                empty.setDescription("Se registro correctamente");
            }
        } catch (Exception e) {
            empty.setCode("MB0002");
            empty.setDescription("Error al registrar cliente");
        }

        return empty;
    }
}
