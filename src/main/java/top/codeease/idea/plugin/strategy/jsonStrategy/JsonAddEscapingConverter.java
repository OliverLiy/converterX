package top.codeease.idea.plugin.strategy.jsonStrategy;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author by: ly
 * @ClassName: JsonAddEscapingConverter
 * @Description: Json增加转义
 * @Date: 2024/1/9 下午1:40
 */
public class JsonAddEscapingConverter implements JsonConverterStrategy{
    @Override
    public String execute(String msg) {
        return escapeJsonString(msg);
    }

    public static String escapeJsonString(String jsonString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < jsonString.length(); i++) {
            char c = jsonString.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }

        return sb.toString();
    }
}
