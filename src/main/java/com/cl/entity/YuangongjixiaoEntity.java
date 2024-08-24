package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 员工绩效
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
@TableName("yuangongjixiao")
public class YuangongjixiaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuangongjixiaoEntity() {
		
	}
	
	public YuangongjixiaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 年月份
	 */
					
	private String nianyuefen;
	
	/**
	 * 员工账号
	 */
					
	private String yuangongzhanghao;
	
	/**
	 * 员工姓名
	 */
					
	private String yuangongxingming;
	
	/**
	 * 员工绩效
	 */
					
	private Double yuangongjixiao;
	
	/**
	 * 绩效详情
	 */
					
	private String jixiaoxiangqing;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：年月份
	 */
	public void setNianyuefen(String nianyuefen) {
		this.nianyuefen = nianyuefen;
	}
	/**
	 * 获取：年月份
	 */
	public String getNianyuefen() {
		return nianyuefen;
	}
	/**
	 * 设置：员工账号
	 */
	public void setYuangongzhanghao(String yuangongzhanghao) {
		this.yuangongzhanghao = yuangongzhanghao;
	}
	/**
	 * 获取：员工账号
	 */
	public String getYuangongzhanghao() {
		return yuangongzhanghao;
	}
	/**
	 * 设置：员工姓名
	 */
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
	/**
	 * 设置：员工绩效
	 */
	public void setYuangongjixiao(Double yuangongjixiao) {
		this.yuangongjixiao = yuangongjixiao;
	}
	/**
	 * 获取：员工绩效
	 */
	public Double getYuangongjixiao() {
		return yuangongjixiao;
	}
	/**
	 * 设置：绩效详情
	 */
	public void setJixiaoxiangqing(String jixiaoxiangqing) {
		this.jixiaoxiangqing = jixiaoxiangqing;
	}
	/**
	 * 获取：绩效详情
	 */
	public String getJixiaoxiangqing() {
		return jixiaoxiangqing;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}

}
