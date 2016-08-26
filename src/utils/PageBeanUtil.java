/**
 * @description 一个分页帮助类
 * @date 2016-8-21
 * @author hxg	
 */
package utils;

public class PageBeanUtil {
	private int showCount;// 设置为单数
	private int leftCount;
	private int rightCount;
	private int firstCount;

	public PageBeanUtil(int showCount) {
		this.showCount = showCount;
		leftCount = (showCount - 1) / 2;
		rightCount = (showCount - 1) / 2;
		firstCount = showCount - 1;
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getLeftCount() {
		return leftCount;
	}

	public void setLeftCount(int leftCount) {
		this.leftCount = leftCount;
	}

	public int getRightCount() {
		return rightCount;
	}

	public void setRightCount(int rightCount) {
		this.rightCount = rightCount;
	}

	public int getFirstCount() {
		return firstCount;
	}

	public void setFirstCount(int firstCount) {
		this.firstCount = firstCount;
	}

	@Override
	public String toString() {
		return "PageBeanUtil [showCount=" + showCount + ", leftCount="
				+ leftCount + ", rightCount=" + rightCount + ", firstCount="
				+ firstCount + "]";
	}

}
