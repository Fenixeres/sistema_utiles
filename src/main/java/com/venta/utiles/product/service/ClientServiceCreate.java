package com.venta.utiles.product.service;

import com.venta.utiles.product.business.input.Client;
import com.venta.utiles.product.business.output.ResponseEmpty;
import org.springframework.stereotype.Service;

@Service
public interface ClientServiceCreate {
    ResponseEmpty addClient(Client client);
}
