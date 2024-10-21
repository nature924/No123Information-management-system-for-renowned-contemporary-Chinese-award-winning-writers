package com.entity.model;

import com.entity.ZuojiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 作家
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZuojiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 作家姓名
     */
    private String zuojiaName;


    /**
     * 作家编号
     */
    private String zuojiaUuidNumber;


    /**
     * 作家照片
     */
    private String zuojiaPhoto;


    /**
     * 获得的奖项
     */
    private Integer zuojiaTypes;


    /**
     * 民族
     */
    private String zuojiaMinzu;


    /**
     * 作家籍贯
     */
    private String zuojiaJiguan;


    /**
     * 出生年
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chushengTime;


    /**
     * 获奖时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huojiangTime;


    /**
     * 代表作
     */
    private String zuojiaDaibia;


    /**
     * 作家介绍
     */
    private String zuojiaContent;


    /**
     * 逻辑删除
     */
    private Integer zuojiaDelete;


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
