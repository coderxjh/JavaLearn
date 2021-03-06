package com.atguigu.zk.case1;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xjh
 * @create 2021-07-26 20:14
 */
public class DistributeClient {

    private static String connectString = "192.168.242.144:2181,192.168.242.145:2181,192.168.242.146:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zk = null;

    // 创建到 zk 的客户端连接
    public void getConnect() throws IOException {
        zk = new ZooKeeper(connectString, sessionTimeout, event -> {
            // 再次启动监听
            try {
                getServerList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // 获取服务器列表信息
    public void getServerList() throws Exception {
        // 1 获取服务器子节点信息，并且对父节点进行监听
        List<String> children = zk.getChildren("/servers", true);
        // 2 存储服务器信息列表
        ArrayList<String> servers = new ArrayList<>();
        // 3 遍历所有节点，获取节点中的主机名称信息
        for (String child : children) {
            byte[] data = zk.getData("/servers/" + child, false, null);
            servers.add(new String(data));
        }
        // 4 打印服务器列表信息
        System.out.println(servers);
    }

    // 业务功能
    public void business() throws Exception {
        System.out.println("client is working ...");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        // 1 获取 zk 连接
        DistributeClient client = new DistributeClient();
        client.getConnect();
        // 2 获取 servers 的子节点信息，从中获取服务器信息列表
        client.getServerList();
        // 3 业务进程启动
        client.business();
    }
}