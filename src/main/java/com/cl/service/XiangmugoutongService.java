package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiangmugoutongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmugoutongView;


/**
 * 项目沟通
 *
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmugoutongService extends IService<XiangmugoutongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmugoutongView> selectListView(Wrapper<XiangmugoutongEntity> wrapper);
   	
   	XiangmugoutongView selectView(@Param("ew") Wrapper<XiangmugoutongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmugoutongEntity> wrapper);
   	

}

