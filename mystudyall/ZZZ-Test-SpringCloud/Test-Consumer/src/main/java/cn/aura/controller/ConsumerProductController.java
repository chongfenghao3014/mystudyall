package cn.aura.controller;


import cn.aura.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConsumerProductController extends BaseController implements B2BInOutProvider{
    @Override
    public Object getProduct(Long id) {
        System.out.println("ccccccccccccccccccc"+id);
        return  "success::";
    }
    @RequestMapping("/test/{id}")
    public Object getProduct2(Long id) {// 使用restful风格的，不能用long，可以用Long。如果用long会报如下错
        System.out.println("ddddddddd"+id);//Optional long parameter 'id' is present but cannot be translated
                                           // into a null value due to being declared as a primitive type.
        return  "success::";
    }
    @RequestMapping("/test2")
    public Object getProduct3( long id) {// 不使用restful风格的，可以写long，但是如果没有传参就会报相同错误。
        System.out.println("eeeeeeeeee"+id);
        return  "success::";
    }
    @RequestMapping("/test3")
    public Object getProduct4(Long id) {// 如果使用的是Long那么不传参的话就是null。
        System.out.println("eeeeeeeeee"+id);
        return  "success::";
    }
}
