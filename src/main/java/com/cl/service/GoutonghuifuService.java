package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GoutonghuifuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GoutonghuifuView;


/**
 * 沟通回复
 *
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface GoutonghuifuService extends IService<GoutonghuifuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoutonghuifuView> selectListView(Wrapper<GoutonghuifuEntity> wrapper);
   	
   	GoutonghuifuView selectView(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoutonghuifuEntity> wrapper);
   	

}

