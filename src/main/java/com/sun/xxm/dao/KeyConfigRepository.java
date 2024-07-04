package com.sun.xxm.dao;

import com.sun.xxm.model.KeyConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyConfigRepository extends JpaRepository<KeyConfig, Long> {
}
