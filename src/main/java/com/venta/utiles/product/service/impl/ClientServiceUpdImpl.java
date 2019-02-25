package com.venta.utiles.product.service.impl;

import com.venta.utiles.product.business.input.Client;
import com.venta.utiles.product.business.output.ResponseEmpty;
import com.venta.utiles.product.entity.dao.ClientDao;
import com.venta.utiles.product.repository.ClientRepository;
import com.venta.utiles.product.service.ClientServiceUpd;
import com.venta.utiles.product.util.ErrorCode;
import com.venta.utiles.product.util.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceUpdImpl extends ErrorCode implements ClientServiceUpd {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RequestMapper requestMapper;

    @Override
    public ResponseEmpty updClient(Client client) {
        ResponseEmpty empty = new ResponseEmpty();
        try {

            String dni = String.valueOf(client.getDni());
            ClientDao byDni = clientRepository.findByDni(dni);

            if (byDni != null) {
                byDni.setNombres(client.getNombres().toUpperCase());
                byDni.setApPaterno(client.getApPaterno().toUpperCase());
                byDni.setApMaterno(client.getApMaterno().toUpperCase());
                byDni.setDni(client.getDni());
                byDni.setDireccion(client.getDireccion());
                byDni.setIdDistrito(client.getIdDistrito());
                clientRepository.save(byDni);
                empty.setCode(code4);
                empty.setDescription(detail4);
            } else {
                empty.setCode(code5);
                empty.setDescription(detail5);
            }
        } catch (Exception e) {
            empty.setCode(code5);
            empty.setDescription(detail5 + e.getMessage());
        }

        return empty;
    }

    @Override
    public ResponseEmpty updClientState(String dni, String state) {
        ResponseEmpty empty = new ResponseEmpty();

        try {
            ClientDao byDni = clientRepository.findByDni(dni);
            if (byDni != null) {
                byDni.setState(state);
                clientRepository.save(byDni);
                empty.setCode(code6);
                empty.setDescription(detail6);
            } else {
                empty.setCode(code7);
                empty.setDescription(detail7);
            }
        } catch (Exception e) {
            empty.setCode(code7);
            empty.setDescription(detail7 + e.getMessage());
        }

        return empty;
    }
}
