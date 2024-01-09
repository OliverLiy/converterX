package top.codeease.idea.plugin.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by: ly
 * @ClassName: MyStringUtils
 * @Description: String的工具类
 * @Date: 2023/12/22 下午4:26
 */
public class MyStringUtils {
    public static List<String> splitCamelCase(String input) {
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) {
                if (currentWord.length() > 0 && i > 0 && !Character.isUpperCase(input.charAt(i - 1))) {
                    words.add(currentWord.toString());
                    currentWord.setLength(0);
                }
                currentWord.append(c);
            } else {
                currentWord.append(c);
            }
        }

        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        return words;
    }
}
