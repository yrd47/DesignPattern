package multiton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yrd on 2017/12/1.
 */
public class Dice {

    private static final Dice dice1 = new Dice();
    private static final Dice dice2 = new Dice();
    private static List<Dice> list = new ArrayList<Dice>();
    private static final int maxCount = 2;  //最多实例数
    static {
        list.add(dice1);
        list.add(dice2);
    }

    private Dice() {}

    public static Dice getInstance() {
        Random random = new Random();
        int current = random.nextInt(maxCount);
        return list.get(current);
    }

    public static Dice getInstance(int index) {
        return list.get(index);
    }
}
