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


import com.cl.dao.GoutonghuifuDao;
import com.cl.entity.GoutonghuifuEntity;
import com.cl.service.GoutonghuifuService;
import com.cl.entity.view.GoutonghuifuView;

@Service("goutonghuifuService")
public class GoutonghuifuServiceImpl extends ServiceImpl<GoutonghuifuDao, GoutonghuifuEntity> implements GoutonghuifuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoutonghuifuEntity> page = this.selectPage(
                new Query<GoutonghuifuEntity>(params).getPage(),
                new EntityWrapper<GoutonghuifuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoutonghuifuEntity> wrapper) {
		  Page<GoutonghuifuView> page =new Query<GoutonghuifuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GoutonghuifuView> selectListView(Wrapper<GoutonghuifuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoutonghuifuView selectView(Wrapper<GoutonghuifuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
