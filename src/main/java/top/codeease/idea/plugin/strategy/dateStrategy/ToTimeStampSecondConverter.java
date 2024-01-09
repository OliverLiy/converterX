package top.codeease.idea.plugin.strategy.dateStrategy;

import top.codeease.idea.plugin.util.MyDateUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.time.LocalDateTime;
import java.time.Instant;

/**
 * @author by: ly
 * @ClassName: ToTimeStampConverter
 * @Description:
 * @Date: 2024/1/5 上午10:56
 */
public class ToTimeStampSecondConverter implements DateConverterStrategy{
    @Override
    public String execute(String msg) {
        LocalDateTime localDateTime = MyDateUtils.convertToDateTime(msg);
        if (Objects.isNull(localDateTime)){
            return msg;
        }
        long timestampInSeconds = localDateTime.toEpochSecond(ZoneOffset.UTC);
        return String.valueOf(timestampInSeconds);
    }
}
