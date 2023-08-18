package org.myproject.crm.repository;

import org.myproject.crm.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    long deleteByNameAndEmail(String name, String email);

    long countByName(String name);
}
