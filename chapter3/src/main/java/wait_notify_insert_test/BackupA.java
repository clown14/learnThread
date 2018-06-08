package wait_notify_insert_test;

public class BackupA extends Thread {
    private DBTools dbTools;

    @Override
    public void run() {
        dbTools.backupA();
    }

    public BackupA(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }
}



