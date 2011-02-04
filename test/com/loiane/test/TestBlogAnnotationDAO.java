package com.loiane.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.loiane.dao.BlogAnnotationDAO;
import com.loiane.model.Blog;

/**
 * Test Case
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class TestBlogAnnotationDAO {

	private static BlogAnnotationDAO blogAnnotationDAO;

	@BeforeClass
	public static  void runBeforeClass() {
		blogAnnotationDAO = new BlogAnnotationDAO();
	}

	@AfterClass
	public static void runAfterClass() {
		blogAnnotationDAO = null;
	}

	/**
	 * Test method for {@link com.loiane.dao.BlogAnnotationDAO#selectAllBlogs()}.
	 */
	@Test
	public void testSelectAllBlogs() {
		
		List<Blog> list = blogAnnotationDAO.selectAllBlogs();
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		for (Blog blog : list){
			System.out.println(blog.toString());
		}
	}

}
