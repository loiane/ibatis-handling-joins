package com.loiane.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.loiane.dao.BlogDAO;
import com.loiane.model.Blog;


/**
 * Test Case
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class TestBlogDAO {

	private static BlogDAO blogDAO;

	@BeforeClass
	public static  void runBeforeClass() {
		blogDAO = new BlogDAO();
	}

	@AfterClass
	public static void runAfterClass() {
		blogDAO = null;
	}

	/**
	 * Test method for {@link com.loiane.dao.BlogDAO#select()}.
	 */
	@Test
	public void testSelect() {
		
		List<Blog> list = blogDAO.select();
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		for (Blog blog : list){
			System.out.println(blog.toString());
		}
	}

	/**
	 * Test method for {@link com.loiane.dao.BlogDAO#select()}.
	 */
	@Test
	public void testSelectN1ProblemSolution() {
		
		List<Blog> list = blogDAO.selectN1ProblemSolution();
		
		assertNotNull(list);
		assertEquals(1, list.size());
		
		for (Blog blog : list){
			System.out.println(blog.toString());
		}
	}
	
}
