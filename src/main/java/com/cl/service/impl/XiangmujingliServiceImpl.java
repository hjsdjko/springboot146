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


import com.cl.dao.XiangmujingliDao;
import com.cl.entity.XiangmujingliEntity;
import com.cl.service.XiangmujingliService;
import com.cl.entity.view.XiangmujingliView;

@Service("xiangmujingliService")
public class XiangmujingliServiceImpl extends ServiceImpl<XiangmujingliDao, XiangmujingliEntity> implements XiangmujingliService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmujingliEntity> page = this.selectPage(
                new Query<XiangmujingliEntity>(params).getPage(),
                new EntityWrapper<XiangmujingliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmujingliEntity> wrapper) {
		  Page<XiangmujingliView> page =new Query<XiangmujingliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiangmujingliView> selectListView(Wrapper<XiangmujingliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmujingliView selectView(Wrapper<XiangmujingliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
