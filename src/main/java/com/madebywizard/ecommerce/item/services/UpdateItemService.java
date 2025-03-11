package com.madebywizard.ecommerce.item.services;

import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.exceptions.ItemNotFoundException;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.UpdateItemCommand;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import com.madebywizard.ecommerce.item.validators.ItemValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateItemService implements Command<UpdateItemCommand, ItemDTO> { // Input: UpdateItemCommand, Output: ItemDTO


    private final ItemRepository itemRepository;

    public UpdateItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<ItemDTO> execute(UpdateItemCommand command) {
        /*
        validate new user's information by using 'UserValidator' 'execute' method by passing current user object
        'save' JpaRepository method saves but also updates the data
         */

        Optional<Item> itemOptional = itemRepository.findById(command.getId());
        if (itemOptional.isPresent()) {
            Item item = command.getItem();
            item.setId(command.getId());

            ItemValidator.execute(item); // validator

            itemRepository.save(item);
            return ResponseEntity.ok(new ItemDTO(item));
        }

        throw new ItemNotFoundException();
    }
}
