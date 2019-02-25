package com.venta.utiles.product.service;

import com.venta.utiles.product.business.output.ClientResponse;
import org.springframework.stereotype.Service;

@Service
public interface ClientServiceList {
    ClientResponse getClient(String dni);
}
