package top.codeease.idea.plugin.strategy.stringStrategy;

import top.codeease.idea.plugin.util.MyStringUtils;

import java.util.ArrayList;
import java.util.List;

import static top.codeease.idea.plugin.constant.StringConstant.SPLIT_REGEX;

/**
 * @author by: ly
 * @ClassName: UnderlineLowerStringFormat
 * @Description: 下划线小写
 * @Date: 2023/12/22 下午3:56
 */
public class UnderlineLowerStringConverter implements StringConverterStrategy {
    @Override
    public String execute(String msg) {
        String[] words = msg.split(SPLIT_REGEX);
        List<String> resultList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()){
                List<String> strings = MyStringUtils.splitCamelCase(word);
                for (String string : strings) {
                    resultList.add(string.toLowerCase());
                }
            }
        }
        return String.join("_", resultList);
    }
}
