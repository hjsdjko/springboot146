package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiangmujingliEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiangmujingliView;


/**
 * 项目经理
 *
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
public interface XiangmujingliService extends IService<XiangmujingliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmujingliView> selectListView(Wrapper<XiangmujingliEntity> wrapper);
   	
   	XiangmujingliView selectView(@Param("ew") Wrapper<XiangmujingliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmujingliEntity> wrapper);
   	

}

