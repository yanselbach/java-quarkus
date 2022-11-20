package org.example.app.task.logic;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.dataaccess.TaskItemRepository;
import org.example.app.task.dataaccess.TaskListRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 * Use-Case to save {@link org.example.app.task.common.TaskItem}s.
 */
@Named
@Transactional
public class UcSaveTaskItem {

  @Inject
  TaskItemRepository taskItemRepository;

  @Inject
  TaskItemMapper taskItemMapper;

  @Inject
  TaskListRepository taskListRepository;

  /**
   * @param item the {@link TaskItemEto} to save.
   * @return the {@link TaskItemEntity#getId() primary key} of the saved {@link TaskItemEntity}.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_TASK_ITEM)
  public Long save(TaskItemEto item) {

    final TaskItemEntity taskItemEntity = this.taskItemMapper.toEntity(item);
    if (item.getTaskListId() != null) {
      taskListRepository.findById(item.getTaskListId()).ifPresent(taskItemEntity::setTaskList);
    }
    TaskItemEntity savedEntity = this.taskItemRepository.save(taskItemEntity);
    return savedEntity.getId();
  }

}
