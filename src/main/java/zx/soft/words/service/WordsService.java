package zx.soft.words.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import zx.soft.words.dao.WordsMapper;
import zx.soft.words.model.Words;
import zx.soft.words.util.ErrorResponse;

@Service
public class WordsService {
	
	@Inject
	private WordsMapper wordsMapper;
	
	private static Logger logger = LoggerFactory.getLogger(WordsService.class);
	
	/**
	 * 添加关键词
	 * @param words
	 */
	public ErrorResponse addWords(List<Words> words) {
		for (Words word : words) {
			if (wordsMapper.checkWords(word).size() != 0) {
				return new ErrorResponse.Builder(1, "关键词已存在").build();
			}
			wordsMapper.addWords(word);
		}
		logger.info("插入数据成功，共" + words.size() + "条");
		return new ErrorResponse.Builder(0, "OK").build();
	}
	
	/**
	 * 删除关键词
	 */
	public ErrorResponse delWords(String ids) {
		for (String id : ids.split(",")) {
			wordsMapper.delWords(Integer.parseInt(id));
		}
		return new ErrorResponse.Builder(0, "OK").build();
	}
	
	/**
	 * 查询关键字
	 */
	public List<Words> getWords(String cate_id) {
		return wordsMapper.getWords(Integer.parseInt(cate_id));
	}
	
	/**
	 * 查询所有关键字
	 */
	public List<Words> getAllWords() {
		return wordsMapper.getAllWords();
	}
	
	/**
	 * 更新关键字
	 */
	public ErrorResponse updateWords (List<Words> words) {
		for (Words word : words) {
			if (wordsMapper.checkWords(word).size() != 0) {
				return new ErrorResponse.Builder(1, "关键词已存在").build();
			}
			wordsMapper.updateWords(word);
		}
		return new ErrorResponse.Builder(0, "OK").build();
	}

}
