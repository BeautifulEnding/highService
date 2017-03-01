package common;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<T> {
	    // 根据ID加载实体
		T get(Class<T> entityClass ,String id);
		// 保存实体
		Serializable save(T entity);
		// 更新实体
		void update(T entity);
		// 删除实体
		void delete(T entity);
		// 根据ID删除实体
		void delete(Class<T> entityClass , String id);
		// 获取所有实体
		List<T> findAll(Class<T> entityClass);
		// 获取实体总数
		long findCount(Class<T> entityClass);
}
