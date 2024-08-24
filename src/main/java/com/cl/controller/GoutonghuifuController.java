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

import com.cl.entity.GoutonghuifuEntity;
import com.cl.entity.view.GoutonghuifuView;

import com.cl.service.GoutonghuifuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;

/**
 * 沟通回复
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
@RestController
@RequestMapping("/goutonghuifu")
public class GoutonghuifuController {
    @Autowired
    private GoutonghuifuService goutonghuifuService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GoutonghuifuEntity goutonghuifu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xiangmujingli")) {
			goutonghuifu.setJinglizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GoutonghuifuEntity> ew = new EntityWrapper<GoutonghuifuEntity>();


		PageUtils page = goutonghuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goutonghuifu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GoutonghuifuEntity goutonghuifu, 
		HttpServletRequest request){
        EntityWrapper<GoutonghuifuEntity> ew = new EntityWrapper<GoutonghuifuEntity>();

		PageUtils page = goutonghuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goutonghuifu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GoutonghuifuEntity goutonghuifu){
       	EntityWrapper<GoutonghuifuEntity> ew = new EntityWrapper<GoutonghuifuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goutonghuifu, "goutonghuifu")); 
        return R.ok().put("data", goutonghuifuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GoutonghuifuEntity goutonghuifu){
        EntityWrapper< GoutonghuifuEntity> ew = new EntityWrapper< GoutonghuifuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goutonghuifu, "goutonghuifu")); 
		GoutonghuifuView goutonghuifuView =  goutonghuifuService.selectView(ew);
		return R.ok("查询沟通回复成功").put("data", goutonghuifuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GoutonghuifuEntity goutonghuifu = goutonghuifuService.selectById(id);
		goutonghuifu = goutonghuifuService.selectView(new EntityWrapper<GoutonghuifuEntity>().eq("id", id));
        return R.ok().put("data", goutonghuifu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GoutonghuifuEntity goutonghuifu = goutonghuifuService.selectById(id);
		goutonghuifu = goutonghuifuService.selectView(new EntityWrapper<GoutonghuifuEntity>().eq("id", id));
        return R.ok().put("data", goutonghuifu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoutonghuifuEntity goutonghuifu, HttpServletRequest request){
    	goutonghuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goutonghuifu);

        goutonghuifuService.insert(goutonghuifu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GoutonghuifuEntity goutonghuifu, HttpServletRequest request){
    	goutonghuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goutonghuifu);

        goutonghuifuService.insert(goutonghuifu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GoutonghuifuEntity goutonghuifu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(goutonghuifu);
        goutonghuifuService.updateById(goutonghuifu);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        goutonghuifuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
