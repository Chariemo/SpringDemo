package advice;

/**
 * Created by Charley on 2017/6/4.
 */
public class WaiterDelegate {

    private Waiter waiter;

    public void service(String clientName) {

        waiter.greeTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {

        this.waiter = waiter;
    }
}
