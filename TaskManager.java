package group.lsg.resultinvestmentapp.Class;

public class TaskManager {

    public static int QUERY_UPDATE_TASK = 0;

    private static TaskManager ourInstance = new TaskManager();

    public static TaskManager getInstance() {
        return ourInstance;
    }

    private TaskManager() {
    }
}

