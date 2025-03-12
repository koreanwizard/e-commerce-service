package com.madebywizard.ecommerce.item;


 import com.madebywizard.ecommerce.item.model.UpdateItemCommand;
 import com.madebywizard.ecommerce.item.model.Item;
 import com.madebywizard.ecommerce.item.model.ItemDTO;
 import com.madebywizard.ecommerce.item.services.*;
 import org.springframework.http.MediaType;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.List;


@RestController
public class ItemController {

    private final CreateItemService createItemService;

    private final GetItemsService getItemsService;

    private final GetItemService getItemService;

    private final UpdateItemService updateItemService;

    private final DeleteItemService deleteItemService;

    private final SearchItemService searchItemService;

    private final SearchItemByColorService searchItemByColorService;


    public ItemController(CreateItemService createItemService,
                          GetItemsService getItemsService,
                          GetItemService getItemService,
                          UpdateItemService updateItemService,
                          DeleteItemService deleteItemService,
                          SearchItemService searchItemService,
                          SearchItemByColorService searchItemByColorService) {

        this.createItemService = createItemService;
        this.getItemsService = getItemsService;
        this.getItemService = getItemService;
        this.updateItemService = updateItemService;
        this.deleteItemService = deleteItemService;
        this.searchItemService = searchItemService;
        this.searchItemByColorService = searchItemByColorService;
    }



    // ONLY ADMINS CAN DO THESE OPERATIONS
    // -----------------------------------------------------------------------------------------------------------

    @PostMapping("/item")
    public ResponseEntity<ItemDTO> createSingeItem(@RequestBody Item item) {
        return createItemService.execute(item);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<ItemDTO> updateSingleItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        // passing both id and 'Item' object
        return updateItemService.execute(new UpdateItemCommand(id, item));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> deleteSingleItem(@PathVariable("id") Integer id) {
        return deleteItemService.execute(id);
    }
    // -----------------------------------------------------------------------------------------------------------










    // BOTH ADMIMS AND USERS CAN DO THESE OPERATIONS
    // -----------------------------------------------------------------------------------------------------------


    // adding headers (type of media that item receive)
    @GetMapping(value="/items", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ItemDTO>> getEveryItem() {
        return getItemsService.execute(null);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ItemDTO> getSingleItem(@PathVariable("id") Integer id) {
        return getItemService.execute(id);
    }

    @GetMapping("/item/search/name")
    public ResponseEntity<List<ItemDTO>> searchItemByItemName(@RequestParam("itemName") String itemName) {
        return searchItemService.execute(itemName);
    }

    @GetMapping("/item/search/color")
    public ResponseEntity<List<ItemDTO>> searchItemByItemColor(@RequestParam("itemColor") String itemColor) {
        return searchItemByColorService.execute(itemColor);
    }


    // -----------------------------------------------------------------------------------------------------------
}
