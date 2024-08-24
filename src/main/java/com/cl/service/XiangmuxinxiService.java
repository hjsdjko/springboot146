package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiangmuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmuxinxiView;


/**
 * 项目信息
 *
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmuxinxiService extends IService<XiangmuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmuxinxiView> selectListView(Wrapper<XiangmuxinxiEntity> wrapper);
   	
   	XiangmuxinxiView selectView(@Param("ew") Wrapper<XiangmuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmuxinxiEntity> wrapper);
   	

}

