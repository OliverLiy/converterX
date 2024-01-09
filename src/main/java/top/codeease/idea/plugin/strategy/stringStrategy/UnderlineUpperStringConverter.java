package top.codeease.idea.plugin.strategy.stringStrategy;

import top.codeease.idea.plugin.util.MyStringUtils;

import java.util.ArrayList;
import java.util.List;

import static top.codeease.idea.plugin.constant.StringConstant.SPLIT_REGEX;

/**
 * @author by: ly
 * @ClassName: ConstantUpperStringFormat
 * @Description: 转常量大写
 * @Date: 2023/12/22 下午2:10
 */
public class UnderlineUpperStringConverter implements StringConverterStrategy {
    @Override
    public String execute(String msg) {
        String[] words = msg.split(SPLIT_REGEX);
        List<String> resultList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()){
                List<String> strings = MyStringUtils.splitCamelCase(word);
                for (String string : strings) {
                    resultList.add(string.toUpperCase());
                }
            }
        }
        return String.join("_", resultList);
    }
}
