package top.codeease.idea.plugin.strategy.dateStrategy;

import top.codeease.idea.plugin.util.MyDateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author by: ly
 * @ClassName: ToDateConverter
 * @Description:
 * @Date: 2024/1/5 上午10:28
 */
public class ToDateConverter implements DateConverterStrategy{
    @Override
    public String execute(String msg) {
        LocalDateTime localDateTime = MyDateUtils.convertToDateTime(msg);
        if (Objects.isNull(localDateTime)){
            return msg;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDateTime.format(dateTimeFormatter);
    }
}
