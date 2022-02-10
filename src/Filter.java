import java.util.ArrayList;
import java.util.List;

public class Filter {
    private int f;
    Logger logger = Logger.get();

    public Filter(int f) {
        this.f = f;
    }

    public List<Integer> filterOut(List<Integer> list) {
//        return list.stream().filter(value -> value >= f).toList();
        List filterList = new ArrayList<>();
        int count = 0;
        for (int x : list) {
            if (x < f) {
                logger.log("Число " + x + " не проходит.");
            } else {
                filterList.add(x);
                count++;
                logger.log("Число " + x + " добавлено.");
            }
        }
        logger.log("Прошло фильтр " + count + " элементов из " + list.size());
        return filterList;
    }
}
