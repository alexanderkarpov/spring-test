package com.example.springtest.persistence;

import com.example.springtest.model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alexander on 12/25/15.
 */
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
