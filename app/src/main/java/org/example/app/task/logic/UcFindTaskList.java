package org.example.app.task.logic;

import org.example.app.task.common.TaskListEto;
import org.example.app.task.domain.TaskListEntity;
import org.example.app.task.domain.TaskListRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Optional;

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

  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_TASK)
  public TaskListEto findById(Long taskId) {

    Optional<TaskListEntity> task = this.taskListRepository.findById(taskId);
    return task.map(taskListEntity -> this.taskMapper.toEto(taskListEntity)).orElse(null);
  }

}
