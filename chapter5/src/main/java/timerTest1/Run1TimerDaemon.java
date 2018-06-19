package timerTest1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1TimerDaemon {
    private static Timer timer = new Timer(true);
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为："+new Date());
        }
    }

    public static void main(String[] args) {
        try {
            Run1.MyTask task = new Run1.MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2014-12-12 11:55:00";
            Date dateRef = sdf.parse(dateString);
            System.out.println("字符串时间：" + dateRef.toLocaleString() + "当前时间：" +
                    new Date().toLocaleString());
            timer.schedule(task, dateRef);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
