package CSDN;

/**
 * Created by yrd on 2017/12/8.
 */
public class Client {

    public static void main(String[] args) {
        reflect();
        LoggerFactory loggerFactory;
        Logger logger;
        loggerFactory = new FileLoggerFactory();
        logger = loggerFactory.createLogger();
        logger.writeLog();
    }

    public static void reflect() {
        LoggerFactory factory;
        Logger logger;
        factory = (LoggerFactory) XMLUtil.getBean();
        logger = factory.createLogger();
        logger.writeLog();
    }
}
