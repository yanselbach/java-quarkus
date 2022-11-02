package org.example.app.task.common;

import org.example.app.general.common.ApplicationEntity;

import java.time.LocalDateTime;

/**
 * {@link ApplicationEntity} for a single task item.
 */
public interface TaskItem extends ApplicationEntity {

  /**
   * @return the title of this task item. Gives a brief summary to describe what to do or buy.
   */
  String getTitle();

  /**
   * @param title new value of {@link #getTitle()}.
   */
  void setTitle(String title);

  /**
   * @return the {@link TaskState} of this item.
   */
  TaskState getState();

  /**
   * @param state the new value of {@link #getState()}.
   */
  void setState(TaskState state);

  Long getTaskListId();

  void setTaskListId(Long taskListId);

  LocalDateTime getDeadline();

  void setDeadline(LocalDateTime deadline);
}
