package org.example.app.task.logic;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.app.task.common.TaskListEto;
import org.example.app.task.domain.TaskListEntity;
import org.example.app.task.domain.TaskListRepository;

@Named
@Transactional
public class UcSaveTaskList {

  @Inject
  TaskListRepository taskRepository;

  @Inject
  TaskListMapper taskMapper;

  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_TASK)
  public TaskListEto save(TaskListEto task) {

    TaskListEntity entity = this.taskMapper.toEntity(task);
    entity = this.taskRepository.save(entity);
    return this.taskMapper.toEto(entity);
  }

}
