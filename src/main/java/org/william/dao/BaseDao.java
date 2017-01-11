package org.william.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.william.model.Page;

@Component
public class BaseDao extends SqlSessionDaoSupport implements IBaseDao{
	
	 // 此处必须手动注入
	@Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }


	@Override
	public int insert(String sqlId, Object param) {
		 return this.getSqlSession().insert(sqlId, param);
	}

	@Override
	public int delete(String sqlId, Object param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sqlId, Object param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T queryObject(String sqlId, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> queryList(String sqlId, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Page<T> queryList(String sqlId, Object param, Page<T> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteBatch(String stmtId, List paramList) {
		// TODO Auto-generated method stub
		return null;
	}


}
