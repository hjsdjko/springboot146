package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YuangongjixiaoEntity;
import com.cl.entity.view.YuangongjixiaoView;

import com.cl.service.YuangongjixiaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;

/**
 * 员工绩效
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
@RestController
@RequestMapping("/yuangongjixiao")
public class YuangongjixiaoController {
    @Autowired
    private YuangongjixiaoService yuangongjixiaoService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongjixiaoEntity yuangongjixiao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangongjixiao.setYuangongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();


		PageUtils page = yuangongjixiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongjixiao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongjixiaoEntity yuangongjixiao, 
		HttpServletRequest request){
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();

		PageUtils page = yuangongjixiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongjixiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongjixiaoEntity yuangongjixiao){
       	EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongjixiao, "yuangongjixiao")); 
        return R.ok().put("data", yuangongjixiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongjixiaoEntity yuangongjixiao){
        EntityWrapper< YuangongjixiaoEntity> ew = new EntityWrapper< YuangongjixiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongjixiao, "yuangongjixiao")); 
		YuangongjixiaoView yuangongjixiaoView =  yuangongjixiaoService.selectView(ew);
		return R.ok("查询员工绩效成功").put("data", yuangongjixiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongjixiaoEntity yuangongjixiao = yuangongjixiaoService.selectById(id);
		yuangongjixiao = yuangongjixiaoService.selectView(new EntityWrapper<YuangongjixiaoEntity>().eq("id", id));
        return R.ok().put("data", yuangongjixiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongjixiaoEntity yuangongjixiao = yuangongjixiaoService.selectById(id);
		yuangongjixiao = yuangongjixiaoService.selectView(new EntityWrapper<YuangongjixiaoEntity>().eq("id", id));
        return R.ok().put("data", yuangongjixiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongjixiaoEntity yuangongjixiao, HttpServletRequest request){
    	yuangongjixiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongjixiao);

        yuangongjixiaoService.insert(yuangongjixiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongjixiaoEntity yuangongjixiao, HttpServletRequest request){
    	yuangongjixiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongjixiao);

        yuangongjixiaoService.insert(yuangongjixiao);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangongjixiaoEntity yuangongjixiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongjixiao);
        yuangongjixiaoService.updateById(yuangongjixiao);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongjixiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
