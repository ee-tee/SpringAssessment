package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.entity.Item;
import java.util.List;

public interface ItemService {

    //Provide list of all items from the database
    List<Item> all();

    //This method is used for both adding and editing item
    Item save(Item item);

    //Delete item from database - based on item Id
    void delete(int itemId);

    //Read an item from database - based on item Id
    Item findById(int itemId);
}



