package org.example.app.general.common.security;

public class ApplicationAccessControlConfig {

  public static final String APP_ID = "demo";

  private static final String PREFIX = ""; // APP_ID + ".";

  public static final String PERMISSION_FIND_TASK_LIST = PREFIX + "FindTaskList";

  public static final String PERMISSION_SAVE_TASK_LIST = PREFIX + "SaveTaskList";

  public static final String PERMISSION_DELETE_TASK_LIST = PREFIX + "DeleteTaskList";

  public static final String PERMISSION_FIND_TASK_ITEM = PREFIX + "FindTaskItem";

  public static final String PERMISSION_SAVE_TASK_ITEM = PREFIX + "SaveTaskItem";

  public static final String PERMISSION_DELETE_TASK_ITEM = PREFIX + "DeleteTaskItem";

}
