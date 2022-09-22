package org.example.app.task.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.example.app.task.common.TaskListEto;
import org.example.app.task.logic.UcFindTaskList;
import org.example.app.task.logic.UcSaveTaskList;

/**
 * Rest service for {@link org.example.app.task.common.TaskList}.
 */
@Path("/task")
public class TaskService {

  @Inject
  UcFindTaskList ucFindTaskList;

  @Inject
  UcSaveTaskList ucSaveTaskList;

  @GET
  @Path("/list/{id}")
  public TaskListEto findTask(@PathParam("id") Long id) {

    TaskListEto task = this.ucFindTaskList.findById(id);
    if (task == null) {
      throw new NotFoundException("taks with id " + id + " does not exist.");
    }
    return task;
  }

  @POST
  @Path("/list")
  public void saveTask(TaskListEto task) {

    this.ucSaveTaskList.save(task);
  }

}
