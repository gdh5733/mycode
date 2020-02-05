package com.alan.demo.utils.设计模式.策略模式解决ifelse;

import java.util.Map;

/**
 * @Description 处理上下文
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */

public class HandlerContext {

    private Map<String, Class> handleMap;

    public HandlerContext(Map<String, Class> handleMap) {
        this.handleMap = handleMap;
    }

//    public AbstractHandler
}
