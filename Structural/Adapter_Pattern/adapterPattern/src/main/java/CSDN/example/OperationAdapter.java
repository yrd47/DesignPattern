package CSDN.example;

/**
 * 操作适配器：适配器
 *
 * Created by yrd on 2017/9/28.
 */
public class OperationAdapter {

    private QuickSort quickSortObj;
    private BinarySearch binarySearchObj;

    public OperationAdapter() {
        quickSortObj = new QuickSort();
        binarySearchObj = new BinarySearch();
    }

    public int[] sort(int[] array) {
        return quickSortObj.quickSort(array);    //调用适配者类QuickSort的排序方法
    }

    public int search(int[] array, int key) {
        return binarySearchObj.binarySearch(array, key);    //调用适配者类BinarySearch的查找方法
    }

}
