import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.io.IOException;

public class Realmtest {

    static Logger logger=Logger.getLogger(Realmtest.class);
    public static void main(String[] args) throws IOException {

        String hashAlgorithmName="MD5"; //加密方式
        Object credentials="123";   //要加密的密码
        Object salt= ByteSource.Util.bytes("123");//加的盐
        int hashIterations=1024;//加密次数

      Object result=new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);

      System.out.println("====>"+result);


   /*     FileAppender fileAppender=new FileAppender(new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN),"1.log");
        ConsoleAppender appender=new ConsoleAppender(
                new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN),
                "System.out");
        logger.addAppender(fileAppender);
        logger.setLevel(Level.INFO);

        logger.error("error");
        logger.info("hello");
*/


    }

}
