package com.alan.demo.utils.javabase.Zookeeper;

import lombok.Data;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Description Watchmore
 * ZooKeeper 支持watch(观察)的概念。客户端可以在每个znode结点上设置一个观察。
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
public class Watchmore extends BaseConfig {

    //    private static final Logger logger = Logger.getLogger(Watchmore.class);
    //实例变量
    private ZooKeeper zk = null;

    private String oldValue = null;


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
        oldValue = result;
        return result;
    }

    /**
     * 触发获取新值方法
     *
     * @return
     */
    private boolean trigerValue(String PATH) throws KeeperException, InterruptedException {
        String result = null;
        byte[] byteArray = zk.getData(PATH, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    //一个递归
                    trigerValue(PATH);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        result = new String(byteArray);

        String newValue = result;

        if (oldValue.equals(newValue)) {
            System.out.println("*************no changes**********");
//            logger.info();
            return false;
        } else {
            System.out.println("**************oldValue: " + oldValue + "\t newValue: " + newValue);
//            logger.info("**************oldValue: " + oldValue + "\t newValue: " + newValue);
            oldValue = newValue;
            return true;
        }
    }


    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Watchmore watchMore = new Watchmore();
        watchMore.setZk(watchMore.startZk());

        if (watchMore.getZk().exists(PATH, false) == null) {
            watchMore.createZnode(PATH, "AAA");
            String retValue = watchMore.getZnode(PATH);
            System.out.println("******************* first retValue: " + retValue);
//            logger.info("******************* first retValue: " + retValue);
            Thread.sleep(Long.MAX_VALUE);
        } else {
            System.out.println("************node ok  " + watchMore.getZnode(PATH));
//            logger.info("************node ok");
        }
    }
}
