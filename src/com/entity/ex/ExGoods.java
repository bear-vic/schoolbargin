/**
 * @description 商品的扩展类
 * @date 2016-8-20
 * @author hxg	
 */
package com.entity.ex;

import org.springframework.web.multipart.MultipartFile;

import com.entity.Goods;

public class ExGoods extends Goods {
	private MultipartFile gPicFile; //图片文件
	private String exDate; //格式化日期

	public MultipartFile getgPicFile() {
		return gPicFile;
	}

	public void setgPicFile(MultipartFile gPicFile) {
		this.gPicFile = gPicFile;
	}

	public String getExDate() {
		return exDate;
	}

	public void setExDate(String exDate) {
		this.exDate = exDate;
	}

}
