package com.carl.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * controller向前端页面返回的分页数据结构,为了满足datatables框架
 * 
 * @ClassName: ReturnData
 * @Description: TODO
 */
public class PageData {
	/**
	 * 分页计数器
	 */
	private int draw;
	/**
	 * 总共记录数
	 */
	private int recordsTotal;
	/**
	 * 返回的记录数
	 */
	private int recordsFiltered;

    /**
     * 错误代码
     */
    protected int errorCode;

    /**
     * 错误信息
     */
    protected String errorString;

    /**
     * 业务数据对象
     */
    protected Map<String, Object> dataBody;
    
    
    /**
     * 给json序列化时使用
     */
    public PageData() {
    }

    /**
     * 创建一个新的实例 ReturnData.
     * 
     * @param errorInfo
     *            错误代码
     */
    public PageData(Code errorInfo) {
        this.dataBody = new HashMap<String, Object>();
        this.errorCode = errorInfo.getCode();
        this.errorString = errorInfo.getMsg();
        // TODO: 这里需要从常亮中得到错误代码所对应的的错误信息，错误代码不存在，错误信息返回“未知错误”
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    public Map<String, Object> getDataBody() {
        return dataBody;
    }

    public void setDataBody(Map<String, Object> dataBody) {
        this.dataBody = dataBody;
    }

	/**
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}

	/**
	 * @param draw the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}

	/**
	 * @return the recordsTotal
	 */
	public int getRecordsTotal() {
		return recordsTotal;
	}

	/**
	 * @param recordsTotal the recordsTotal to set
	 */
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	/**
	 * @return the recordsFiltered
	 */
	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	/**
	 * @param recordsFiltered the recordsFiltered to set
	 */
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
    
    

}
