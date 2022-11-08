package org.example.app.task.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

/**
 * Test of {@link TaskItemRepository}.
 */
@QuarkusTest
public class TaskItemRepositoryTest extends Assertions {

  @Inject
  private TaskItemRepository taskItemRepository;

  @Test
  public void testFindByFlags() {

    List<TaskItemEntity> hits = this.taskItemRepository.findByFlags(false, true);
    // testdata currently not working due to hibernate drop-and-create
    // assertThat(hits).hasSize(xxx);
  }

  @Test
  public void testFindByDeadline() {

    LocalDateTime deadline = LocalDateTime.of(2022, 12, 22, 23, 59);
    List<TaskItemEntity> hits = this.taskItemRepository.findByDeadline(deadline);
    // testdata currently not working due to hibernate drop-and-create
    // assertThat(hits).hasSize(xxx);
  }

}
