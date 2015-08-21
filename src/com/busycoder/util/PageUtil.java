package com.busycoder.util;

public final class PageUtil {	
	private int pageSize; //ÿҳ��ʾ����
	private int recordCount; //��¼���� 
	private int currentPage; //��ǰҳ
        
	public PageUtil(int pageSize, int recordCount, int currentPage) {
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		setCurrentPage(currentPage);
	}

	public PageUtil(int pageSize, int recordCount) {
		this(pageSize, recordCount, 1);
	}
	
	public int getRecordCount() {
		return recordCount;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * ���õ�ǰҳ��
	 */
	public void setCurrentPage(int currentPage) {
		currentPage = (currentPage < 1) ? 1 : currentPage;
		currentPage = (currentPage > getPageCount()) ? getPageCount() : currentPage;
		this.currentPage = currentPage;
	}
	
	/**
	 * ��õ�ǰҳ����һҳ
	 * @return
	 */
	public int getNextPage(){
		int nextPage = currentPage + 1;
		if(nextPage > getPageCount()) {
                return getPageCount();
            }
		return nextPage;
	}
	
	/**
	 * ��õ�ǰҳ��ǰһҳ
	 * @return
	 */
	public int getPrevPage(){
		int prevPage = currentPage - 1;
		if(prevPage < 1) {
                prevPage = 1;
            }
		return prevPage;		
	}
	
	/**
	 * ���ҳ������
	 * @return
	 */
	public int getPageCount(){
		int pageCount = recordCount / pageSize;  //��ҳ��
		if(recordCount % pageSize > 0) {
                pageCount++;
            }
		return pageCount;
	}
	
	/**
	 * ��ʾ�������ʼ����, ������0��ʼ�� ������ʼ����
	 * @return
	 */
	public int getFromIndex(){
		int fromIndex = (currentPage-1) * pageSize; //ȡ�����������Ҫ��ʾ�����ݵĿ�ʼ����
		fromIndex = (fromIndex < 0) ? 0 : fromIndex;
		return fromIndex;		
	}
	
	/**
	 * ��ʾ����Ľ�������, ������0��ʼ�� ��������������
	 * @return
	 */
	public int getToIndex(){
		int toIndex = currentPage * pageSize; //ȡ�����������Ҫ��ʾ�����ݵĽ��������� ��������������
		toIndex = (toIndex > recordCount) ? recordCount : toIndex;
		return toIndex;
	}
}