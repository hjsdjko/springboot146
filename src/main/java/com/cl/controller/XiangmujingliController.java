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

import com.cl.entity.XiangmujingliEntity;
import com.cl.entity.view.XiangmujingliView;

import com.cl.service.XiangmujingliService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;

/**
 * 项目经理
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
@RestController
@RequestMapping("/xiangmujingli")
public class XiangmujingliController {
    @Autowired
    private XiangmujingliService xiangmujingliService;





    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		XiangmujingliEntity u = xiangmujingliService.selectOne(new EntityWrapper<XiangmujingliEntity>().eq("jinglizhanghao", username));
        if(u==null || !u.getJinglimima().equals(EncryptUtil.md5(password))) {
            return R.error("账号或密码不正确");
        }

		String token = tokenService.generateToken(u.getId(), username,"xiangmujingli",  "项目经理" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XiangmujingliEntity xiangmujingli){
    	//ValidatorUtils.validateEntity(xiangmujingli);
    	XiangmujingliEntity u = xiangmujingliService.selectOne(new EntityWrapper<XiangmujingliEntity>().eq("jinglizhanghao", xiangmujingli.getJinglizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		xiangmujingli.setId(uId);
        xiangmujingli.setJinglimima(EncryptUtil.md5(xiangmujingli.getJinglimima()));
        xiangmujingliService.insert(xiangmujingli);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        XiangmujingliEntity u = xiangmujingliService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	XiangmujingliEntity u = xiangmujingliService.selectOne(new EntityWrapper<XiangmujingliEntity>().eq("jinglizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setJinglimima(EncryptUtil.md5("123456"));
        xiangmujingliService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmujingliEntity xiangmujingli, 
		HttpServletRequest request){

        EntityWrapper<XiangmujingliEntity> ew = new EntityWrapper<XiangmujingliEntity>();


		PageUtils page = xiangmujingliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujingli), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangmujingliEntity xiangmujingli, 
		HttpServletRequest request){
        EntityWrapper<XiangmujingliEntity> ew = new EntityWrapper<XiangmujingliEntity>();

		PageUtils page = xiangmujingliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujingli), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmujingliEntity xiangmujingli){
       	EntityWrapper<XiangmujingliEntity> ew = new EntityWrapper<XiangmujingliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmujingli, "xiangmujingli")); 
        return R.ok().put("data", xiangmujingliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmujingliEntity xiangmujingli){
        EntityWrapper< XiangmujingliEntity> ew = new EntityWrapper< XiangmujingliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmujingli, "xiangmujingli")); 
		XiangmujingliView xiangmujingliView =  xiangmujingliService.selectView(ew);
		return R.ok("查询项目经理成功").put("data", xiangmujingliView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectById(id);
		xiangmujingli = xiangmujingliService.selectView(new EntityWrapper<XiangmujingliEntity>().eq("id", id));
        return R.ok().put("data", xiangmujingli);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectById(id);
		xiangmujingli = xiangmujingliService.selectView(new EntityWrapper<XiangmujingliEntity>().eq("id", id));
        return R.ok().put("data", xiangmujingli);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmujingliEntity xiangmujingli, HttpServletRequest request){
    	xiangmujingli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmujingli);
    	XiangmujingliEntity u = xiangmujingliService.selectOne(new EntityWrapper<XiangmujingliEntity>().eq("jinglizhanghao", xiangmujingli.getJinglizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}

		xiangmujingli.setId(new Date().getTime());
        xiangmujingli.setJinglimima(EncryptUtil.md5(xiangmujingli.getJinglimima()));
        xiangmujingliService.insert(xiangmujingli);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmujingliEntity xiangmujingli, HttpServletRequest request){
    	xiangmujingli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiangmujingli);
    	XiangmujingliEntity u = xiangmujingliService.selectOne(new EntityWrapper<XiangmujingliEntity>().eq("jinglizhanghao", xiangmujingli.getJinglizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}

		xiangmujingli.setId(new Date().getTime());
        xiangmujingli.setJinglimima(EncryptUtil.md5(xiangmujingli.getJinglimima()));
        xiangmujingliService.insert(xiangmujingli);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmujingliEntity xiangmujingli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujingli);
        XiangmujingliEntity xiangmujingliEntity = xiangmujingliService.selectById(xiangmujingli.getId());
        if(StringUtils.isNotBlank(xiangmujingli.getJinglimima()) && !xiangmujingli.getJinglimima().equals(xiangmujingliEntity.getJinglimima())) {
            xiangmujingli.setJinglimima(EncryptUtil.md5(xiangmujingli.getJinglimima()));
        }
        xiangmujingliService.updateById(xiangmujingli);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmujingliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
