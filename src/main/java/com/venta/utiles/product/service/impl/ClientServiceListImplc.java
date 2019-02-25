package com.venta.utiles.product.service.impl;

import com.venta.utiles.product.business.output.ClientResponse;
import com.venta.utiles.product.entity.dao.ClientDao;
import com.venta.utiles.product.repository.ClientRepository;
import com.venta.utiles.product.service.ClientServiceList;
import com.venta.utiles.product.util.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ClientResponse> getClients(String state) {
        List<ClientResponse> list = new ArrayList<>();
        ClientResponse response = new ClientResponse();
        try {
            List<ClientDao> byDni = clientRepository.findByState(state);
            if (byDni != null && !byDni.isEmpty()) {
                for (ClientDao dao : byDni) {
                    response = responseMapper.responseMapper(dao);
                    list.add(response);
                }
            } else {
                response.setCode("MS0001");
                response.setDescription("Estado ingresado no exite");
                list.add(response);
            }
        } catch (Exception e) {
            response.setCode("MS0001");
            response.setDescription("Error al realizar busqueda por estado");
            list.add(response);
        }

        return list;
    }
}
