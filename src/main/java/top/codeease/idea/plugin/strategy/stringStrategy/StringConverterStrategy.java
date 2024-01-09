package top.codeease.idea.plugin.strategy.stringStrategy;

/**
 * @author by: ly
 * @ClassName: StringFormatStrategy
 * @Description: 字符串转换策略
 * @Date: 2023/12/21 下午4:01
 */
public interface StringConverterStrategy {

    /**
     * 字符串转换
     * @param msg
     * @return
     */
    String execute(String msg);
}
