package org.example.app.task.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.example.app.general.domain.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskItem;
import org.example.app.task.common.TaskState;

/**
 * {@link TaskItem} implementation as {@link ApplicationPersistenceEntity}.
 */
@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity implements TaskItem {

  @Column
  private String title;

  @Column
  private TaskState state;

  @Column
  private LocalDateTime deadline;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LIST_ID")
  private TaskListEntity taskList;

  /**
   * @return the {@link TaskListEntity} owning this task-item.
   */
  public TaskListEntity getTaskList() {

    return this.taskList;
  }

  /**
   * @param taskList the new value of {@link #getTaskList()}.
   */
  public void setTaskList(TaskListEntity taskList) {

    this.taskList = taskList;
  }

  @Override
  public Long getTaskListId() {

    if (this.taskList == null) {
      return null;
    }
    return this.taskList.getId();
  }

  @Override
  public void setTaskListId(Long taskListId) {

    if (taskListId == null) {
      this.taskList = null;
    } else {
      TaskListEntity taskListEntity = new TaskListEntity();
      taskListEntity.setId(taskListId);
      this.taskList = taskListEntity;
    }
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
  public LocalDateTime getDeadline() {

    return this.deadline;
  }

  @Override
  public void setDeadline(LocalDateTime deadline) {

    this.deadline = deadline;
  }

}
