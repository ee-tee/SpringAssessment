package org.generation.SpringAssessment.repository.entity;

import org.generation.SpringAssessment.controller.dto.ItemDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Need to have the same attributes as the SQL table
    private Integer id;
    private String task;
    private String description;
    private String owner;
    private String startDate;
    private String targetDate;

    public Item() {}

    public Item(ItemDto itemDto ) {
        this.task = itemDto.getTask();
        this.description = itemDto.getDescription();
        this.owner = itemDto.getOwner();
        this.startDate = itemDto.getStartDate();
        this.targetDate = itemDto.getTargetDate();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", task='" + task + '\'' + ", description='" + description + '\'' + ", owner='"
                + owner + '\'' + ", startDate='" + startDate + '\'' + ", targetDate='" + targetDate + '\'' + '}';
    }

}
