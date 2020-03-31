package ps.execute;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import ps.model.Table;
import ps.model.tableIMPL.GameTable;


@Component
public class TaskToExecute {

    private final Logger logger = LoggerFactory.getLogger(TaskToExecute.class);

    @Autowired
    private TaskExecutor executors;


    @Autowired
    private Table table;


    public void executeTASK() {
        // executors=new SimpleAsyncTaskExecutor();
       // for (int i = 0; i < 10; i++) {
            executors.execute(() ->
                    table.game()
            );
       // }
    }


}
