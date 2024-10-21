package com.dao;

import com.entity.ZuojiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuojiaView;

/**
 * 作家 Dao 接口
 *
 * @author 
 */
public interface ZuojiaDao extends BaseMapper<ZuojiaEntity> {

   List<ZuojiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
