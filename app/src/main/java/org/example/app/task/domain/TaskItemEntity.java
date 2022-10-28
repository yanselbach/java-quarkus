package org.example.app.task.domain;

import org.example.app.general.domain.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskItem;
import org.example.app.task.common.TaskState;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * {@link TaskItem} implementation as {@link ApplicationPersistenceEntity}.
 */
@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity implements TaskItem {

  private String title;

  private TaskState state;

  @ManyToOne
  @JoinColumn(name = "task_list_id")
  private TaskListEntity taskListEntity;

  public TaskListEntity getTaskListEntitys() {
    return taskListEntity;
  }

  public void setTaskListEntitys(TaskListEntity taskListEntity) {
    this.taskListEntity = taskListEntity;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public TaskState getState() {
    return this.state;
  }

  @Override
  public void setState(TaskState state) {
    this.state = state;
  }

  @Override
  @Transient  // ToDo: Do we need this with field annotations?
  public Long getTaskListId() {

    if (this.taskListEntity == null) {
      return null;
    }
    return this.taskListEntity.getId();
  }

  @Override
  public void setTaskListId(Long taskListId) {

    if (taskListId == null) {
      this.taskListEntity = null;
    } else {
      TaskListEntity taskListEntity = new TaskListEntity();
      taskListEntity.setId(taskListId);
      this.taskListEntity = taskListEntity;
    }
  }
}
