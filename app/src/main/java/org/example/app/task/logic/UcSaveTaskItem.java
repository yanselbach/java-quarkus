package org.example.app.task.logic;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.domain.TaskItemEntity;
import org.example.app.task.domain.TaskItemRepository;

/**
 * Use-Case to save {@link org.example.app.task.common.TaskItem}s.
 */
@Named
@Transactional
public class UcSaveTaskItem {

  @Inject
  TaskItemRepository taskRepository;

  @Inject
  TaskItemMapper taskMapper;

  /**
   * @param item the {@link TaskItemEto} to save.
   * @return the {@link TaskItemEntity#getId() primary key} of the saved {@link TaskItemEntity}.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_TASK_ITEM)
  public Long save(TaskItemEto item) {

    TaskItemEntity entity = this.taskMapper.toEntity(item);
    entity = this.taskRepository.save(entity);
    return entity.getId();
  }

}
