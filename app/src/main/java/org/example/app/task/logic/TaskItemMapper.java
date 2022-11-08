package org.example.app.task.logic;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.domain.TaskItemEntity;
import org.mapstruct.Mapper;

/**
 * {@link Mapper} for {@link org.example.app.task.common.TaskItem}.
 */
@Mapper(componentModel = "cdi")
public interface TaskItemMapper {

  /**
   * @param task the {@link TaskItemEntity} to map.
   * @return the mapped {@link TaskItemEto}.
   */
  TaskItemEto toEto(TaskItemEntity task);

  /**
   * @param task the {@link TaskItemEto} to map.
   * @return the mapped {@link TaskItemEntity}.
   */
  TaskItemEntity toEntity(TaskItemEto task);
}