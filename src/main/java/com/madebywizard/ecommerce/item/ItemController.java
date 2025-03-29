package com.madebywizard.ecommerce.item;

 import com.madebywizard.ecommerce.item.model.UpdateItemCommand;
 import com.madebywizard.ecommerce.item.model.Item;
 import com.madebywizard.ecommerce.item.model.ItemDTO;
 import com.madebywizard.ecommerce.item.services.*;

 import org.springframework.http.ResponseEntity;
 import org.springframework.security.access.prepost.PreAuthorize;
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

    private final SearchItemByNameService searchItemByNameService;

    private final SearchItemByColorService searchItemByColorService;


    public ItemController(CreateItemService createItemService,
                          GetItemsService getItemsService,
                          GetItemService getItemService,
                          UpdateItemService updateItemService,
                          DeleteItemService deleteItemService,
                          SearchItemByNameService searchItemByNameService,
                          SearchItemByColorService searchItemByColorService) {

        this.createItemService = createItemService;
        this.getItemsService = getItemsService;
        this.getItemService = getItemService;
        this.updateItemService = updateItemService;
        this.deleteItemService = deleteItemService;
        this.searchItemByNameService = searchItemByNameService;
        this.searchItemByColorService = searchItemByColorService;
    }



    // ONLY ADMINS CAN DO THESE OPERATIONS
    // -----------------------------------------------------------------------------------------------------------

    @PostMapping("/item")
    public ResponseEntity<ItemDTO> createOneItem(@RequestBody Item item) {
        return createItemService.execute(item);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<ItemDTO> updateOneItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        // passing both id and 'Item' object
        return updateItemService.execute(new UpdateItemCommand(id, item));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> deleteOneItem(@PathVariable("id") Integer id) {
        return deleteItemService.execute(id);
    }
    // -----------------------------------------------------------------------------------------------------------










    // BOTH ADMIN AND USERS CAN DO THESE OPERATIONS (AUTHENTICATION IS NOT REQUIRED)
    // -----------------------------------------------------------------------------------------------------------
    // add this if headers needed: produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/items")
    public ResponseEntity<List<ItemDTO>> getEveryItem() {
        return getItemsService.execute(null);
    }


    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDTO> getOneItem(@PathVariable("id") Integer id) {
        return getItemService.execute(id);
    }


    // these GET HTTP requests can be combined by adding filters into the request parameter
    // 필터 넣고 합처야 하는게 맞는데 일단은 그냥 가자
    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/items/search/name")
    public ResponseEntity<List<ItemDTO>> searchItemByName(@RequestParam("itemName") String itemName) {
        return searchItemByNameService.execute(itemName);
    }
    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/items/search/color")
    public ResponseEntity<List<ItemDTO>> searchItemByColor(@RequestParam("itemColor") String itemColor) {
        return searchItemByColorService.execute(itemColor);
    }
    // -----------------------------------------------------------------------------------------------------------
}
