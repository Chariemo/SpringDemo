package advice;

/**
 * Created by Charley on 2017/6/4.
 */
public class NavieWaiter implements Waiter {

    public void greeTo(String name) {

        System.out.println("greet to " + name + "...");
    }

    public void serveTo(String name) {

        System.out.println("serving " + name + "...");
    }
}
