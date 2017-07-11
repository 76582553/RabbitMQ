package publish;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by x on 2017/7/10.
 */
public class Provide  {



    /**
     * 参数可以为Serializable obj
     * @throws Exception
     */
    public static void  main(String args[]) throws Exception{

        String baseName = "MyQueue";


        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("test");
        factory.setPassword("test");
        //设置host
        factory.setHost("119.23.12.203");
        factory.setVirtualHost("/");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        for(int i = 1;i<6;i++){

            String message = "Hello World-->"+i;
            channel.basicPublish("",baseName,null,message.getBytes("UTF-8") );
            System.out.println("消息发出去了---消息为-->"+message);
        }
        /*SerializationUtils.serialize(obj)*/
       channel.close();
       connection.close();

    }
}
