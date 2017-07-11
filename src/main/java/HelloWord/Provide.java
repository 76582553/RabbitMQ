package HelloWord;

import org.junit.Test;

import java.io.Serializable;

/**
 * Created by x on 2017/7/10.
 */
public class Provide extends Base{


    public Provide(String baseName) throws Exception {
        super(baseName);
    }

    /**
     * 参数可以为Serializable obj
     * @throws Exception
     */
    public void  send() throws Exception{

         String message = "Hello World";
        /*SerializationUtils.serialize(obj)*/
         channel.basicPublish("",super.baseName,null,message.getBytes("UTF-8") );
        System.out.println("消息发出去了---消息为-->"+message);
         close();
    }
}
