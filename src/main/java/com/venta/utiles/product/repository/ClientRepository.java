package com.venta.utiles.product.repository;

import com.venta.utiles.product.entity.dao.ClientDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientDao, String> {

    @Async
    @Query("SELECT v FROM ClientDao v where v.dni = :dni")
    ClientDao findByDni(@Param("dni") String dni);

}
