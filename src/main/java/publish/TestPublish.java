package publish;

/**
 * Created by x on 2017/7/11.
 */
public class TestPublish {
    public static void main(String[] args) throws Exception{

        Custom custom = new Custom("MyQueue");
        Custom custom1 = new Custom("MyQueue");
        Provide provide = new Provide("MyQueue");

        custom.recieve();
        custom1.recieve();
        provide.send();

    }
}
