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


import com.cl.dao.XiangmujinduDao;
import com.cl.entity.XiangmujinduEntity;
import com.cl.service.XiangmujinduService;
import com.cl.entity.view.XiangmujinduView;

@Service("xiangmujinduService")
public class XiangmujinduServiceImpl extends ServiceImpl<XiangmujinduDao, XiangmujinduEntity> implements XiangmujinduService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmujinduEntity> page = this.selectPage(
                new Query<XiangmujinduEntity>(params).getPage(),
                new EntityWrapper<XiangmujinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmujinduEntity> wrapper) {
		  Page<XiangmujinduView> page =new Query<XiangmujinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiangmujinduView> selectListView(Wrapper<XiangmujinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmujinduView selectView(Wrapper<XiangmujinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
