package org.example.app.task.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.example.app.task.common.TaskItemEto;
import org.example.app.task.common.TaskListCto;
import org.example.app.task.common.TaskListEto;

/**
 * Rest service API to call the service as client.
 */
@Path("/task")
@RegisterRestClient
@SuppressWarnings("javadoc")
public interface TaskServiceApi {

  @POST
  @Path("/list")
  Response saveTask(TaskListEto taskList);

  @GET
  @Path("/list/{id}")
  TaskListEto findTaskList(Long id);

  @GET
  @Path("/list-with-items/{id}")
  TaskListCto findTaskListWithItems(@PathParam("id") Long id);

  @DELETE
  @Path("/list/{id}")
  void deleteTaskList(@PathParam("id") Long id);

  @POST
  @Path("/item")
  Response saveTaskItem(TaskItemEto item);

  @GET
  @Path("/item/{id}")
  TaskItemEto findTaskItem(@PathParam("id") Long id);

  @DELETE
  @Path("/item/{id}")
  void deleteTaskItem(@PathParam("id") Long id);

}
