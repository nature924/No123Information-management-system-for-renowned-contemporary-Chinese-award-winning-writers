package com.entity.vo;

import com.entity.ZuojiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 作家
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zuojia")
public class ZuojiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 作家姓名
     */

    @TableField(value = "zuojia_name")
    private String zuojiaName;


    /**
     * 作家编号
     */

    @TableField(value = "zuojia_uuid_number")
    private String zuojiaUuidNumber;


    /**
     * 作家照片
     */

    @TableField(value = "zuojia_photo")
    private String zuojiaPhoto;


    /**
     * 获得的奖项
     */

    @TableField(value = "zuojia_types")
    private Integer zuojiaTypes;


    /**
     * 民族
     */

    @TableField(value = "zuojia_minzu")
    private String zuojiaMinzu;


    /**
     * 作家籍贯
     */

    @TableField(value = "zuojia_jiguan")
    private String zuojiaJiguan;


    /**
     * 出生年
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chusheng_time")
    private Date chushengTime;


    /**
     * 获奖时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huojiang_time")
    private Date huojiangTime;


    /**
     * 代表作
     */

    @TableField(value = "zuojia_daibia")
    private String zuojiaDaibia;


    /**
     * 作家介绍
     */

    @TableField(value = "zuojia_content")
    private String zuojiaContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zuojia_delete")
    private Integer zuojiaDelete;


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
	 * 设置：作家姓名
	 */
    public String getZuojiaName() {
        return zuojiaName;
    }


    /**
	 * 获取：作家姓名
	 */

    public void setZuojiaName(String zuojiaName) {
        this.zuojiaName = zuojiaName;
    }
    /**
	 * 设置：作家编号
	 */
    public String getZuojiaUuidNumber() {
        return zuojiaUuidNumber;
    }


    /**
	 * 获取：作家编号
	 */

    public void setZuojiaUuidNumber(String zuojiaUuidNumber) {
        this.zuojiaUuidNumber = zuojiaUuidNumber;
    }
    /**
	 * 设置：作家照片
	 */
    public String getZuojiaPhoto() {
        return zuojiaPhoto;
    }


    /**
	 * 获取：作家照片
	 */

    public void setZuojiaPhoto(String zuojiaPhoto) {
        this.zuojiaPhoto = zuojiaPhoto;
    }
    /**
	 * 设置：获得的奖项
	 */
    public Integer getZuojiaTypes() {
        return zuojiaTypes;
    }


    /**
	 * 获取：获得的奖项
	 */

    public void setZuojiaTypes(Integer zuojiaTypes) {
        this.zuojiaTypes = zuojiaTypes;
    }
    /**
	 * 设置：民族
	 */
    public String getZuojiaMinzu() {
        return zuojiaMinzu;
    }


    /**
	 * 获取：民族
	 */

    public void setZuojiaMinzu(String zuojiaMinzu) {
        this.zuojiaMinzu = zuojiaMinzu;
    }
    /**
	 * 设置：作家籍贯
	 */
    public String getZuojiaJiguan() {
        return zuojiaJiguan;
    }


    /**
	 * 获取：作家籍贯
	 */

    public void setZuojiaJiguan(String zuojiaJiguan) {
        this.zuojiaJiguan = zuojiaJiguan;
    }
    /**
	 * 设置：出生年
	 */
    public Date getChushengTime() {
        return chushengTime;
    }


    /**
	 * 获取：出生年
	 */

    public void setChushengTime(Date chushengTime) {
        this.chushengTime = chushengTime;
    }
    /**
	 * 设置：获奖时间
	 */
    public Date getHuojiangTime() {
        return huojiangTime;
    }


    /**
	 * 获取：获奖时间
	 */

    public void setHuojiangTime(Date huojiangTime) {
        this.huojiangTime = huojiangTime;
    }
    /**
	 * 设置：代表作
	 */
    public String getZuojiaDaibia() {
        return zuojiaDaibia;
    }


    /**
	 * 获取：代表作
	 */

    public void setZuojiaDaibia(String zuojiaDaibia) {
        this.zuojiaDaibia = zuojiaDaibia;
    }
    /**
	 * 设置：作家介绍
	 */
    public String getZuojiaContent() {
        return zuojiaContent;
    }


    /**
	 * 获取：作家介绍
	 */

    public void setZuojiaContent(String zuojiaContent) {
        this.zuojiaContent = zuojiaContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZuojiaDelete() {
        return zuojiaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZuojiaDelete(Integer zuojiaDelete) {
        this.zuojiaDelete = zuojiaDelete;
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
