package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZuopinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 作品
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zuopin")
public class ZuopinView extends ZuopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 作品类型的值
	*/
	@ColumnInfo(comment="作品类型的字典表值",type="varchar(200)")
	private String zuopinValue;

	//级联表 作家
		/**
		* 作家姓名
		*/

		@ColumnInfo(comment="作家姓名",type="varchar(200)")
		private String zuojiaName;
		/**
		* 作家编号
		*/

		@ColumnInfo(comment="作家编号",type="varchar(200)")
		private String zuojiaUuidNumber;
		/**
		* 作家照片
		*/

		@ColumnInfo(comment="作家照片",type="varchar(200)")
		private String zuojiaPhoto;
		/**
		* 获得的奖项
		*/
		@ColumnInfo(comment="获得的奖项",type="int(11)")
		private Integer zuojiaTypes;
			/**
			* 获得的奖项的值
			*/
			@ColumnInfo(comment="获得的奖项的字典表值",type="varchar(200)")
			private String zuojiaValue;
		/**
		* 民族
		*/

		@ColumnInfo(comment="民族",type="varchar(200)")
		private String zuojiaMinzu;
		/**
		* 作家籍贯
		*/

		@ColumnInfo(comment="作家籍贯",type="varchar(200)")
		private String zuojiaJiguan;
		/**
		* 出生年
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="出生年",type="timestamp")
		private Date chushengTime;
		/**
		* 获奖时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="获奖时间",type="timestamp")
		private Date huojiangTime;
		/**
		* 代表作
		*/

		@ColumnInfo(comment="代表作",type="varchar(200)")
		private String zuojiaDaibia;
		/**
		* 作家介绍
		*/

		@ColumnInfo(comment="作家介绍",type="text")
		private String zuojiaContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zuojiaDelete;



	public ZuopinView() {

	}

	public ZuopinView(ZuopinEntity zuopinEntity) {
		try {
			BeanUtils.copyProperties(this, zuopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 作品类型的值
	*/
	public String getZuopinValue() {
		return zuopinValue;
	}
	/**
	* 设置： 作品类型的值
	*/
	public void setZuopinValue(String zuopinValue) {
		this.zuopinValue = zuopinValue;
	}


	//级联表的get和set 作家

		/**
		* 获取： 作家姓名
		*/
		public String getZuojiaName() {
			return zuojiaName;
		}
		/**
		* 设置： 作家姓名
		*/
		public void setZuojiaName(String zuojiaName) {
			this.zuojiaName = zuojiaName;
		}

		/**
		* 获取： 作家编号
		*/
		public String getZuojiaUuidNumber() {
			return zuojiaUuidNumber;
		}
		/**
		* 设置： 作家编号
		*/
		public void setZuojiaUuidNumber(String zuojiaUuidNumber) {
			this.zuojiaUuidNumber = zuojiaUuidNumber;
		}

		/**
		* 获取： 作家照片
		*/
		public String getZuojiaPhoto() {
			return zuojiaPhoto;
		}
		/**
		* 设置： 作家照片
		*/
		public void setZuojiaPhoto(String zuojiaPhoto) {
			this.zuojiaPhoto = zuojiaPhoto;
		}
		/**
		* 获取： 获得的奖项
		*/
		public Integer getZuojiaTypes() {
			return zuojiaTypes;
		}
		/**
		* 设置： 获得的奖项
		*/
		public void setZuojiaTypes(Integer zuojiaTypes) {
			this.zuojiaTypes = zuojiaTypes;
		}


			/**
			* 获取： 获得的奖项的值
			*/
			public String getZuojiaValue() {
				return zuojiaValue;
			}
			/**
			* 设置： 获得的奖项的值
			*/
			public void setZuojiaValue(String zuojiaValue) {
				this.zuojiaValue = zuojiaValue;
			}

		/**
		* 获取： 民族
		*/
		public String getZuojiaMinzu() {
			return zuojiaMinzu;
		}
		/**
		* 设置： 民族
		*/
		public void setZuojiaMinzu(String zuojiaMinzu) {
			this.zuojiaMinzu = zuojiaMinzu;
		}

		/**
		* 获取： 作家籍贯
		*/
		public String getZuojiaJiguan() {
			return zuojiaJiguan;
		}
		/**
		* 设置： 作家籍贯
		*/
		public void setZuojiaJiguan(String zuojiaJiguan) {
			this.zuojiaJiguan = zuojiaJiguan;
		}

		/**
		* 获取： 出生年
		*/
		public Date getChushengTime() {
			return chushengTime;
		}
		/**
		* 设置： 出生年
		*/
		public void setChushengTime(Date chushengTime) {
			this.chushengTime = chushengTime;
		}

		/**
		* 获取： 获奖时间
		*/
		public Date getHuojiangTime() {
			return huojiangTime;
		}
		/**
		* 设置： 获奖时间
		*/
		public void setHuojiangTime(Date huojiangTime) {
			this.huojiangTime = huojiangTime;
		}

		/**
		* 获取： 代表作
		*/
		public String getZuojiaDaibia() {
			return zuojiaDaibia;
		}
		/**
		* 设置： 代表作
		*/
		public void setZuojiaDaibia(String zuojiaDaibia) {
			this.zuojiaDaibia = zuojiaDaibia;
		}

		/**
		* 获取： 作家介绍
		*/
		public String getZuojiaContent() {
			return zuojiaContent;
		}
		/**
		* 设置： 作家介绍
		*/
		public void setZuojiaContent(String zuojiaContent) {
			this.zuojiaContent = zuojiaContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZuojiaDelete() {
			return zuojiaDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZuojiaDelete(Integer zuojiaDelete) {
			this.zuojiaDelete = zuojiaDelete;
		}


	@Override
	public String toString() {
		return "ZuopinView{" +
			", zuopinValue=" + zuopinValue +
			", zuojiaName=" + zuojiaName +
			", zuojiaUuidNumber=" + zuojiaUuidNumber +
			", zuojiaPhoto=" + zuojiaPhoto +
			", zuojiaMinzu=" + zuojiaMinzu +
			", zuojiaJiguan=" + zuojiaJiguan +
			", chushengTime=" + DateUtil.convertString(chushengTime,"yyyy-MM-dd") +
			", huojiangTime=" + DateUtil.convertString(huojiangTime,"yyyy-MM-dd") +
			", zuojiaDaibia=" + zuojiaDaibia +
			", zuojiaContent=" + zuojiaContent +
			", zuojiaDelete=" + zuojiaDelete +
			"} " + super.toString();
	}
}
