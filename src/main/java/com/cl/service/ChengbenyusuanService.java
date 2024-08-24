package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChengbenyusuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengbenyusuanView;


/**
 * 成本预算
 *
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface ChengbenyusuanService extends IService<ChengbenyusuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengbenyusuanView> selectListView(Wrapper<ChengbenyusuanEntity> wrapper);
   	
   	ChengbenyusuanView selectView(@Param("ew") Wrapper<ChengbenyusuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengbenyusuanEntity> wrapper);
   	

}

