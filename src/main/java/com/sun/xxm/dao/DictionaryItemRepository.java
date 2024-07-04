package com.sun.xxm.dao;

import com.sun.xxm.model.DictionaryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryItemRepository extends JpaRepository<DictionaryItem, Long> {
}
