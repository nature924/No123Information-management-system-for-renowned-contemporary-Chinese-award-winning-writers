package com.dao;

import com.entity.ZuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuopinView;

/**
 * 作品 Dao 接口
 *
 * @author 
 */
public interface ZuopinDao extends BaseMapper<ZuopinEntity> {

   List<ZuopinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
