package top.codeease.idea.plugin.strategy.jsonStrategy;

/**
 * @author by: ly
 * @ClassName: JsonRemoveEscapingConverter
 * @Description: JSON去除转义
 * @Date: 2024/1/8 下午4:14
 */
public class JsonRemoveEscapingConverter implements JsonConverterStrategy{
    @Override
    public String execute(String msg) {
        return msg.replace("\\", "");
    }
}
