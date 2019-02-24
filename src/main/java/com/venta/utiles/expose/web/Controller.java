package com.venta.utiles.expose.web;

import com.venta.utiles.product.business.input.Client;
import com.venta.utiles.product.business.output.ResponseEmpty;
import com.venta.utiles.product.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/sell/utils/v1")
public class Controller {

    @Autowired
    ClientService clientService;

    @PostMapping(
            value = "/create/client", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEmpty createClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }
}
