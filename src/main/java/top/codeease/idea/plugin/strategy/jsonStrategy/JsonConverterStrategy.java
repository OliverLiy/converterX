package top.codeease.idea.plugin.strategy.jsonStrategy;

/**
 * @author by: ly
 * @ClassName: JsonConverterStrategy
 * @Description: Json转换策略类
 * @Date: 2024/1/5 上午11:32
 */
public interface JsonConverterStrategy {
    /**
     * Json格式转换
     * @param msg
     * @return
     */
    String execute(String msg);
}
