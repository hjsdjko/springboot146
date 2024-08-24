package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ChengbenyusuanDao;
import com.cl.entity.ChengbenyusuanEntity;
import com.cl.service.ChengbenyusuanService;
import com.cl.entity.view.ChengbenyusuanView;

@Service("chengbenyusuanService")
public class ChengbenyusuanServiceImpl extends ServiceImpl<ChengbenyusuanDao, ChengbenyusuanEntity> implements ChengbenyusuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengbenyusuanEntity> page = this.selectPage(
                new Query<ChengbenyusuanEntity>(params).getPage(),
                new EntityWrapper<ChengbenyusuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengbenyusuanEntity> wrapper) {
		  Page<ChengbenyusuanView> page =new Query<ChengbenyusuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChengbenyusuanView> selectListView(Wrapper<ChengbenyusuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengbenyusuanView selectView(Wrapper<ChengbenyusuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
