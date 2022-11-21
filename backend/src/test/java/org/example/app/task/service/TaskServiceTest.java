package org.example.app.task.service;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

/**
 * Test of {@link TaskService}.
 */
@QuarkusTest
public class TaskServiceTest extends Assertions {

  /** Test of {@link TaskService#findTaskList(Long)}. */
  @Test
  public void testFindTaskList() {

    given().when().get("/task/list/1").then().statusCode(200)
        .body(jsonEquals("{\"id\":1,\"version\":0,\"title\":\"Shopping List\"}"));
  }

  /** Test of {@link TaskService#findTaskList(Long)}. */
  @Test
  public void testFindTaskItem() {

    given().when().get("/task/item/12").then().statusCode(200).body(jsonEquals(
        "{\"id\":12,\"version\":0,\"title\":\"Butter\",\"completed\":false,\"starred\":true,\"taskListId\":1,\"deadline\":null}"));
  }

}
