package com.dao;

import com.entity.ZuojiaCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuojiaCollectionView;

/**
 * 作家收藏 Dao 接口
 *
 * @author 
 */
public interface ZuojiaCollectionDao extends BaseMapper<ZuojiaCollectionEntity> {

   List<ZuojiaCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
