package com.alan.demo.utils.string.String工具类;
import org.apache.commons.lang3.StringUtils;
/**
 * @Description 测试StringUtils中的常用API测试
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/2
 */

public class StringUtilsTest {

    public static void main(String[] args) {

        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty("bob"));
        System.out.println(StringUtils.isEmpty("  bob  "));
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("bob"));
        System.out.println(StringUtils.isBlank("  bob  "));

    }


}
