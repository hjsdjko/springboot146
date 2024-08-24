package com.cl.dao;

import com.cl.entity.YuangongjixiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuangongjixiaoView;


/**
 * 员工绩效
 * 
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface YuangongjixiaoDao extends BaseMapper<YuangongjixiaoEntity> {
	
	List<YuangongjixiaoView> selectListView(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);

	List<YuangongjixiaoView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
	
	YuangongjixiaoView selectView(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
	

}
