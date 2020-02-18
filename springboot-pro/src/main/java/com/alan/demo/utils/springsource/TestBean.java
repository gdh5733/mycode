package com.alan.demo.utils.springsource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 模拟spring源码的源码编写方式练习
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/17
 */

public class TestBean {

    private Map<String, String> map;

    private static Map<String, String> mp;

    private String value;


    private String str;
//    static Logger logger = LoggerFactory.getLogger(getClass());

    public TestBean(Class<TestBean> val) {

        this.map = new HashMap<>();
        this.value = "alan";
        this.setStr(this.getStrr());
    }


    public String getStrr() {
        return "success";
    }

    /**
     * 生成返回值
     *
     * @return
     */
    private Map<String, String> genertorValue() {
        map.put("mpkey1", "mpvalue1");
        map.put("mpkey2", "mpvalue2");
        map.put(value, "value");
        return map;
    }

    public static void main(String[] args) {
        TestBean bean = new TestBean(TestBean.class);
        mp = bean.genertorValue();
        bean.mh();
    }

    private void mh() {

        mp.forEach((k, v) -> {
            System.out.println("key的值为:" + k + "value的值为:" + v);

//            logger.info("key的值为:" + k + "value的值为:" + v);

        });
    }


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
