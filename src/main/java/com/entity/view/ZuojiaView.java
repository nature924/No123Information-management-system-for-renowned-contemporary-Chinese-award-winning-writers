package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZuojiaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 作家
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zuojia")
public class ZuojiaView extends ZuojiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 获得的奖项的值
	*/
	@ColumnInfo(comment="获得的奖项的字典表值",type="varchar(200)")
	private String zuojiaValue;




	public ZuojiaView() {

	}

	public ZuojiaView(ZuojiaEntity zuojiaEntity) {
		try {
			BeanUtils.copyProperties(this, zuojiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "ZuojiaView{" +
			", zuojiaValue=" + zuojiaValue +
			"} " + super.toString();
	}
}
