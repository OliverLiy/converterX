package top.codeease.idea.plugin.strategy.stringStrategy;

/**
 * @author by: ly
 * @ClassName: CamelCaseStringFormat
 * @Description: 驼峰命名转换
 * @Date: 2023/12/22 上午11:15
 */
public class CamelCaseStringConverter implements StringConverterStrategy {
    @Override
    public String execute(String msg) {

        ClassCamelStringConverter classCamelStringFormat = new ClassCamelStringConverter();
        StringBuilder result = new StringBuilder(classCamelStringFormat.execute(msg));
        // 将首字母改为小写
        if (!result.toString().isEmpty()){
            result.replace(0,1,String.valueOf(result.charAt(0)).toLowerCase());
        }
        return result.toString();
    }
}
