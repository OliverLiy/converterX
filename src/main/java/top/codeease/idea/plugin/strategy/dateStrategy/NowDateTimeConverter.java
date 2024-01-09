package top.codeease.idea.plugin.strategy.dateStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author by: ly
 * @ClassName: NowDateTimeConverter
 * @Description:
 * @Date: 2023/12/28 上午11:46
 */
public class NowDateTimeConverter implements DateConverterStrategy{
    @Override
    public String execute(String msg) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
