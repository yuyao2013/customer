/** 
 * Project Name:gs-spring-boot-docker 
 * File Name:MapTest.java 
 * Package Name:hello 
 * Date:Mar 18, 20191:15:20 PM 
 * Copyright (c) 2019阿里巴巴集团-版权所有. 
 * 
 */
package hello;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MapTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * 
 * @author yuzhen.wt
 * @version
 * @data Mar 18, 2019 1:15:20 PM
 * @since JDK 1.8
 */

public class MapTest {
    public static void main(String ags[]) {
        // test2();
        System.out.println("-----");
        test1(99999);
    }

    private static Map m = new HashMap();

    public static void clearMem() {
        m.clear();
        System.gc();
        m = new HashMap();
    }

    public static void test1(int max) {
        long t0 = System.currentTimeMillis();
        int maxIdx = m.size() + 1;
        for (int i = 0; i < max; i++) {
            m.put("aa.bb.to.pub." + (i + maxIdx) + "12345asfsdfVO", (i + maxIdx) + "value");
        }
        long t1 = System.currentTimeMillis();
        // System.out.println(t1 - t0);
        ;
        // System.out.println(m.get("8888key"));
        for (int i = 0; i < max; i++) {
            m.get("aa.bb.to.pub." + (i + maxIdx) + "12345asfsdfVO");
        }
        long t2 = System.currentTimeMillis();
        // System.out.println(t2 - t1);

    }

    public static void test2() {
        Map m = new HashMap();
        m.put("aa.bb.ao", new HashMap());
        m.put("aa.bb.do", new HashMap());
        m.put("aa.bb.wo", new HashMap());
        m.put("aa.bb.po", new HashMap());
        m.put("aa.bb.io", new HashMap());
        m.put("aa.bb.oo", new HashMap());
        m.put("aa.bb.bo", new HashMap());
        m.put("aa.bb.to", new HashMap());
        m.put("aa.bb.yo", new HashMap());
        m.put("aa.bb.ro", new HashMap());
        long t0 = System.currentTimeMillis();
        for (int i = 10; i < 20; i++) {
            for (int k = 1; k < 5; k++) // 有10个模块，比较5个模块概率
                if ("aa.bb.to.pub.12345headerVO".startsWith("aa.bb.to"))
                    ;
            // 下面假设上边比较结果为： aa.bb.to开头
            for (int j = 1000; j < 2000; j++) // 每个模块里有1000个
                ((Map) m.get("aa.bb.to")).put("aa.bb.to.pub." + j + "12345asfsdfVO", "value");
        }
        long t1 = System.currentTimeMillis();
        System.out.println("录入时间为：" + (t1 - t0));
        ;
        // System.out.println(m.get("8888key"));
        for (int i = 10; i < 20; i++) {
            for (int k = 1; k < 5; k++) // 有10个模块，比较5个模块概率
                if ("aa.bb.to.pub.12345asfsdfVO".startsWith("aa.bb.to"))
                    ;

            for (int j = 1000; j < 2000; j++)
                ((Map) m.get("aa.bb.to")).get("aa.bb.to.pub." + j + "12345asfsdfVO");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("查找时间为：" + (t2 - t1));

    }
}
