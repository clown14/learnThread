package TwoThreadTransData;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();
    public void add() {
        list.add("高红颜");
    }

    public int size() {
        return list.size();
    }
}
