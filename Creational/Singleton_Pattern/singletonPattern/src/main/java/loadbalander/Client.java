package loadbalander;

/**
 * Created by yrd on 2017/11/30.
 */
public class Client {

    public static void main(String[] args) {
        LoadBalancer loadBalancer1, loadBalancer2, loadBalancer3, loadBalancer4;
        loadBalancer1 = LoadBalancer.getInstance();
        loadBalancer2 = LoadBalancer.getInstance();
        loadBalancer3 = LoadBalancer.getInstance();
        loadBalancer4 = LoadBalancer.getInstance();

        if (loadBalancer1 == loadBalancer2 && loadBalancer2 == loadBalancer3 && loadBalancer3 == loadBalancer4) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }

        loadBalancer1.addServer("Server 1");
        loadBalancer2.addServer("Server 2");
        loadBalancer3.addServer("Server 3");
        loadBalancer4.addServer("Server 4");

        for (int i = 0; i < 10; i++) {
            String server = loadBalancer1.getServer();
            System.out.println("分发请求至服务器：" + server);
        }
    }
}
