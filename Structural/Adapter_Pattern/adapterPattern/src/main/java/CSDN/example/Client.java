package CSDN.example;

/**
 * Created by yrd on 2017/9/28.
 */
public class Client {

    public static void main(String[] args) {
        ScoreOperation operation = (ScoreOperation) new OperationAdapter();
        int scores[] = {84,76,50,69,90,91,88,96};
        int[] result;
        int score;

        System.out.println("成绩排序结果：");
        result = operation.sort(scores);

        for (int i : scores) {
            System.out.print(i + ",");
        }
        System.out.println();

        System.out.println("查找成绩90：");
        score = operation.search(result, 90);
        if (score != -1) {
            System.out.println("找到成绩90");
        } else {
            System.out.println("未找到成绩90");
        }
    }
}
