package com.cl.dao;

import com.cl.entity.XiangmujingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmujingliView;


/**
 * 项目经理
 * 
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmujingliDao extends BaseMapper<XiangmujingliEntity> {
	
	List<XiangmujingliView> selectListView(@Param("ew") Wrapper<XiangmujingliEntity> wrapper);

	List<XiangmujingliView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmujingliEntity> wrapper);
	
	XiangmujingliView selectView(@Param("ew") Wrapper<XiangmujingliEntity> wrapper);
	

}
