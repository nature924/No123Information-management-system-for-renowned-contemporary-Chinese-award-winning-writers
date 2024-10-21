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
 * 作家
 *
 * @author 
 * @email
 */
@TableName("zuojia")
public class ZuojiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZuojiaEntity() {

	}

	public ZuojiaEntity(T t) {
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
     * 作家姓名
     */
    @ColumnInfo(comment="作家姓名",type="varchar(200)")
    @TableField(value = "zuojia_name")

    private String zuojiaName;


    /**
     * 作家编号
     */
    @ColumnInfo(comment="作家编号",type="varchar(200)")
    @TableField(value = "zuojia_uuid_number")

    private String zuojiaUuidNumber;


    /**
     * 作家照片
     */
    @ColumnInfo(comment="作家照片",type="varchar(200)")
    @TableField(value = "zuojia_photo")

    private String zuojiaPhoto;


    /**
     * 获得的奖项
     */
    @ColumnInfo(comment="获得的奖项",type="int(11)")
    @TableField(value = "zuojia_types")

    private Integer zuojiaTypes;


    /**
     * 民族
     */
    @ColumnInfo(comment="民族",type="varchar(200)")
    @TableField(value = "zuojia_minzu")

    private String zuojiaMinzu;


    /**
     * 作家籍贯
     */
    @ColumnInfo(comment="作家籍贯",type="varchar(200)")
    @TableField(value = "zuojia_jiguan")

    private String zuojiaJiguan;


    /**
     * 出生年
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="出生年",type="timestamp")
    @TableField(value = "chusheng_time")

    private Date chushengTime;


    /**
     * 获奖时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="获奖时间",type="timestamp")
    @TableField(value = "huojiang_time")

    private Date huojiangTime;


    /**
     * 代表作
     */
    @ColumnInfo(comment="代表作",type="varchar(200)")
    @TableField(value = "zuojia_daibia")

    private String zuojiaDaibia;


    /**
     * 作家介绍
     */
    @ColumnInfo(comment="作家介绍",type="text")
    @TableField(value = "zuojia_content")

    private String zuojiaContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zuojia_delete")

    private Integer zuojiaDelete;


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
	 * 获取：作家姓名
	 */
    public String getZuojiaName() {
        return zuojiaName;
    }
    /**
	 * 设置：作家姓名
	 */

    public void setZuojiaName(String zuojiaName) {
        this.zuojiaName = zuojiaName;
    }
    /**
	 * 获取：作家编号
	 */
    public String getZuojiaUuidNumber() {
        return zuojiaUuidNumber;
    }
    /**
	 * 设置：作家编号
	 */

    public void setZuojiaUuidNumber(String zuojiaUuidNumber) {
        this.zuojiaUuidNumber = zuojiaUuidNumber;
    }
    /**
	 * 获取：作家照片
	 */
    public String getZuojiaPhoto() {
        return zuojiaPhoto;
    }
    /**
	 * 设置：作家照片
	 */

    public void setZuojiaPhoto(String zuojiaPhoto) {
        this.zuojiaPhoto = zuojiaPhoto;
    }
    /**
	 * 获取：获得的奖项
	 */
    public Integer getZuojiaTypes() {
        return zuojiaTypes;
    }
    /**
	 * 设置：获得的奖项
	 */

    public void setZuojiaTypes(Integer zuojiaTypes) {
        this.zuojiaTypes = zuojiaTypes;
    }
    /**
	 * 获取：民族
	 */
    public String getZuojiaMinzu() {
        return zuojiaMinzu;
    }
    /**
	 * 设置：民族
	 */

    public void setZuojiaMinzu(String zuojiaMinzu) {
        this.zuojiaMinzu = zuojiaMinzu;
    }
    /**
	 * 获取：作家籍贯
	 */
    public String getZuojiaJiguan() {
        return zuojiaJiguan;
    }
    /**
	 * 设置：作家籍贯
	 */

    public void setZuojiaJiguan(String zuojiaJiguan) {
        this.zuojiaJiguan = zuojiaJiguan;
    }
    /**
	 * 获取：出生年
	 */
    public Date getChushengTime() {
        return chushengTime;
    }
    /**
	 * 设置：出生年
	 */

    public void setChushengTime(Date chushengTime) {
        this.chushengTime = chushengTime;
    }
    /**
	 * 获取：获奖时间
	 */
    public Date getHuojiangTime() {
        return huojiangTime;
    }
    /**
	 * 设置：获奖时间
	 */

    public void setHuojiangTime(Date huojiangTime) {
        this.huojiangTime = huojiangTime;
    }
    /**
	 * 获取：代表作
	 */
    public String getZuojiaDaibia() {
        return zuojiaDaibia;
    }
    /**
	 * 设置：代表作
	 */

    public void setZuojiaDaibia(String zuojiaDaibia) {
        this.zuojiaDaibia = zuojiaDaibia;
    }
    /**
	 * 获取：作家介绍
	 */
    public String getZuojiaContent() {
        return zuojiaContent;
    }
    /**
	 * 设置：作家介绍
	 */

    public void setZuojiaContent(String zuojiaContent) {
        this.zuojiaContent = zuojiaContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZuojiaDelete() {
        return zuojiaDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZuojiaDelete(Integer zuojiaDelete) {
        this.zuojiaDelete = zuojiaDelete;
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
        return "Zuojia{" +
            ", id=" + id +
            ", zuojiaName=" + zuojiaName +
            ", zuojiaUuidNumber=" + zuojiaUuidNumber +
            ", zuojiaPhoto=" + zuojiaPhoto +
            ", zuojiaTypes=" + zuojiaTypes +
            ", zuojiaMinzu=" + zuojiaMinzu +
            ", zuojiaJiguan=" + zuojiaJiguan +
            ", chushengTime=" + DateUtil.convertString(chushengTime,"yyyy-MM-dd") +
            ", huojiangTime=" + DateUtil.convertString(huojiangTime,"yyyy-MM-dd") +
            ", zuojiaDaibia=" + zuojiaDaibia +
            ", zuojiaContent=" + zuojiaContent +
            ", zuojiaDelete=" + zuojiaDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
