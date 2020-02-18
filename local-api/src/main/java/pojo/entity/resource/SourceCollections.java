package pojo.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity - 收藏表
 *
 * @author zijing
 * @version 2.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "source_collections")
public class SourceCollections implements Serializable {

    private static final long serialVersionUID = 5081846432919091193L;

    /**
     * id
     */
    @Column(name = "id")
    private Long id;

    /**
     * 收藏名字
     */
    @Column(name = "collection_name")
    private String collectionName;

    /**
     * 收藏地址
     */
    @Column(name = "collection_path")
    private String collectionPath;

    /**
     * 收藏类型 1-视频
     */
    @Column(name = "collection_type")
    private Integer collectionType;

    /**
     * 资源ID
     */
    @Column(name = "resource_id")
    private Long resourceId;

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
