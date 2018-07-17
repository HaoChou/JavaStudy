package jdkstudy.zookeeper;

import com.alibaba.fastjson.JSON;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 启动两个实例
 *
 * 删除 rmr /leaderRoot/demo/leader/_c_13c8e15f-477c-4d89-820a-347a419385fd-latch-0000000024
 * 删除其中一个节点  另外一个节点会抢主 但是这个被删除的节点就不会再注册上来了
 * 再删除另外一个节点 /leaderRoot/demo/leader目录下就没有节点了
 * 然后停掉当前的master
 * 另外一个实例没有任何反应，当前集群没有master
 *
 * 解决办法 重启实例
 *
 *
 * @author zhou
 * Created on 2018/7/17
 */
public class LeaderLatchTest {

    private static final String PATH = "/demo/leader";

    public static void main(String[] args) {
        List<LeaderLatch> latchList = new ArrayList<>();
        List<CuratorFramework> clients = new ArrayList<>();
        try {
                CuratorFramework client = getClient();
                clients.add(client);

                final LeaderLatch leaderLatch = new LeaderLatch(client, PATH, "client#" + System.currentTimeMillis());
                leaderLatch.addListener(new LeaderLatchListener() {
                    @Override
                    public void isLeader() {
                        System.out.println(leaderLatch.getId() +  ":I am leader. I am doing jobs!");
                    }

                    @Override
                    public void notLeader() {
                        System.out.println(leaderLatch.getId() +  ":I am not leader. I will do nothing!");
                    }
                });
                latchList.add(leaderLatch);
                leaderLatch.start();

            System.out.println(JSON.toJSON(leaderLatch.getParticipants()));

            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            for(CuratorFramework client : clients){
                CloseableUtils.closeQuietly(client);
            }

            for(LeaderLatch leaderLatch : latchList){
                CloseableUtils.closeQuietly(leaderLatch);
            }
        }
    }

    private static CuratorFramework getClient() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(6000)
                .connectionTimeoutMs(3000)
                .namespace("leaderRoot")
                .build();
        client.start();
        return client;
    }
}