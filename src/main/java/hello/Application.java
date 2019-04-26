package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home(@RequestParam(required = false, defaultValue = "yuzhen") String name) {
        return "Hello <font color ='orange' >" + name + "</font>, Welcome to Docker World";
    }

    @RequestMapping("/memext")
    public String memExt(@RequestParam(required = false, defaultValue = "999999") Integer max) {
        if (max == null) {
            max = 999999;
        } else if (max == 0) {
            MapTest.clearMem();
        }
        MapTest.test1(max);
        return "mem auto extend test.";
    }

    @RequestMapping("/memget")
    public String memGet() {
        long i = Runtime.getRuntime().totalMemory() / 1024 / 1024;// Java 虚拟机中的内存总量，以字节为单位
        long j = Runtime.getRuntime().freeMemory() / 1024 / 1024;// Java 虚拟机中的空闲内存量
        long k = i -j;// Runtime.getRuntime().maxMemory() / 1024 / 1024;
        return "总的内存量为:" + i + "Mb" + ";空闲内存量:" + j + "Mb" + ";在用内存量:" + k + "Mb";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
