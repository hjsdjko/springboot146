package com.cl.dao;

import com.cl.entity.XiangmugoutongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmugoutongView;


/**
 * 项目沟通
 * 
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmugoutongDao extends BaseMapper<XiangmugoutongEntity> {
	
	List<XiangmugoutongView> selectListView(@Param("ew") Wrapper<XiangmugoutongEntity> wrapper);

	List<XiangmugoutongView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmugoutongEntity> wrapper);
	
	XiangmugoutongView selectView(@Param("ew") Wrapper<XiangmugoutongEntity> wrapper);
	

}
