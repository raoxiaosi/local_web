package pojo.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity - 本地视频
 *
 * @author zijing
 * @version 2.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resource_video")
public class ResourceVideo implements Serializable {

    private static final long serialVersionUID = 5081846432919091193L;

    /**
     *
     */
    @Column(name = "id")
    private Long id;

    /**
     * 视频名字
     */
    @Column(name = "video_name")
    private String videoName;

    /**
     * 视频地址
     */
    @Column(name = "video_path")
    private String videoPath;

    /**
     * 视频大小
     */
    @Column(name = "video_size")
    private String videoSize;

    /**
     * 视频展示图片
     */
    @Column(name = "video_image")
    private String videoImage;

    /**
     * 视频描述信息
     */
    @Column(name = "video_describe")
    private String videoDescribe;

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
     * 服务ID
     */
    @Column(name = "service_id")
    private Long serviceId;

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

    /**
     * 关键字
     */
    @Column(name = "key_word")
    private String keyWord;

}
