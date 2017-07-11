package HelloWord;

/**
 * Created by x on 2017/7/11.
 */
public class TestHelloWorld {
    public static void main(String[] args) throws Exception {
        Custom custom = new Custom("myQueue");
        Provide provide = new Provide("myQueue");
        provide.send();
//        Thread.sleep(100);
        custom.recieve();



    }
}
