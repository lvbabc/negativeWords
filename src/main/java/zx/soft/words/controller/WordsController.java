package zx.soft.words.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import zx.soft.words.model.Words;
import zx.soft.words.service.WordsService;

@Controller
@RequestMapping("/words")
public class WordsController {
	
	@Inject
	private WordsService wordsService;
	
	/**
	 * 添加关键词
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object addWords(@RequestBody List<Words> words) {
		return wordsService.addWords(words);
	}
	
	/**
	 * 删除关键词
	 */
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object delWords(@PathVariable String id) {
		return wordsService.delWords(id);
	}
	
	/**
	 * 按照分类查询关键词
	 */
	@RequestMapping(value = "/{cate_id}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Words> getWords(@PathVariable String cate_id) {
		return wordsService.getWords(cate_id);
	}
	
	/**
	 * 查询所有关键词
	 */
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Words> getAllWords() {
		return wordsService.getAllWords();
	}
	
	/**
	 * 修改关键字
	 */
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object updateWords(@RequestBody List<Words> words) {
		return wordsService.updateWords(words);
	}
	

}
