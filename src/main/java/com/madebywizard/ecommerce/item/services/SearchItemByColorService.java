package com.madebywizard.ecommerce.item.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchItemByColorService implements Query<String, List<ItemDTO>> {

    private final ItemRepository itemRepository;

    public SearchItemByColorService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<List<ItemDTO>> execute(String itemColor) {
        return ResponseEntity.ok(itemRepository.findByItemColorContainingIgnoreCase(itemColor)
                .stream()
                .map(ItemDTO::new)
                .toList());
    }
}
