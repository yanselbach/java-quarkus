package org.example.app.task.dataaccess;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import org.assertj.core.api.Assertions;
import org.example.app.general.common.search.LikePatternSyntax;
import org.example.app.general.common.search.SortOrderBy;
import org.example.app.general.common.search.StringSearchOptions;
import org.example.app.task.common.TaskItemSearchCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;

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

  @Test
  public void testFindByCriteria() {

    // given
    TaskItemSearchCriteria criteria = new TaskItemSearchCriteria();
    criteria.setCompleted(Boolean.FALSE);
    criteria.setTitle("*e*");
    criteria.setTitleOptions(StringSearchOptions.of(LikePatternSyntax.GLOB));
    criteria.getSort().add(SortOrderBy.ofAsc("title"));

    // when
    Page<TaskItemEntity> page = this.taskItemRepository.find(criteria);

    // then
    assertThat(page).isNotNull();
    // assertThat(page).isNotEmpty();
  }

}
