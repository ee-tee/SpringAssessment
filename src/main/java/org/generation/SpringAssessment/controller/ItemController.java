package org.generation.SpringAssessment.controller;

import org.generation.SpringAssessment.controller.dto.ItemDto;
import org.generation.SpringAssessment.repository.entity.Item;
import org.generation.SpringAssessment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//Implement the ItemController to include an ItemService interface for REST API implementation
//Display all records from the database (Note: add @CrossOrigin for all Mapping annotations)

@RestController
@RequestMapping("/item")
public class ItemController {

    final ItemService itemService;

    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    //REST API Endpoints

    //1) Create an API endpoint for GET HTTP Request from the client
    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();   //calling the itemService all() method through the interface to return all items
    }

    @CrossOrigin
    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    //2) Create an API endpoint for DELETE

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    //3) Create an API endpoint for ADD

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="task", required = true) String task,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="owner", required = true) String owner,
                       @RequestParam(name="startDate", required = true) String startDate,
                       @RequestParam(name="targetDate", required = true) String targetDate ) throws IOException
    {
        ItemDto itemDto = new ItemDto(task, description, owner, startDate, targetDate);
        itemService.save(new Item(itemDto));
    }

}

