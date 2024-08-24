package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiangmujinduEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmujinduView;


/**
 * 项目进度
 *
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmujinduService extends IService<XiangmujinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmujinduView> selectListView(Wrapper<XiangmujinduEntity> wrapper);
   	
   	XiangmujinduView selectView(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmujinduEntity> wrapper);
   	

}

