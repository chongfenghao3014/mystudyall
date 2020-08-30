package cn.aura.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping(value="/get/{id}")
    public String get(@PathVariable("id") long id) {
        System.out.println("pppppppppppppppppppppppppppppppppppp");
        return "productSuccess::"+id;
    }

}
