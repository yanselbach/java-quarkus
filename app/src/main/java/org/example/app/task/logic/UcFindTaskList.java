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
  TaskListRepository taskRepository;

  @Inject
  TaskListMapper taskMapper;

  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_TASK)
  public TaskListEto findById(Long taskId) {

    Optional<TaskListEntity> task = this.taskRepository.findById(taskId);
    if (task.isPresent()) {
      return this.taskMapper.toEto(task.get());
    }
    return null;
  }

}
