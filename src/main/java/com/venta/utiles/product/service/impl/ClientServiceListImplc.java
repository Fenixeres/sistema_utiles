package com.venta.utiles.product.service.impl;

import com.venta.utiles.product.business.output.ClientResponse;
import com.venta.utiles.product.entity.dao.ClientDao;
import com.venta.utiles.product.repository.ClientRepository;
import com.venta.utiles.product.service.ClientServiceList;
import com.venta.utiles.product.util.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceListImplc implements ClientServiceList {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ResponseMapper responseMapper;

    @Override
    public ClientResponse getClient(String dni) {
        ClientResponse response = new ClientResponse();
        try {
            ClientDao byDni = clientRepository.findByDni(dni);
            if (byDni != null) {
                response = responseMapper.responseMapper(byDni);
            } else {
                response.setCode("MS0001");
                response.setDescription("Error al realizar busqueda por dni");
            }
        } catch (Exception e) {
            response.setCode("MS0001");
            response.setDescription("Error al realizar busqueda por dni");
        }

        return response;
    }
}
