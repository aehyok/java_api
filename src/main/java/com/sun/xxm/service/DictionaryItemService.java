package com.sun.xxm.service;

import com.sun.xxm.dao.DictionaryItemRepository;
import com.sun.xxm.model.DictionaryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryItemService implements IDictionaryItemService {

    @Autowired
    private DictionaryItemRepository dictionaryItemRepository;

    @Override
    public List<DictionaryItem> getDictionaryItems() {
//        return dictionaryItemRepository.findByParentId();
        return dictionaryItemRepository.findAll();
    }
}
