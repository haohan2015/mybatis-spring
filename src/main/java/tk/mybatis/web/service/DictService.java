package tk.mybatis.web.service;

import tk.mybatis.web.model.SysDict;

import java.util.List;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 20:13
 */
public interface DictService {

    SysDict findById(Long id);

    List<SysDict> findBySysDict(SysDict sysDict,Integer offset,Integer limit);

    boolean saveAndUpdate(SysDict sysDict);

    boolean deleteById(Long id);

}
