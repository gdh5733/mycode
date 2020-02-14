package com.alan.demo.utils.javabase.Zookeeper;

import lombok.Data;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Description ZooKeeper 支持watch(观察)的概念。客户端可以在每个znode结点上设置一个观察。
 * 如果被观察服务端的znode结点有变更,那么watch就会被触发,
 * 这个watch所属的客户端将收到一个通知包被告知结点已经发生变化,把相应的事件通知给设置Watcher的Client端
 * <p>
 * Zookeeper里的所有读取操作: getData(),getChildren() 和exists()都有设置watch的选项
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/14
 */


@Data
public class Watchone extends BaseConfig {

    //    private static final Logger logger = Logger.getLogger(Watchone.class);
    //实例变量
    private ZooKeeper zk = null;

    /**
     * 初始化 相当于拆创建了一个跟ZooKeeper服务器的连接
     * 即开始start
     *
     * @return
     * @throws IOException
     */
    public ZooKeeper startZk() throws IOException {

        return new ZooKeeper(CONNECTSTRING, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    /**
     * 创建节点
     *
     * @param nodePath  节点路径
     * @param nodeValue 节点的值
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void createZnode(String nodePath, String nodeValue) throws KeeperException, InterruptedException {
        zk.create(nodePath, nodeValue.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    }

    /**
     * 获取到节点的值
     *
     * @return 返回节点的值
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String getZnode(String PATH) throws KeeperException, InterruptedException {

        String result = null;

        //设置观察者  获得节点的值 还要监控值得变化 当值变化触发process
        byte[] byteArray = zk.getData(PATH, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    trigerValue(PATH);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        result = new String(byteArray);
        return result;
    }

    /**
     * 触发获取新值方法
     *
     * @return
     */
    private String trigerValue(String PATH) throws KeeperException, InterruptedException {
        String result = null;
        byte[] byteArray = zk.getData(PATH, false, new Stat());
        result = new String(byteArray);
        System.out.println("***************watch one time :" + result);
//        logger.info("***************watch one time :" + result);

        return result;

    }


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Watchone watchone = new Watchone();
        watchone.setZk(watchone.startZk());

        if (watchone.getZk().exists(PATH, false) == null) {
            watchone.createZnode(PATH, "AAA");
            String retValue = watchone.getZnode(PATH);
            System.out.println("******************* first retValue: " + retValue);
//            logger.info("******************* first retValue: " + retValue);
            Thread.sleep(Long.MAX_VALUE);
        } else {
            System.out.println("************node ok");
//            logger.info("************node ok");
        }
    }
}
