package com.cl.dao;

import com.cl.entity.XiangmujinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmujinduView;


/**
 * 项目进度
 * 
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmujinduDao extends BaseMapper<XiangmujinduEntity> {
	
	List<XiangmujinduView> selectListView(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);

	List<XiangmujinduView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
	
	XiangmujinduView selectView(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
	

}
