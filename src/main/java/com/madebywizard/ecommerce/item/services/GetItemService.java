package com.madebywizard.ecommerce.item.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.ItemNotFoundException;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetItemService implements Query<Integer, ItemDTO> { // Input: item id, Output: ItemDTO

    private final ItemRepository itemRepository;

    public GetItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public ResponseEntity<ItemDTO> execute(Integer input) {
        Optional<Item> itemOptional = itemRepository.findById(input);
        if (itemOptional.isPresent()) {
            return ResponseEntity.ok(new ItemDTO(itemOptional.get()));
        }

        throw new ItemNotFoundException(ErrorMessages.ITEM_NOT_FOUND.getMessage());
    }
}
