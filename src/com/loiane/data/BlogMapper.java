package com.loiane.data;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.loiane.model.Author;
import com.loiane.model.Blog;
import com.loiane.model.Post;

/**
 * Blog Mapper contains all the myBatis/iBatis annotations
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public interface BlogMapper {

	final String SELECT_POSTS = "SELECT  P.idPost as idPost, P.title as title, T.idTag as idTag, T.value as value " +
			"FROM Post P left outer join Post_Tag PT on P.idPost = PT.idPost " +
			"left outer join Tag T on PT.idTag = T.idTag WHERE P.idBlog = #{idBlog}";
	
	/**
	 * Returns the list of all Blog instances from the database.
	 * @return the list of all Blog instances from the database.
	 */
	@Select("SELECT idBlog, name as blogname, url as blogurl FROM BLOG")
	@Results(value = {
		@Result(property="id", column="idBlog"),
		@Result(property="name", column="blogname"),
		@Result(property="url", column="blogurl"),
		@Result(property="author", column="idBlog", javaType=Author.class, one=@One(select="selectAuthor")),
		@Result(property="posts", column="idBlog", javaType=List.class, many=@Many(select="selectBlogPosts"))
	})
	List<Blog> selectAllBlogs();
	
	/**
	 * Returns the list of all Author instances from the database of a Blog
	 * @param idBlog
	 * @return the list of all Author instances from the database of a Blog
	 */
	@Select("SELECT idAuthor as id, name, email FROM AUTHOR WHERE idBlog = #{idBlog}")
	Author selectAuthor(String idBlog);
	
	/**
	 * Returns the list of all Post instances from the database of a Blog
	 * @param idBlog
	 * @return the list of all Post instances from the database of a Blog
	 */
	@Select(SELECT_POSTS)
	@Results(value = {
		@Result(property="id", column="idPost"),
		@Result(property="title", column="title"),
		@Result(property="tags", column="idPost", javaType=List.class, many=@Many)
	})
	List<Post> selectBlogPosts(String idBlog);
	
}
