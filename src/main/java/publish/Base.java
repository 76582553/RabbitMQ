package publish;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * Created by x on 2017/7/10.
 */
public abstract class Base {

    protected Channel channel;
    protected Connection connection;
    protected String baseName;
    protected ConnectionFactory factory;

    public Base(String baseName) throws Exception {
        this.baseName = baseName;

        //创建链接工厂
        factory = new ConnectionFactory();
        factory.setUsername("test");
        factory.setPassword("test");
        //设置host
        factory.setHost("119.23.12.203");
        factory.setVirtualHost("/");
        factory.setPort(5672);
        connection = factory.newConnection();
        //创建channel
        channel = connection.createChannel();
        //声明一个queue
        channel.queueDeclare(baseName,false,false,false,null);

    }

    public void close() throws Exception{

       this.channel.close();
       this.connection.close();

    }
}
