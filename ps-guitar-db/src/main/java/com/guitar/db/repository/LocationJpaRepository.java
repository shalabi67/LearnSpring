package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mshalabi on 27.07.17.
 */
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
}
