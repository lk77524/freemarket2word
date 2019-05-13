package net.zhongli.tech.freemarker2word;

import net.zhongli.tech.freemarker2word.common.FreeMarket2Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Freemarker2wordApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void freemark2wordTest() {
        Map<String, Object> dataMap;
        List<Map<String, Object>> list = new ArrayList<>();
        // 模拟2组数据
        for (int i = 0; i < 2; i++) {
            dataMap = new HashMap<>();
            dataMap.put("grade", "高三");
            dataMap.put("className", "三班");
            dataMap.put("stuName", "小李");
            dataMap.put("stuTel", "13000000000");
            list.add(dataMap);
        }
        dataMap = new HashMap<>(1);
        dataMap.put("list", list);
        FreeMarket2Word freeMarket2Word = new FreeMarket2Word();
        freeMarket2Word.createWord("/templates/demo", "test.ftl", dataMap, "D:\\test.doc");
    }
}
