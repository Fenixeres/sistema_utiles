package com.venta.utiles.product.service;

import com.venta.utiles.product.business.output.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientServiceList {
    ClientResponse getClient(String dni);

    List<ClientResponse> getClients(String state);
}
