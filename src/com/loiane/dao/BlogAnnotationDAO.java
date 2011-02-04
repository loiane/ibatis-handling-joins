package com.loiane.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.loiane.data.BlogMapper;
import com.loiane.model.Blog;

/**
 * Blog DAO - annotations
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class BlogAnnotationDAO {

	/**
	 * Returns the list of all Contact instances from the database.
	 * @return the list of all Contact instances from the database.
	 */
	public List<Blog> selectAllBlogs(){
		
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			List<Blog> list = mapper.selectAllBlogs();
			
			return list;
		} finally {
			session.close();
		}
	}
}
