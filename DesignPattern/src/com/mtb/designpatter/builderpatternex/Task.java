package com.mtb.designpatter.builderpatternex;

import java.util.Date;

/**
 * @author MithileshB
 * @created 14/06/2020 - 8:38 PM
 * @project DesignPattern
 */
public class Task {

    private final long id;
    private String summary = "";
    private String description = "";
    private boolean done = false;
    private Date dueDate;

    public Task(long id){
        this.id=id;
    }

    public Task(long id,String summary,String description,boolean done,Date dueDate){
            this.id=id;
            this.summary=summary;
            this.description=description;
            this.done=done;
            this.dueDate=dueDate;
    }

    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", dueDate=" + dueDate +
                '}';
    }
}

class TaskBuilder{
    private final long id;
    private String summary = "";
    private String description = "";
    private boolean done = false;
    private Date dueDate;

    public TaskBuilder(long id){
        this.id=id;
    }

    public TaskBuilder setSummary(String summary) {
        this.summary = summary;
        return this;
    }
    public TaskBuilder setDescription(String description){
        this.description=description;
        return this;
    }

    public TaskBuilder setDone(boolean done) {
        this.done = done;
        return this;
    }

    public TaskBuilder setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Task build(){
        return new Task(id,summary,description,done,dueDate);
    }
}

class TaskBuilderDemo{
    public static void main(String[] args) {
        Task task=new TaskBuilder(1)
                .setSummary("Task Summary")
                .setDescription("Task 1")
                .setDone(true)
                .setDueDate(new Date())
                .build();
        System.out.println(task);
    }
}