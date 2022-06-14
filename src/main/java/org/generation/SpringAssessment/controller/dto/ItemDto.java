package org.generation.SpringAssessment.controller.dto;

public class ItemDto {

    private String task;
    private String description;
    private String owner;
    private String startDate;
    private String targetDate;

    public ItemDto(String task, String description, String owner, String startDate, String targetDate )
    {
        this.task = task;
        this.description = description;
        this.owner = owner;
        this.startDate = startDate;
        this.targetDate = targetDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}

