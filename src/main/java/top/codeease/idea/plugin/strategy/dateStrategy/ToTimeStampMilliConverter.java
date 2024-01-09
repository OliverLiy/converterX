package top.codeease.idea.plugin.strategy.dateStrategy;

import top.codeease.idea.plugin.util.MyDateUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

/**
 * @author by: ly
 * @ClassName: ToTimeStampMillConverter
 * @Description:
 * @Date: 2024/1/5 上午11:09
 */
public class ToTimeStampMilliConverter implements DateConverterStrategy{
    @Override
    public String execute(String msg) {
        LocalDateTime localDateTime = MyDateUtils.convertToDateTime(msg);
        if (Objects.isNull(localDateTime)){
            return msg;
        }
        long timestampInMilliseconds = localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        return String.valueOf(timestampInMilliseconds);
    }
}
