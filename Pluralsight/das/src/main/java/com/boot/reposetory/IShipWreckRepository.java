package com.boot.reposetory;

import com.boot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mohammad on 11/20/2016.
 */
public interface IShipWreckRepository extends JpaRepository<Shipwreck, Long> {
}
