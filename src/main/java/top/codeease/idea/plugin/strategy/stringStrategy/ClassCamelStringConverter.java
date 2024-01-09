package top.codeease.idea.plugin.strategy.stringStrategy;

import top.codeease.idea.plugin.util.MyStringUtils;

import java.util.List;

import static top.codeease.idea.plugin.constant.StringConstant.SPLIT_REGEX;

/**
 * @author by: ly
 * @ClassName: ClassCamelStringFormat
 * @Description: 类名驼峰
 * @Date: 2023/12/22 下午2:21
 */
public class ClassCamelStringConverter implements StringConverterStrategy {
    @Override
    public String execute(String msg) {
        String[] words = msg.split(SPLIT_REGEX);
        StringBuilder result = new StringBuilder();

        for (String  word: words) {
            List<String> splitString = MyStringUtils.splitCamelCase(word);
            for (String string : splitString) {
                if (!string.isEmpty()) {
                    String lowercaseWord = string.toLowerCase();
                    String firstLetter = lowercaseWord.substring(0, 1);
                    String remainingLetters = lowercaseWord.substring(1);
                    result.append(firstLetter.toUpperCase()).append(remainingLetters);
                }
            }
        }
        return result.toString();
    }
}
