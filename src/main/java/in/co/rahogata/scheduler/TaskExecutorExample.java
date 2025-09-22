package in.co.rahogata.scheduler;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class TaskExecutorExample {
	private final TaskExecutor taskExecutor;
	
	public TaskExecutorExample( @Qualifier(AsyncAnnotationBeanPostProcessor.DEFAULT_TASK_EXECUTOR_BEAN_NAME)  TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	
	public void printMessages() {
        for(int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }
}
