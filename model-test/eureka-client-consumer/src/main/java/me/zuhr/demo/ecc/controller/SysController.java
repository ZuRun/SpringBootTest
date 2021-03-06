package me.zuhr.demo.ecc.controller;

import com.alibaba.fastjson.JSONObject;
import me.zuhr.demo.basis.enumration.ServiceNameEnum;
import me.zuhr.demo.server.restful.MyRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zurun
 * @date 2018/3/9 01:31:37
 */
@RestController
public class SysController {
    @Autowired
    MyRestTemplate restTemplate;

    @RequestMapping("sysInfo")
    public JSONObject info(HttpServletRequest request) {
        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity("http://" + ServiceNameEnum.ECP.getValue() + "/info", JSONObject.class);
        return responseEntity.getBody();
    }
}
