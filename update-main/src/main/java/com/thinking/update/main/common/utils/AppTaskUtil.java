package com.thinking.update.main.common.utils;

import com.thinking.update.main.common.enums.AppLockEnum;
import com.thinking.update.main.common.enums.AppUpdateStateEnum;
import com.thinking.update.main.common.enums.TaskStateEnum;
import com.thinking.update.main.dao.AppDao;
import com.thinking.update.main.dao.TaskDao;
import com.thinking.update.main.dao.TaskDetailDao;
import com.thinking.update.main.domain.entity.App;
import com.thinking.update.main.domain.entity.Task;
import com.thinking.update.main.domain.entity.TaskDetail;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author Administrator
 * @create 2018/6/7
 */
public class AppTaskUtil {

    private static BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
    private static ExecutorService executorService = new ThreadPoolExecutor(1,1,
            1L,TimeUnit.SECONDS,blockingQueue, (ThreadFactory) Thread::new);
    public static void checkAppInTask(App app) {
        executorService.submit(() -> {
            TaskDao taskDao = SpringContextHolder.getBean(TaskDao.class);
            TaskDetailDao taskDetailDao = SpringContextHolder.getBean(TaskDetailDao.class);
            AppDao appDao = SpringContextHolder.getBean(AppDao.class);
            // appId相同的Task
            List<TaskDetail> taskAppIdIsSame = taskDetailDao.selectRunningTaskDetailByAppId(app.getId());
            // 对正在进行的任务进行统计，更新完成数量以及比例
            taskAppIdIsSame.forEach(taskDetail -> {
                TaskDetail taskDetailParam = new TaskDetail();
                taskDetailParam.setTaskId(taskDetail.getTaskId());
                List<TaskDetail> taskDetails = taskDetailDao.selectTaskDetailByObj(taskDetailParam);
                long finishedNumber = appDao.getCountByObjAndTaskDetails(
                        App.builder().updateState(AppUpdateStateEnum.FINISHED.getValue()).build(), taskDetails);
                Task task = taskDao.selectTaskById(taskDetail.getTaskId());
                task.setFinishedNumber(Math.toIntExact(finishedNumber));
                double percent = finishedNumber/task.getAppNumber();
                task.setPercent(percent);
                if (percent == 1.0) {
                    task.setState(TaskStateEnum.FINISHED.getValue());
                    List<App> finishedApps = appDao.getByObjAndTaskDetails(App.builder().updateState(
                            AppUpdateStateEnum.FINISHED.getValue()).build(), taskDetails);
                    finishedApps.parallelStream().forEach(app1 -> app1.setIsLock(AppLockEnum.NO_LOCK.getValue()));
                    appDao.batchUpdate(finishedApps);
                } else {
                    task.setState(TaskStateEnum.NO_FINISHED.getValue());
                }
                taskDao.updateNonEmptyTaskById(task);
            });
        });
    }
}
