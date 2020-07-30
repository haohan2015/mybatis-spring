package tk.mybatis.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.web.model.SysDict;
import tk.mybatis.web.service.DictService;

import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 20:22
 */
@Controller
@RequestMapping("/dict")
public class DictController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DictController.class);

    @Autowired
    private DictService dictService;

    @RequestMapping
    public ModelAndView dicts(SysDict sysDict,Integer offset,Integer limit){
        LOGGER.info("ssssssssssssssssss");
        ModelAndView modelAndView = new ModelAndView("dicts");
        List<SysDict> sysDicts = dictService.findBySysDict(sysDict,offset,limit);
        modelAndView.addObject("dicts",sysDicts);
        return modelAndView;
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ModelAndView add(Long id){
        ModelAndView modelAndView = new ModelAndView("dict_add");
        SysDict sysDict;
        if(id == null){
            sysDict = new SysDict();
        }else{
            sysDict = dictService.findById(id);
        }
        modelAndView.addObject("model",sysDict);
        return modelAndView;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView save(SysDict sysDict){
        ModelAndView modelAndView = new ModelAndView();
        try{
            dictService.saveAndUpdate(sysDict);
            modelAndView.setViewName("redirect:/dict");
        }catch (Exception e){
            modelAndView.setViewName("dict_add");
            modelAndView.addObject("msg",e.getMessage());
            modelAndView.addObject("model",sysDict);
        }

        return modelAndView;
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ModelMap delete(@RequestParam Long id){
        ModelMap modelMap = new ModelMap();
        try{
            boolean success = dictService.deleteById(id);
            modelMap.put("success",success);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("msg",e.getMessage());
        }

        return modelMap;
    }

}
