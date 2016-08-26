/**
 * @description 分页
 * @date 2016-8-21
 * @author hxg	
 */
package com.entity.ex;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@SuppressWarnings("serial")
public class PageBean<T> implements Serializable {
	private int pageNow;// 当前页
	private int pageSize;// 每页记录数
	public int totalCount;// 总记录数
	private int totalPage;// 总页数
	private int startPos; // 开始位置，从0开始
	private boolean hasPre;// 是否有前一页
	private boolean hasNext;// 是否有下一页
	private PageTag pageTag;// 标签页
	private List<T> tList;// 分页实际集合
	static final int TAG_SHOW_COUNT = 5;// 默认pagetag为5个

	/**
	 * 通过构造函数 传入 总记录数 和 当前页
	 * 
	 * @param totalCount
	 *            总记录数
	 * @param pageNow
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 */
	public PageBean(int totalCount, int pageNow, int pageSize) {
		this.totalCount = totalCount;
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		init();
	}

	/**
	 * @return void
	 * @param
	 */
	private void init() {
		this.totalPage = obtainTotalPage();
		this.startPos = obtainStartPos();
		this.hasPre = obtainHasPre();
		this.hasNext = obtainHasNext();
		// 给pagebean添加标签页
		pageTag = new PageTag(pageNow, TAG_SHOW_COUNT, totalPage);
	}

	/**
	 * 取得总页数，总页数=总记录数/总页数
	 * 
	 * @return
	 */
	public int obtainTotalPage() {
		double x = (double)getTotalCount() / getPageSize();
		if (x <= 0) {
			x = 1;
		} else {
			x =  Math.ceil(x);
		}
		return (int) x;
	}

	/**
	 * 是否有下一页
	 * 
	 * @return
	 */
	public boolean obtainHasNext() {
		return (pageNow < totalPage && pageNow >= 1) ? true : false;
	}

	/**
	 * 取得选择记录的初始位置
	 * 
	 * @return
	 */
	public int obtainStartPos() {
		return (pageNow - 1) * pageSize;
	}

	/**
	 * 是否有首页
	 * 
	 * @return
	 */
	public boolean obtainHasPre() {
		return (pageNow > 1 && pageNow <= totalPage) ? true : false;
	}

	public int getPageNow() {
		return pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPos() {
		return startPos;
	}

	public boolean isHasPre() {
		return hasPre;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public PageTag getPageTag() {
		return pageTag;
	}

	public List<T> gettList() {
		return tList;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public void setPageTag(PageTag pageTag) {
		this.pageTag = pageTag;
	}

	public void settList(List<T> tList) {
		this.tList = tList;
	}

	@Override
	public String toString() {
		return "PageBean [pageNow=" + pageNow + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", totalPage=" + totalPage
				+ ", startPos=" + startPos + ", hasPre=" + hasPre
				+ ", hasNext=" + hasNext + ", pageTag=" + pageTag + ", tList="
				+ tList + "]";
	}

}
