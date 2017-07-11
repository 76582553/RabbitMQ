package publish;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by x on 2017/7/10.
 */
public class Custom {



    public static void main(String args[]) throws Exception {

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


        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("进来了....");
                String message = new String(body, "UTF-8");
                System.out.println("-->收到消息了..消息是--->" + message);
            }
        };
        channel.basicConsume(baseName, true, consumer);
      /*  channel.close();
        connection.close();*/
        //不关闭的情况下一直都可以收到消息

    }

}
