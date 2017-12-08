package CSDN;

/**
 * Created by yrd on 2017/12/8.
 */
//日志记录器工厂接口：抽象工厂
public interface LoggerFactory {
    Logger createLogger();
}

//数据库日志记录器工厂类：具体工厂
class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //连接数据库，代码略
        //创建数据库日志记录器对象
        Logger logger = new DatabaseLogger();
        //初始化数据库日志记录器，代码略
        return logger;
    }
}

//文件日志记录器工厂类：具体工厂
class FileLoggerFactory implements  LoggerFactory {
    @Override
    public Logger createLogger() {
        //创建文件日志记录器对象
        Logger logger = new FileLogger();
        //创建文件，代码略
        return logger;
    }
}