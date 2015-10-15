package zx.soft.words.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zx.soft.words.model.Categories;

public interface CategoriesMapper {
	
	/**
	 * 添加单个类别
	 */
	@Insert("insert into `categories` (`name`) values ( #{name} )")
	public void addCategoory(Categories categories);
	
	/**
	 * 删除单个类别
	 */
	@Delete("delete FROM `categories` WHERE cate_id = #{cate_id}")
	public void delCategory(int cate_id);
	
	/**
	 * 按照name查询
	 */
	@Select("select * from `categories` where name = #{name}")
	public List<Categories> checkCategories(Categories categories);
	
	/**
	 * 查询所有类别
	 */
	@Select("select * from `categories` ORDER BY cate_id DESC ")
	public List<Categories> getCategories();
	
	/**
	 * 修改单个类别
	 */
	@Update("update `categories` set name = #{name} where cate_id = #{cate_id}")
	public void updateCategory(Categories categories);

}
