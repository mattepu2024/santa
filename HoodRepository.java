package com.orders.cristmas.santa.repository;

import com.orders.cristmas.santa.entities.HoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoodRepository extends JpaRepository<HoodEntity, Long> {

}
