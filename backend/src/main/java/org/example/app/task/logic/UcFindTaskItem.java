package org.example.app.task.logic;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.dataaccess.TaskItemRepository;

/**
 * Use-Case to find {@link TaskItemEntity task-items}.
 */
@ApplicationScoped
@Named
@Transactional
public class UcFindTaskItem {

  @Inject
  TaskItemRepository taskItemRepository;

  @Inject
  TaskItemMapper taskItemMapper;

  /**
   * @param itemId the {@link TaskItemEntity#getId() primary key} of the {@link TaskItemEntity} to find.
   * @return the {@link TaskItemEto} with the given {@link TaskItemEto#getId() primary key} or {@code null} if not
   *         found.
   */
  // @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_TASK_ITEM)
  public TaskItemEto findById(Long itemId) {

    Optional<TaskItemEntity> item = this.taskItemRepository.findById(itemId);
    return item.map(entity -> this.taskItemMapper.toEto(entity)).orElse(null);
  }

}
