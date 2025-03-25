package com.madebywizard.ecommerce.item;


import com.madebywizard.ecommerce.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByItemNameContainingIgnoreCase(String itemName);

    List<Item> findByItemColorContainingIgnoreCase(String itemColor);

    // use JPQL to create a customized query (if needed)
}
