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
 * 项目进度
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-25 13:22:32
 */
@TableName("xiangmujindu")
public class XiangmujinduEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiangmujinduEntity() {
		
	}
	
	public XiangmujinduEntity(T t) {
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
	 * 项目编号
	 */
					
	private String xiangmubianhao;
	
	/**
	 * 项目名称
	 */
					
	private String xiangmumingcheng;
	
	/**
	 * 开工日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date kaigongriqi;
	
	/**
	 * 开工地址
	 */
					
	private String kaigongdizhi;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	/**
	 * 经理账号
	 */
					
	private String jinglizhanghao;
	
	/**
	 * 经理姓名
	 */
					
	private String jinglixingming;
	
	/**
	 * 项目计划
	 */
					
	private String xiangmujihua;
	
	/**
	 * 分配员工
	 */
					
	private String fenpeiyuangong;
	
	/**
	 * 项目进度
	 */
					
	private String xiangmujindu;
	
	/**
	 * 遇到问题
	 */
					
	private String yudaowenti;
	
	
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
	 * 设置：项目编号
	 */
	public void setXiangmubianhao(String xiangmubianhao) {
		this.xiangmubianhao = xiangmubianhao;
	}
	/**
	 * 获取：项目编号
	 */
	public String getXiangmubianhao() {
		return xiangmubianhao;
	}
	/**
	 * 设置：项目名称
	 */
	public void setXiangmumingcheng(String xiangmumingcheng) {
		this.xiangmumingcheng = xiangmumingcheng;
	}
	/**
	 * 获取：项目名称
	 */
	public String getXiangmumingcheng() {
		return xiangmumingcheng;
	}
	/**
	 * 设置：开工日期
	 */
	public void setKaigongriqi(Date kaigongriqi) {
		this.kaigongriqi = kaigongriqi;
	}
	/**
	 * 获取：开工日期
	 */
	public Date getKaigongriqi() {
		return kaigongriqi;
	}
	/**
	 * 设置：开工地址
	 */
	public void setKaigongdizhi(String kaigongdizhi) {
		this.kaigongdizhi = kaigongdizhi;
	}
	/**
	 * 获取：开工地址
	 */
	public String getKaigongdizhi() {
		return kaigongdizhi;
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
	/**
	 * 设置：经理账号
	 */
	public void setJinglizhanghao(String jinglizhanghao) {
		this.jinglizhanghao = jinglizhanghao;
	}
	/**
	 * 获取：经理账号
	 */
	public String getJinglizhanghao() {
		return jinglizhanghao;
	}
	/**
	 * 设置：经理姓名
	 */
	public void setJinglixingming(String jinglixingming) {
		this.jinglixingming = jinglixingming;
	}
	/**
	 * 获取：经理姓名
	 */
	public String getJinglixingming() {
		return jinglixingming;
	}
	/**
	 * 设置：项目计划
	 */
	public void setXiangmujihua(String xiangmujihua) {
		this.xiangmujihua = xiangmujihua;
	}
	/**
	 * 获取：项目计划
	 */
	public String getXiangmujihua() {
		return xiangmujihua;
	}
	/**
	 * 设置：分配员工
	 */
	public void setFenpeiyuangong(String fenpeiyuangong) {
		this.fenpeiyuangong = fenpeiyuangong;
	}
	/**
	 * 获取：分配员工
	 */
	public String getFenpeiyuangong() {
		return fenpeiyuangong;
	}
	/**
	 * 设置：项目进度
	 */
	public void setXiangmujindu(String xiangmujindu) {
		this.xiangmujindu = xiangmujindu;
	}
	/**
	 * 获取：项目进度
	 */
	public String getXiangmujindu() {
		return xiangmujindu;
	}
	/**
	 * 设置：遇到问题
	 */
	public void setYudaowenti(String yudaowenti) {
		this.yudaowenti = yudaowenti;
	}
	/**
	 * 获取：遇到问题
	 */
	public String getYudaowenti() {
		return yudaowenti;
	}

}
