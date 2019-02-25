package com.venta.utiles.expose.web;

import com.venta.utiles.product.business.input.Client;
import com.venta.utiles.product.business.output.ClientResponse;
import com.venta.utiles.product.business.output.ResponseEmpty;
import com.venta.utiles.product.service.ClientServiceCreate;
import com.venta.utiles.product.service.ClientServiceList;
import com.venta.utiles.product.service.ClientServiceUpd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/sell/utils/v1")
public class Controller {

    @Autowired
    ClientServiceList serviceList;

    @Autowired
    ClientServiceCreate serviceCreate;

    @Autowired
    ClientServiceUpd serviceUpd;


    @GetMapping(
            value = "/list/client/{dni}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ClientResponse getClient(@PathVariable("dni") String dni) {
        return serviceList.getClient(dni);
    }

    @PostMapping(
            value = "/create/client", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEmpty createClient(@RequestBody Client client) {
        return serviceCreate.addClient(client);
    }

    @PostMapping(
            value = "/update/client", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEmpty updateClient(@RequestBody Client client) {
        return serviceUpd.updClient(client);
    }

    @PostMapping(
            value = "/updateState/client", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEmpty updateStateClient(@RequestParam("dni") String dni, @RequestParam("state") String state) {
        return serviceUpd.updClientState(dni, state);
    }

}
