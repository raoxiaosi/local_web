package pojo.entity.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity - 系统菜单
 *
 * @author raojing
 * @version 2.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rain_system_menu")
public class RainSystemMenu implements Serializable {

    private static final long serialVersionUID = 5081846432919091193L;

    /**
     * id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "id")
    private Long id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单链接
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 菜单权限
     */
    @Column(name = "menu_permission")
    private String menuPermission;

    /**
     * 菜单图标
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 父菜单id(一级菜单为0)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 状态 1-启用 2-禁用
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private java.util.Date updateTime;

}
