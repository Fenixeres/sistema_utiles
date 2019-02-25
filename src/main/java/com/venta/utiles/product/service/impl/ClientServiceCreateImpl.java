package com.venta.utiles.product.service.impl;

import com.venta.utiles.product.business.input.Client;
import com.venta.utiles.product.business.output.ResponseEmpty;
import com.venta.utiles.product.entity.dao.ClientDao;
import com.venta.utiles.product.repository.ClientRepository;
import com.venta.utiles.product.service.ClientServiceCreate;
import com.venta.utiles.product.util.ErrorCode;
import com.venta.utiles.product.util.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceCreateImpl extends ErrorCode implements ClientServiceCreate {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RequestMapper requestMapper;


    @Override
    public ResponseEmpty addClient(Client client) {
        ResponseEmpty empty = new ResponseEmpty();
        try {

            String dni = String.valueOf(client.getDni());

            ClientDao clientDao = requestMapper.requestClient(client);

            ClientDao byDni = clientRepository.findByDni(dni);

            if (byDni == null) {
                saveClient(clientDao, empty);
            } else if (byDni.getDni().equals(dni)) {
                empty.setCode(code2);
                empty.setDescription(detail2);
            }
        } catch (Exception e) {
            empty.setCode(code3);
            empty.setDescription(detail3 + e.getMessage());
        }

        return empty;
    }

    public ResponseEmpty saveClient(ClientDao clientDao, ResponseEmpty empty) {
        ClientDao save = clientRepository.save(clientDao);

        if (!save.getIdCliente().isEmpty()) {
            empty.setCode(code1);
            empty.setDescription(detail1);
        }
        return empty;
    }
}
