package org.example.app.task.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/task")
public class TaskService {

    @Inject
    private UcFindTaskList ucFindTaskList;
    // ...

    @GET
    @Path("/list/{id}")
    public TaskListEto findTaskList(@PathParam("id") Long id) {

        TaskListEto task = this.ucFindTaskList.findById(id);
        if (task == null) {
            throw new NotFoundException("TaskList with id " + id + " does not exist.");
        }
        return task;
    }
    // ...

    @DELETE
    @Path("/list/{id}")
    public TaskListEto deleteTaskList(@PathParam("id") Long id) {

        TaskListEto task = this.ucDeleteTaskList.deleteById(id);
        if (task == null) {
            throw new NotFoundException("TaskList with id " + id + " does not exist.");
        }
        return task;
    }

    @GET
    @Path("/list-with-items/{id}")
    public TaskListEto findTaskListWithItems(@PathParam("id") Long id) {

        TaskListEto task = this.ucFindTaskListWithItems.findById(id);
        if (task == null) {
            throw new NotFoundException("TaskList with id " + id + " does not exist.");
        }
        return task;
    }

    @POST
    @Path("/list")
    public TaskListEto saveTask(@PathParam("id") Long id) {

        TaskListEto task = this.ucSaveTask.saveById(id);
        if (task == null) {
            throw new NotFoundException("TaskList with id " + id + " does not exist.");
        }
        return task;
    }

    @GET
    @Path("/item/{id}")
    public TaskListEto findTaskItem(@PathParam("id") Long id) {

        TaskListEto task = this.ucFindTaskItem.findById(id);
        if (task == null) {
            throw new NotFoundException("TaskList with id " + id + " does not exist.");
        }
        return task;
    }

    @DELETE
    @Path("/item/{id}")
    public TaskListEto deleteTaskItem(@PathParam("id") Long id) {

        TaskListEto task = this.ucDeleteTaskItem.deleteById(id);
        if (task == null) {
            throw new NotFoundException("TaskList with id " + id + " does not exist.");
        }
        return task;
    }

    @POST
    @Path("/item")
    public TaskListEto saveTaskItem(@PathParam("id") Long id) {

        TaskListEto task = this.ucSaveTaskItem.saveById(id);
        if (task == null) {
            throw new NotFoundException("TaskList with id " + id + " does not exist.");
        }
        return task;
    }
}
