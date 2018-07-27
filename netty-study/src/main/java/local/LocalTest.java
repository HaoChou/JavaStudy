package local;

/**
 * @author zhou
 * Created on 2018/7/13
 */
public class LocalTest {

    private static void startNormalServer() throws InterruptedException {
        Server server = new Server();
        server.start();
    }

    private static void startLocalServer() throws InterruptedException {
        LocalServer server = new LocalServer("hello");
        server.start();
    }

    private static void startLocalClient(String clientName) {
        LocalClient client = new LocalClient("hello",clientName);
        client.start();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread serverThread = new Thread(new Runnable() {
            @Override public void run() {
                try {
                    startLocalServer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        serverThread.start();

        Thread.sleep(1000);

        for(int i =1;i>0;i--) {
            final int inner = i;
            Thread clientThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    startLocalClient(inner+"");
                }
            });
            clientThread.start();
        }
    }

}
