package zx.soft.words.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zx.soft.words.model.Words;

public interface WordsMapper {
	
	/**
	 * 添加关键词
	 */
	@Insert("insert into `words` (`cate_id`,`name`) values (#{cate_id}, #{name} )")
	public void addWords(Words words);
	
	/**
	 * 删除关键字
	 */
	@Delete("delete FROM `words` WHERE `id` = #{id}")
	public void delWords(int id);
	
	/**
	 * 根据类别查询关键字
	 */
	@Select("select * from `words` where `cate_id` = #{cate_id} ORDER BY id DESC")
	public List<Words> getWords(int cate_id);
	
	/**
	 * 查询所有关键字
	 */
	@Select("select * from `words` ORDER BY id DESC ")
	public List<Words> getAllWords();
	
	/**
	 * 关键词查重
	 */
	@Select("select * from `words` where `name` = #{name}")
	public List<Words> checkWords(Words words);
	
	/**
	 * 修改关键字
	 */
	@Update("update `words` set `name` = #{name} where id = #{id}")
	public void updateWords(Words words);
	

}
