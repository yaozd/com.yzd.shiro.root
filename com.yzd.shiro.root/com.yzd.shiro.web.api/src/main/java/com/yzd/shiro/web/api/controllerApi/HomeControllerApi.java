package com.yzd.shiro.web.api.controllerApi;

import com.yzd.shiro.web.api.model.response.a1base.DataListResult;
import com.yzd.shiro.web.api.model.response.home.HelloWorld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/home")
public class HomeControllerApi {
    @GetMapping("helloWorld")
    public HelloWorld helloWorld() {
        HelloWorld item = new HelloWorld();
        item.setName("YZD-WORLD");
        log.info(item.toString());
        return item;
    }

    @GetMapping("helloWorld4String")
    public String helloWorld4String() {
        String txt = "helloWorld4String=世界";
        log.info(txt);
        return txt;
    }

    @GetMapping("helloWorld4Integer")
    public Integer helloWorld4Integer() {
        Integer txt = 1;
        log.info("helloWorld4Interger=%d", txt);
        return txt;
    }


    @GetMapping("helloWorld4DataList")
    public DataListResult<HelloWorld> helloWorld4DataList() {
        DataListResult<HelloWorld> itemList = new DataListResult<>();
        itemList.setTotal(1);
        HelloWorld item = new HelloWorld();
        item.setName("YZD-WORLD");
        itemList.getDataList().add(item);
        return itemList;
    }

    @GetMapping("helloWorld4Null")
    public HelloWorld helloWorld4Null() {
        String txt = "helloWorld4Null";
        log.info(txt);
        return null;
    }
    @GetMapping("helloWorld4Void")
    public void helloWorld4Void() {
        String txt = "helloWorld4Void";
        log.info(txt);
        return;
    }
}
