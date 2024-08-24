package com.cl.dao;

import com.cl.entity.GoutonghuifuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GoutonghuifuView;


/**
 * 沟通回复
 * 
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface GoutonghuifuDao extends BaseMapper<GoutonghuifuEntity> {
	
	List<GoutonghuifuView> selectListView(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);

	List<GoutonghuifuView> selectListView(Pagination page,@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
	
	GoutonghuifuView selectView(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
	

}
