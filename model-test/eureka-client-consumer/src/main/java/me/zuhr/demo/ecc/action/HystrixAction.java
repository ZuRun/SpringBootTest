package me.zuhr.demo.ecc.action;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.zuhr.demo.basis.enumration.ServiceNameEnum;
import me.zuhr.demo.basis.model.Result;
import me.zuhr.demo.std.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断路器练习
 *
 * @author zurun
 * @date 2018/3/11 12:21:25
 */
@RestController
@RequestMapping("hystrix")
public class HystrixAction extends BaseService {

    @GetMapping("/test1")
    @HystrixCommand(fallbackMethod = "fallback")
    public Result<String> consumer() {
        return restTemplate.getForObject(ServiceNameEnum.ECP, "ecp/hystrix/test1", String.class);
    }

    public Result<String> fallback() {
        return Result.fail("fallback");
    }
}
