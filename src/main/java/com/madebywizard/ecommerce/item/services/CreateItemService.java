package com.madebywizard.ecommerce.item.services;

import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import com.madebywizard.ecommerce.item.validators.ItemValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CreateItemService implements Command<Item, ItemDTO> { // input: Item, output: ItemDTO

    private final ItemRepository itemRepository; // access of the 'Item' repository

    public CreateItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ResponseEntity<ItemDTO> execute(Item item) {
        /*
        validate a new item's information by using 'ItemValidator' 'execute' method by passing current item object
        call 'save' method which is the JpaRepository method,
        and pass the newly saved 'Item' object into the new 'ItemDTO' object
         */

        ItemValidator.validate(item); // validator

        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ItemDTO(savedItem));
    }
}
