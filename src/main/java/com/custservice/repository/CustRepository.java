package com.custservice.repository;

import com.custservice.entity.CustEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustRepository extends JpaRepository<CustEntity,Long> {
}
