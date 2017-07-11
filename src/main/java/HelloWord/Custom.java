package HelloWord;

import com.rabbitmq.client.*;
import org.junit.Test;


import java.io.IOException;

/**
 * Created by x on 2017/7/10.
 */
public class Custom extends Base {


    public Custom(String baseName) throws Exception {
        super(baseName);
    }

    public void recieve() throws Exception {

        Consumer consumer = new DefaultConsumer(super.channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println("收到消息了..消息是--->" + message);
            }
        };
        super.channel.basicConsume(super.baseName, true, consumer);
        close();

    }

}
