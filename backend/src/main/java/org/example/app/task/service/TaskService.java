package org.example.app.task.service;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.common.TaskListCto;
import org.example.app.task.common.TaskListEto;
import org.example.app.task.logic.UcDeleteTaskItem;
import org.example.app.task.logic.UcDeleteTaskList;
import org.example.app.task.logic.UcFindTaskItem;
import org.example.app.task.logic.UcFindTaskList;
import org.example.app.task.logic.UcSaveTaskItem;
import org.example.app.task.logic.UcSaveTaskList;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Rest service for {@link org.example.app.task.common.TaskList}.
 */
@Path("/task")
public class TaskService {

  @Inject
  UcFindTaskList ucFindTaskList;

  @Inject
  UcSaveTaskList ucSaveTaskList;

  @Inject
  UcDeleteTaskList ucDeleteTaskList;

  @Inject
  UcFindTaskItem ucFindTaskItem;

  @Inject
  UcSaveTaskItem ucSaveTaskItem;

  @Inject
  UcDeleteTaskItem ucDeleteTaskItem;

  /**
   * @param task the {@link TaskListEto} to save (insert or update).
   */
  @POST
  @Path("/list")
  public void saveTaskList(TaskListEto task) {

    this.ucSaveTaskList.save(task);
  }

  /**
   * @param id the {@link TaskListEto#getId() primary key} of the requested {@link TaskListEto}.
   * @return the {@link TaskListEto} for the given {@code id}.
   */
  @GET
  @Path("/list/{id}")
  public TaskListEto findTaskList(@PathParam("id") Long id) {

    TaskListEto task = this.ucFindTaskList.findById(id);
    if (task == null) {
      throw new NotFoundException("TaskList with id " + id + " does not exist.");
    }
    return task;
  }

  /**
   * @param id the {@link TaskListEto#getId() primary key} of the requested {@link TaskListEto}.
   * @return the {@link TaskListEto} for the given {@code id}.
   */
  @GET
  @Path("/list-with-items/{id}")
  public TaskListCto findTaskListWithItems(@PathParam("id") Long id) {

    TaskListCto task = this.ucFindTaskList.findWithItems(id);
    if (task == null) {
      throw new NotFoundException("TaskList with id " + id + " does not exist.");
    }
    return task;
  }

  /**
   * @param id the {@link TaskListEto#getId() primary key} of the {@link TaskListEto} to delete.
   */
  @DELETE
  @Path("/list/{id}")
  public void deleteTaskList(@PathParam("id") Long id) {

    this.ucDeleteTaskList.delete(id);
  }

  /**
   * @param item the {@link TaskItemEto} to save (insert or update).
   */
  @POST
  @Path("/item")
  public Long saveTaskItem(TaskItemEto item) {

    return this.ucSaveTaskItem.save(item);
  }

  /**
   * @param id the {@link TaskItemEto#getId() primary key} of the {@link TaskItemEto} to find.
   * @return the {@link TaskItemEto} for the given {@code id}.
   */
  @GET
  @Path("/item/{id}")
  public TaskItemEto findTaskItem(@PathParam("id") Long id) {

    TaskItemEto item = this.ucFindTaskItem.findById(id);
    if (item == null) {
      throw new NotFoundException("TaskItem with id " + id + " does not exist.");
    }
    return item;
  }

  /**
   * @param id the {@link TaskItemEto#getId() primary key} of the {@link TaskItemEto} to delete.
   */
  @DELETE
  @Path("/item/{id}")
  public void deleteTaskItem(@PathParam("id") Long id) {

    this.ucDeleteTaskItem.delete(id);
  }

}
