package com.cl.dao;

import com.cl.entity.XiangmuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmuxinxiView;


/**
 * 项目信息
 * 
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmuxinxiDao extends BaseMapper<XiangmuxinxiEntity> {
	
	List<XiangmuxinxiView> selectListView(@Param("ew") Wrapper<XiangmuxinxiEntity> wrapper);

	List<XiangmuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmuxinxiEntity> wrapper);
	
	XiangmuxinxiView selectView(@Param("ew") Wrapper<XiangmuxinxiEntity> wrapper);
	

}
