package top.codeease.idea.plugin.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author by: ly
 * @ClassName: MyDateUtils
 * @Description: 时间日期工具类
 * @Date: 2024/1/4 上午10:57
 */
public class MyDateUtils {
    public static LocalDateTime convertToDateTime(String input) {
        try {
            long timestamp = Long.parseLong(input);
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.UTC);
        } catch (NumberFormatException e) {
            // 输入不是时间戳，继续解析为日期时间格式
        }

        DateTimeFormatter[] formatters = {
                // 添加更多的日期时间格式化器，按优先级顺序排列
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),

        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                // 解析失败，继续尝试下一个格式化器
            }
        }

        // 输入不符合任何日期时间格式，返回null或抛出异常，根据需求自行处理
        return null;
    }
}
