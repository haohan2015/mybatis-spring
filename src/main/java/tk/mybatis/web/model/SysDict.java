package tk.mybatis.web.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 19:23
 */
@Data
public class SysDict implements Serializable{

    private static final long serialVersionUID = -3032253630538264690L;

    private Long id;

    private String code;

    private String name;

    private String value;

}
