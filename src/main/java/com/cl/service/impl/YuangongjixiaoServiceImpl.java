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


import com.cl.dao.YuangongjixiaoDao;
import com.cl.entity.YuangongjixiaoEntity;
import com.cl.service.YuangongjixiaoService;
import com.cl.entity.view.YuangongjixiaoView;

@Service("yuangongjixiaoService")
public class YuangongjixiaoServiceImpl extends ServiceImpl<YuangongjixiaoDao, YuangongjixiaoEntity> implements YuangongjixiaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongjixiaoEntity> page = this.selectPage(
                new Query<YuangongjixiaoEntity>(params).getPage(),
                new EntityWrapper<YuangongjixiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongjixiaoEntity> wrapper) {
		  Page<YuangongjixiaoView> page =new Query<YuangongjixiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuangongjixiaoView> selectListView(Wrapper<YuangongjixiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangongjixiaoView selectView(Wrapper<YuangongjixiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
