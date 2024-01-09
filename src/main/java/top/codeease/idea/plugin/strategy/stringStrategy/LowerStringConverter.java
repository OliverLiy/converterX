package top.codeease.idea.plugin.strategy.stringStrategy;

/**
 * @author by: ly
 * @ClassName: LowerStringFormat
 * @Description: 小写转换
 * @Date: 2023/12/21 下午5:21
 */
public class LowerStringConverter implements StringConverterStrategy {
    @Override
    public String execute(String msg) {
        return msg.toLowerCase();
    }
}
