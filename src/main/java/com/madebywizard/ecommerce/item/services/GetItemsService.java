package com.madebywizard.ecommerce.item.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// temporarily, input is void and output is a list of userDTO.
public class GetItemsService implements Query<Void, List<ItemDTO>> { // Input: nothing, Output: List of ItemDTO

    private final ItemRepository itemRepository;

    public GetItemsService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<List<ItemDTO>> execute(Void input) {

        List<Item> items = itemRepository.findAll();
        List<ItemDTO> itemDTOS = items.stream().map(ItemDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(itemDTOS);
    }
}
