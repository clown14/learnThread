package wait_notify_insert_test;

public class BackupB extends Thread {
    private DBTools dbTools;

    @Override
    public void run() {
        dbTools.backupB();
    }

    public BackupB(DBTools dbTools) {
        super();
        this.dbTools = dbTools;
    }
}
