package com.venta.utiles.product.repository;

import com.venta.utiles.product.entity.dao.ClientDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientDao, String> {

}
