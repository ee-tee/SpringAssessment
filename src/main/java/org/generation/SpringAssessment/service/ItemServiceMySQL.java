package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.ItemRepository;
import org.generation.SpringAssessment.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceMySQL implements ItemService {

    //The dependency instance object will be injected through the constructor
    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository) {

        //Injecting an instance object of the CRUDRepository object
        //We are able to make use of this.itemRepository to access the properties and methods from the CRUDRepository object

        this.itemRepository = itemRepository;

    }

    @Override
    public Item save(Item item) {

        //Access the database with the connection and perform Insert query
        return itemRepository.save(item);	//CRUDRepository object

    }

    @Override
    public void delete(int itemId) {

        itemRepository.deleteById(itemId);

    }

    @Override
    public List<Item> all() {

        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;

    }


    @Override
    public Item findById(int itemId) {  //update product info and delete a product

        //item is an object
        Optional<Item> item = itemRepository.findById(itemId);	//cannot be null
        Item itemResponse = item.get();

        return itemResponse;

    }

}
