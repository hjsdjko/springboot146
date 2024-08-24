package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuangongjixiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuangongjixiaoView;


/**
 * 员工绩效
 *
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface YuangongjixiaoService extends IService<YuangongjixiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongjixiaoView> selectListView(Wrapper<YuangongjixiaoEntity> wrapper);
   	
   	YuangongjixiaoView selectView(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongjixiaoEntity> wrapper);
   	

}

