/**
 * @description 分页中的页码
 * @date 2016-8-22
 * @author hxg	
 */
package com.entity.ex;

import java.io.Serializable;

public class PageTag implements Serializable {
	//
	private static final long serialVersionUID = 6973324092976008761L;
	private int current;
	private int showCount;
	private int totalPage;
	private int left;
	private int right;

	/**
	 * @param current
	 *            当前标签页
	 * @param showCount
	 *            展示的标签总数，最好设置为奇数
	 * @param totalPage
	 *            总的标签页
	 * */
	public PageTag(int current, int showCount, int totalPage) {
		this.current = current;
		this.showCount = showCount;
		this.totalPage = totalPage;
		init();
	}

	/**
	 * @return void
	 * @param
	 */
	private void init() {
		int avg = (showCount - 1) / 2;
		if (totalPage <= showCount) {
			left = 1;
			right = totalPage;
		} else if (current < showCount - avg) {
			left = 1;
			right = showCount;
		} else if (current <= totalPage - avg) {
			left = current - avg;
			right = current + avg;
		} else {
			left = totalPage - showCount + 1;
			right = totalPage;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrent() {
		return current;
	}

	public int getShowCount() {
		return showCount;
	}

	public int getLeftCount() {
		return left;
	}

	public int getRightCount() {
		return right;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public void setLeftCount(int leftCount) {
		this.left = leftCount;
	}

	public void setRightCount(int rightCount) {
		this.right = rightCount;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public void setRight(int right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "PageTag [current=" + current + ", showCount=" + showCount
				+ ", left=" + left + ", right=" + right + "]";
	}

}
