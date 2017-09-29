package CSDN.example;

/**
 * 抽象成绩操作类：目标接口
 *
 * Created by yrd on 2017/9/28.
 */
public interface ScoreOperation {

    int[] sort(int[] array);    //成绩排序
    int search(int[] array, int key);   //成绩查找

}
