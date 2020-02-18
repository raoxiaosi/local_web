package pojo.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 资源类型关系
 * @author raojing
 * @date 2020/2/18 17:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resource_type_relation")
public class ResourceTypeRelation {

    /**
     * 资源id
     */
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * 类型id
     */
    @Column(name = "type_id")
    private Long typeId;

}
