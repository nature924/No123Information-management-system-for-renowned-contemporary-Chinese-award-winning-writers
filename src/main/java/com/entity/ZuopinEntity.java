package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 作品
 *
 * @author 
 * @email
 */
@TableName("zuopin")
public class ZuopinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZuopinEntity() {

	}

	public ZuopinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 作家
     */
    @ColumnInfo(comment="作家",type="int(11)")
    @TableField(value = "zuojia_id")

    private Integer zuojiaId;


    /**
     * 作品名称
     */
    @ColumnInfo(comment="作品名称",type="varchar(200)")
    @TableField(value = "zuopin_name")

    private String zuopinName;


    /**
     * 作品编号
     */
    @ColumnInfo(comment="作品编号",type="varchar(200)")
    @TableField(value = "zuopin_uuid_number")

    private String zuopinUuidNumber;


    /**
     * 作品封面
     */
    @ColumnInfo(comment="作品封面",type="varchar(200)")
    @TableField(value = "zuopin_photo")

    private String zuopinPhoto;


    /**
     * 作品类型
     */
    @ColumnInfo(comment="作品类型",type="int(11)")
    @TableField(value = "zuopin_types")

    private Integer zuopinTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布时间",type="timestamp")
    @TableField(value = "fabu_time")

    private Date fabuTime;


    /**
     * 作品介绍
     */
    @ColumnInfo(comment="作品介绍",type="text")
    @TableField(value = "zuopin_content")

    private String zuopinContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zuopin_delete")

    private Integer zuopinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：作家
	 */
    public Integer getZuojiaId() {
        return zuojiaId;
    }
    /**
	 * 设置：作家
	 */

    public void setZuojiaId(Integer zuojiaId) {
        this.zuojiaId = zuojiaId;
    }
    /**
	 * 获取：作品名称
	 */
    public String getZuopinName() {
        return zuopinName;
    }
    /**
	 * 设置：作品名称
	 */

    public void setZuopinName(String zuopinName) {
        this.zuopinName = zuopinName;
    }
    /**
	 * 获取：作品编号
	 */
    public String getZuopinUuidNumber() {
        return zuopinUuidNumber;
    }
    /**
	 * 设置：作品编号
	 */

    public void setZuopinUuidNumber(String zuopinUuidNumber) {
        this.zuopinUuidNumber = zuopinUuidNumber;
    }
    /**
	 * 获取：作品封面
	 */
    public String getZuopinPhoto() {
        return zuopinPhoto;
    }
    /**
	 * 设置：作品封面
	 */

    public void setZuopinPhoto(String zuopinPhoto) {
        this.zuopinPhoto = zuopinPhoto;
    }
    /**
	 * 获取：作品类型
	 */
    public Integer getZuopinTypes() {
        return zuopinTypes;
    }
    /**
	 * 设置：作品类型
	 */

    public void setZuopinTypes(Integer zuopinTypes) {
        this.zuopinTypes = zuopinTypes;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getFabuTime() {
        return fabuTime;
    }
    /**
	 * 设置：发布时间
	 */

    public void setFabuTime(Date fabuTime) {
        this.fabuTime = fabuTime;
    }
    /**
	 * 获取：作品介绍
	 */
    public String getZuopinContent() {
        return zuopinContent;
    }
    /**
	 * 设置：作品介绍
	 */

    public void setZuopinContent(String zuopinContent) {
        this.zuopinContent = zuopinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZuopinDelete() {
        return zuopinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZuopinDelete(Integer zuopinDelete) {
        this.zuopinDelete = zuopinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zuopin{" +
            ", id=" + id +
            ", zuojiaId=" + zuojiaId +
            ", zuopinName=" + zuopinName +
            ", zuopinUuidNumber=" + zuopinUuidNumber +
            ", zuopinPhoto=" + zuopinPhoto +
            ", zuopinTypes=" + zuopinTypes +
            ", fabuTime=" + DateUtil.convertString(fabuTime,"yyyy-MM-dd") +
            ", zuopinContent=" + zuopinContent +
            ", zuopinDelete=" + zuopinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
