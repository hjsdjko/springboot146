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


import com.cl.dao.XiangmugoutongDao;
import com.cl.entity.XiangmugoutongEntity;
import com.cl.service.XiangmugoutongService;
import com.cl.entity.view.XiangmugoutongView;

@Service("xiangmugoutongService")
public class XiangmugoutongServiceImpl extends ServiceImpl<XiangmugoutongDao, XiangmugoutongEntity> implements XiangmugoutongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmugoutongEntity> page = this.selectPage(
                new Query<XiangmugoutongEntity>(params).getPage(),
                new EntityWrapper<XiangmugoutongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmugoutongEntity> wrapper) {
		  Page<XiangmugoutongView> page =new Query<XiangmugoutongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiangmugoutongView> selectListView(Wrapper<XiangmugoutongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmugoutongView selectView(Wrapper<XiangmugoutongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
