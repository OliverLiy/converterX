package top.codeease.idea.plugin.strategy.dateStrategy;

/**
 * @author by: ly
 * @ClassName: DateConverterStrategy
 * @Description: 日期转换策略类
 * @Date: 2023/12/28 上午11:42
 */
public interface DateConverterStrategy {
    /**
     * 日期时间转换
     * @param msg
     * @return
     */
    String execute(String msg);
}
