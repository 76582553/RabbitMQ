package publish;

/**
 * Created by x on 2017/7/10.
 */
public class Provide extends Base {


    public Provide(String baseName) throws Exception {
        super(baseName);
    }

    /**
     * 参数可以为Serializable obj
     * @throws Exception
     */
    public void  send() throws Exception{

        for(int i = 1;i<6;i++){

            String message = "Hello World-->"+i;
            channel.basicPublish("",super.baseName,null,message.getBytes("UTF-8") );
            System.out.println("消息发出去了---消息为-->"+message);
        }
        /*SerializationUtils.serialize(obj)*/
         close();
    }
}
