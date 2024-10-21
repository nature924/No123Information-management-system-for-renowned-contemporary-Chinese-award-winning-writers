package com.dao;

import com.entity.ZuojiaLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuojiaLiuyanView;

/**
 * 留言 Dao 接口
 *
 * @author 
 */
public interface ZuojiaLiuyanDao extends BaseMapper<ZuojiaLiuyanEntity> {

   List<ZuojiaLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
