package zx.soft.words.driver;

import zx.soft.utils.driver.ProgramDriver;
import zx.soft.words.api.WordsApiApplication;

public class WordsApiDriver {

	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		int exitCode = -1;
		ProgramDriver pgd = new ProgramDriver();
		try {
			// 运行在hefei07机器上
			pgd.addClass("wordsApiApplication", WordsApiApplication.class, "负面词库CURD接口服务");
			pgd.driver(args);
			// Success
			exitCode = 0;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}

		System.exit(exitCode);
	}

}
