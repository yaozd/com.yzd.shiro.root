package com.yzd.shiro.web.api.mock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/mock")
@Slf4j
public class MockController {
    /**
     * 简易版的mock模拟测试生成
     * 通用json访问接口
     * 格式： http://localhost:9090/api/mock/json/{filename}
     *
     * @param filename
     * @return
     */
    @RequestMapping(value = "/json/{filename}", method = RequestMethod.GET)
    public String getJsonData(@PathVariable String filename) {
        String jsonPath = "mock/json/"+filename+".json";
        return readJson(jsonPath);
    }
    /**
     * 读取json格式文件
     * @param jsonPath
     * @return
     */
    private String readJson(String jsonPath) {
        String json = "";
        InputStream stream=null;
        try {
            stream = MockController.class.getClassLoader().getResourceAsStream(jsonPath);
            if(stream==null){
                return "FILE NOT FOUND!";
            }
            json = IOUtils.toString(stream,"utf-8");
        } catch (IOException e) {
            log.error("Exception:", e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
        return json;
    }
}
