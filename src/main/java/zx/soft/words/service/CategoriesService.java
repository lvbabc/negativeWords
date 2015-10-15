package zx.soft.words.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import zx.soft.words.dao.CategoriesMapper;
import zx.soft.words.model.Categories;
import zx.soft.words.util.ErrorResponse;

@Service
public class CategoriesService {
	
	@Inject
	private CategoriesMapper categoriesMapper;
	
	private static Logger logger = LoggerFactory.getLogger(CategoriesService.class);
	
	
	public ErrorResponse addCategory(List<Categories> categories){
		for(Categories category : categories){
			if(categoriesMapper.checkCategories(category).size() != 0) {
				return new ErrorResponse.Builder(1, "类别已存在").build();
			}
			categoriesMapper.addCategoory(category);
		}
		logger.info("插入数据成功，共" + categories.size() + "条");
		return new ErrorResponse.Builder(0, "OK").build();
	}
	
	public ErrorResponse delCategory(String cate_ids){
		for(String cate_id : cate_ids.split(",")){
			categoriesMapper.delCategory(Integer.parseInt(cate_id));
		}
		return new ErrorResponse.Builder(0, "OK").build();
	}
	
	public List<Categories> getCategories(){
		return categoriesMapper.getCategories();
	}
	
	public ErrorResponse updateCategory(List<Categories> categories){
		for(Categories category : categories){
			if(categoriesMapper.checkCategories(category).size() != 0) {
				return new ErrorResponse.Builder(1, "更新失败").build();
			}
			categoriesMapper.updateCategory(category);
		}
		return new ErrorResponse.Builder(0, "OK").build();
	}

}
