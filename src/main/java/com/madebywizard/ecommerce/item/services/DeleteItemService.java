package com.madebywizard.ecommerce.item.services;

import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.ItemNotFoundException;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteItemService implements Command<Integer, Void> { // Input: item's id, Output: nothing (void)

    private final ItemRepository itemRepository;

    public DeleteItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isPresent()) {
            itemRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new ItemNotFoundException(ErrorMessages.ITEM_NOT_FOUND.getMessage());
    }
}
