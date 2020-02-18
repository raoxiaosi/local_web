package pojo.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 资源类型
 * @author raojing
 * @date 2020/2/18 17:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resource_type")
public class ResourceType {

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 类型名称
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}
