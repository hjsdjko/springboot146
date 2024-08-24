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

import com.cl.entity.XiangmugoutongEntity;
import com.cl.entity.view.XiangmugoutongView;

import com.cl.service.XiangmugoutongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;

/**
 * 项目沟通
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
@RestController
@RequestMapping("/xiangmugoutong")
public class XiangmugoutongController {
    @Autowired
    private XiangmugoutongService xiangmugoutongService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmugoutongEntity xiangmugoutong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xiangmujingli")) {
			xiangmugoutong.setJinglizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiangmugoutongEntity> ew = new EntityWrapper<XiangmugoutongEntity>();


		PageUtils page = xiangmugoutongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmugoutong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangmugoutongEntity xiangmugoutong, 
		HttpServletRequest request){
        EntityWrapper<XiangmugoutongEntity> ew = new EntityWrapper<XiangmugoutongEntity>();

		PageUtils page = xiangmugoutongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmugoutong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmugoutongEntity xiangmugoutong){
       	EntityWrapper<XiangmugoutongEntity> ew = new EntityWrapper<XiangmugoutongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmugoutong, "xiangmugoutong")); 
        return R.ok().put("data", xiangmugoutongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmugoutongEntity xiangmugoutong){
        EntityWrapper< XiangmugoutongEntity> ew = new EntityWrapper< XiangmugoutongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmugoutong, "xiangmugoutong")); 
		XiangmugoutongView xiangmugoutongView =  xiangmugoutongService.selectView(ew);
		return R.ok("查询项目沟通成功").put("data", xiangmugoutongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmugoutongEntity xiangmugoutong = xiangmugoutongService.selectById(id);
		xiangmugoutong = xiangmugoutongService.selectView(new EntityWrapper<XiangmugoutongEntity>().eq("id", id));
        return R.ok().put("data", xiangmugoutong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmugoutongEntity xiangmugoutong = xiangmugoutongService.selectById(id);
		xiangmugoutong = xiangmugoutongService.selectView(new EntityWrapper<XiangmugoutongEntity>().eq("id", id));
        return R.ok().put("data", xiangmugoutong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmugoutongEntity xiangmugoutong, HttpServletRequest request){
    	xiangmugoutong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmugoutong);

        xiangmugoutongService.insert(xiangmugoutong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmugoutongEntity xiangmugoutong, HttpServletRequest request){
    	xiangmugoutong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmugoutong);

        xiangmugoutongService.insert(xiangmugoutong);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmugoutongEntity xiangmugoutong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmugoutong);
        xiangmugoutongService.updateById(xiangmugoutong);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmugoutongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
