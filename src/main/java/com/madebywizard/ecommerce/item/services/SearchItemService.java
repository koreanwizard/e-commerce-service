package com.madebywizard.ecommerce.item.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchItemService implements Query<String, List<ItemDTO>> { // Input: Item's name, Output: List of ItemDTO

    private final ItemRepository itemRepository;

    public SearchItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<List<ItemDTO>> execute(String lastName) {
        return ResponseEntity.ok(itemRepository.findByItemNameContaining(lastName)
                .stream()
                .map(ItemDTO::new)
                .toList());
    }
}
