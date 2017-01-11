package org.william.dao;

import java.util.List;

import org.william.model.Page;

public interface IBaseDao {
	
	/**
     * 创建一条数据
     * 如果insert语句中有selectKey字句会返回主键。
     *
     * @param param
     * @return 插入成功的主键ID
     */
    public int insert(String sqlId, Object param);

    /**
     * 删除一条数据
     * @param param
     * @return
     */
    public int delete(String sqlId, Object param);

    /**
     * @param param
     * @return
     * @Description 更新一条记录（可带额外数据，额外数据可以为NULL）
     */
    public int update(String sqlId, Object param);

    /**
     * @return
     * @Description 查询单条记录
     */
    public <T> T queryObject(String sqlId, Object param);

    /**
     * @param sqlId
     * @param param
     * @return
     * @Description 查询列表
     */
    public <T> List<T> queryList(String sqlId, Object param);

    /**
     * @param sqlId
     * @param param
     * @param page
     * @return
     * @Description 分页查询
     */
    public <T> Page<T> queryList(String sqlId, Object param, Page<T> page);

    /**
     * 批量删除
     * @param stmtId
     * @param paramList
     * @return
     */
    Integer deleteBatch(final String stmtId, final List paramList);

}
