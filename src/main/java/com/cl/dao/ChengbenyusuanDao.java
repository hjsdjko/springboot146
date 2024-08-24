package com.cl.dao;

import com.cl.entity.ChengbenyusuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengbenyusuanView;


/**
 * 成本预算
 * 
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface ChengbenyusuanDao extends BaseMapper<ChengbenyusuanEntity> {
	
	List<ChengbenyusuanView> selectListView(@Param("ew") Wrapper<ChengbenyusuanEntity> wrapper);

	List<ChengbenyusuanView> selectListView(Pagination page,@Param("ew") Wrapper<ChengbenyusuanEntity> wrapper);
	
	ChengbenyusuanView selectView(@Param("ew") Wrapper<ChengbenyusuanEntity> wrapper);
	

}
