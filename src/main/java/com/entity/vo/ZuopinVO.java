package com.entity.vo;

import com.entity.ZuopinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 作品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zuopin")
public class ZuopinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 作家
     */

    @TableField(value = "zuojia_id")
    private Integer zuojiaId;


    /**
     * 作品名称
     */

    @TableField(value = "zuopin_name")
    private String zuopinName;


    /**
     * 作品编号
     */

    @TableField(value = "zuopin_uuid_number")
    private String zuopinUuidNumber;


    /**
     * 作品封面
     */

    @TableField(value = "zuopin_photo")
    private String zuopinPhoto;


    /**
     * 作品类型
     */

    @TableField(value = "zuopin_types")
    private Integer zuopinTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fabu_time")
    private Date fabuTime;


    /**
     * 作品介绍
     */

    @TableField(value = "zuopin_content")
    private String zuopinContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zuopin_delete")
    private Integer zuopinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：作家
	 */
    public Integer getZuojiaId() {
        return zuojiaId;
    }


    /**
	 * 获取：作家
	 */

    public void setZuojiaId(Integer zuojiaId) {
        this.zuojiaId = zuojiaId;
    }
    /**
	 * 设置：作品名称
	 */
    public String getZuopinName() {
        return zuopinName;
    }


    /**
	 * 获取：作品名称
	 */

    public void setZuopinName(String zuopinName) {
        this.zuopinName = zuopinName;
    }
    /**
	 * 设置：作品编号
	 */
    public String getZuopinUuidNumber() {
        return zuopinUuidNumber;
    }


    /**
	 * 获取：作品编号
	 */

    public void setZuopinUuidNumber(String zuopinUuidNumber) {
        this.zuopinUuidNumber = zuopinUuidNumber;
    }
    /**
	 * 设置：作品封面
	 */
    public String getZuopinPhoto() {
        return zuopinPhoto;
    }


    /**
	 * 获取：作品封面
	 */

    public void setZuopinPhoto(String zuopinPhoto) {
        this.zuopinPhoto = zuopinPhoto;
    }
    /**
	 * 设置：作品类型
	 */
    public Integer getZuopinTypes() {
        return zuopinTypes;
    }


    /**
	 * 获取：作品类型
	 */

    public void setZuopinTypes(Integer zuopinTypes) {
        this.zuopinTypes = zuopinTypes;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getFabuTime() {
        return fabuTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setFabuTime(Date fabuTime) {
        this.fabuTime = fabuTime;
    }
    /**
	 * 设置：作品介绍
	 */
    public String getZuopinContent() {
        return zuopinContent;
    }


    /**
	 * 获取：作品介绍
	 */

    public void setZuopinContent(String zuopinContent) {
        this.zuopinContent = zuopinContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZuopinDelete() {
        return zuopinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZuopinDelete(Integer zuopinDelete) {
        this.zuopinDelete = zuopinDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
