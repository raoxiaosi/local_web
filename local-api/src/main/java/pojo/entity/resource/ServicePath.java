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
 * Entity - 服务地址
 *
 * @author zijing
 * @version 2.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service_path")
public class ServicePath implements Serializable {

    private static final long serialVersionUID = 5081846432919091193L;

    /**
     *
     */
    @Id
    private Long id;

    /**
     * 配置id
     */
    @Column(name = "config_id")
    private Integer configId;

    /**
     * 服务名称
     */
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 服务地址
     */
    @Column(name = "path_dir")
    private String pathDir;

    /**
     * 描述
     */
    @Column(name = "service_desc")
    private String serviceDesc;

    /**
     *
     */
    @Column(name = "create_time")
    private java.util.Date createTime;

    /**
     *
     */
    @Column(name = "update_time")
    private java.util.Date updateTime;

}
