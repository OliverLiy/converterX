package top.codeease.idea.plugin.strategy.stringStrategy;

/**
 * @author by: ly
 * @ClassName: UpperStringFormat
 * @Description: 大写转换
 * @Date: 2023/12/21 下午4:04
 */
public class UpperStringConverter implements StringConverterStrategy {
    @Override
    public String execute(String msg) {
        return msg.toUpperCase();
    }
}
