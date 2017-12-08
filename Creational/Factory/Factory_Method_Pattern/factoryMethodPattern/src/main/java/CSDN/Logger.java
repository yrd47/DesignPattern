package CSDN;

/**
 * Created by yrd on 2017/12/8.
 */
//日志记录器接口：抽象产品
public interface Logger {
    void writeLog();
}

//数据库日志记录器：具体产品
class DatabaseLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}

//文件日志记录器：具体产品
class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}