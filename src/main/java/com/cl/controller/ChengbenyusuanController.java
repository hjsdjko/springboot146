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

import com.cl.entity.ChengbenyusuanEntity;
import com.cl.entity.view.ChengbenyusuanView;

import com.cl.service.ChengbenyusuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;

/**
 * 成本预算
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
@RestController
@RequestMapping("/chengbenyusuan")
public class ChengbenyusuanController {
    @Autowired
    private ChengbenyusuanService chengbenyusuanService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChengbenyusuanEntity chengbenyusuan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xiangmujingli")) {
			chengbenyusuan.setJinglizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChengbenyusuanEntity> ew = new EntityWrapper<ChengbenyusuanEntity>();


		PageUtils page = chengbenyusuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengbenyusuan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChengbenyusuanEntity chengbenyusuan, 
		HttpServletRequest request){
        EntityWrapper<ChengbenyusuanEntity> ew = new EntityWrapper<ChengbenyusuanEntity>();

		PageUtils page = chengbenyusuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengbenyusuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChengbenyusuanEntity chengbenyusuan){
       	EntityWrapper<ChengbenyusuanEntity> ew = new EntityWrapper<ChengbenyusuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chengbenyusuan, "chengbenyusuan")); 
        return R.ok().put("data", chengbenyusuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChengbenyusuanEntity chengbenyusuan){
        EntityWrapper< ChengbenyusuanEntity> ew = new EntityWrapper< ChengbenyusuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chengbenyusuan, "chengbenyusuan")); 
		ChengbenyusuanView chengbenyusuanView =  chengbenyusuanService.selectView(ew);
		return R.ok("查询成本预算成功").put("data", chengbenyusuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengbenyusuanEntity chengbenyusuan = chengbenyusuanService.selectById(id);
		chengbenyusuan = chengbenyusuanService.selectView(new EntityWrapper<ChengbenyusuanEntity>().eq("id", id));
        return R.ok().put("data", chengbenyusuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChengbenyusuanEntity chengbenyusuan = chengbenyusuanService.selectById(id);
		chengbenyusuan = chengbenyusuanService.selectView(new EntityWrapper<ChengbenyusuanEntity>().eq("id", id));
        return R.ok().put("data", chengbenyusuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengbenyusuanEntity chengbenyusuan, HttpServletRequest request){
    	chengbenyusuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengbenyusuan);

        chengbenyusuanService.insert(chengbenyusuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengbenyusuanEntity chengbenyusuan, HttpServletRequest request){
    	chengbenyusuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengbenyusuan);

        chengbenyusuanService.insert(chengbenyusuan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChengbenyusuanEntity chengbenyusuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengbenyusuan);
        chengbenyusuanService.updateById(chengbenyusuan);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengbenyusuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
