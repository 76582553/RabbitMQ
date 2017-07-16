package publish;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by x on 2017/7/10.
 */
public class Custom {
    /**
     *  两个custom同时等待消息，消息被接收，但是A接收到消息1，B就接收不到了
     *  B能接收到消息2，同理A就接收不到消息1
     * @param args
     * @throws Exception
     */


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
