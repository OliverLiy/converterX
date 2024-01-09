package top.codeease.idea.plugin.strategy.dateStrategy;

import top.codeease.idea.plugin.util.MyDateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author by: ly
 * @ClassName: ToTimeConverter
 * @Description:
 * @Date: 2024/1/5 上午10:30
 */
public class ToTimeConverter implements DateConverterStrategy{
    @Override
    public String execute(String msg) {
        LocalDateTime localDateTime = MyDateUtils.convertToDateTime(msg);
        if (Objects.isNull(localDateTime)){
            return msg;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localDateTime.format(dateTimeFormatter);
    }
}
