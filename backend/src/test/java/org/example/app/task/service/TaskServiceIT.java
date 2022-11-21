package org.example.app.task.service;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
public class TaskServiceIT {
  // Execute the same tests but in packaged mode.

  @Test
  void shouldAllowCreatingANewTaskList() {

  }

  @Test
  void shouldAllowAddingATaskToATaskList() {

  }

  @Test
  void shouldAllowRetrievingATaskListWithTaskItems() {

  }

  @Test
  void shouldAllowDeletingATaskListCompletely() {

  }

  //
  // /** Test of {@link TaskService#findTaskList(Long)}. */
  // @Test
  // public void testFindTaskList() {
  //
  // given().when().get("/task/list/1").then().statusCode(200)
  // .body(is("{\"id\":1,\"version\":0,\"title\":\"Shopping List\"}"));
  // }
  //
  // /** Test of {@link TaskService#findTaskList(Long)}. */
  // @Test
  // public void testFindTaskItem() {
  //
  // given().when().get("/task/item/11").then().statusCode(200).body(is(
  // "{\"id\":11,\"version\":0,\"title\":\"Milk\",\"completed\":false,\"starred\":true,\"taskListId\":1,\"deadline\":null}"));
  // }
}
