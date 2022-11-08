package org.example.app.task.logic;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.app.task.common.TaskListEto;
import org.example.app.task.domain.TaskListEntity;
import org.example.app.task.domain.TaskListRepository;

/**
 * Use-Case to find {@link TaskListEntity task-lists}.
 */
@Named
@Transactional
public class UcFindTaskList {

  @Inject
  TaskListRepository taskListRepository;

  @Inject
  TaskListMapper taskMapper;

  /**
   * @param listId the {@link TaskListEntity#getId() primary key} of the {@link TaskListEntity} to find.
   * @return the {@link TaskListEto} with the given {@link TaskListEto#getId() primary key} or {@code null} if not
   *         found.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_TASK_LIST)
  public TaskListEto findById(Long listId) {

    Optional<TaskListEntity> task = this.taskListRepository.findById(listId);
    return task.map(taskListEntity -> this.taskMapper.toEto(taskListEntity)).orElse(null);
  }

}
