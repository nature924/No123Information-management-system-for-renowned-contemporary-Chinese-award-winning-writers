package com.entity.model;

import com.entity.ZuopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 作品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZuopinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 作家
     */
    private Integer zuojiaId;


    /**
     * 作品名称
     */
    private String zuopinName;


    /**
     * 作品编号
     */
    private String zuopinUuidNumber;


    /**
     * 作品封面
     */
    private String zuopinPhoto;


    /**
     * 作品类型
     */
    private Integer zuopinTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fabuTime;


    /**
     * 作品介绍
     */
    private String zuopinContent;


    /**
     * 逻辑删除
     */
    private Integer zuopinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
