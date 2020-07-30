package tk.mybatis.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 18:18
 */
@Controller
public class IndexController {

    private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = {"","/index"})
    public ModelAndView dicts(){
        LOGGER.info("请求了");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("now",new Date());
        return modelAndView;
    }
}
