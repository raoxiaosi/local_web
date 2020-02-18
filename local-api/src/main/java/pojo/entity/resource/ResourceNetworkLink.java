package pojo.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity - 网链表
 *
 * @author raojing
 * @version 2.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resource_network_link")
public class ResourceNetworkLink implements Serializable {

    private static final long serialVersionUID = 5081846432919091193L;

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 链接名称
     */
    @Column(name = "link_name")
    private String linkName;

    /**
     * 链接地址
     */
    @Column(name = "link_path")
    private String linkPath;

    /**
     * 链接图片
     */
    @Column(name = "link_image")
    private String linkImage;

    /**
     * 链接描述
     */
    @Column(name = "link_describe")
    private String linkDescribe;

    /**
     * 播放次数
     */
    @Column(name = "broadcast_number")
    private Integer broadcastNumber;

    /**
     * 点赞次数
     */
    @Column(name = "praise_number")
    private Integer praiseNumber;

    /**
     * 点击次数
     */
    @Column(name = "click_number")
    private Integer clickNumber;

    /**
     * 状态 1-上架 2-下架
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
