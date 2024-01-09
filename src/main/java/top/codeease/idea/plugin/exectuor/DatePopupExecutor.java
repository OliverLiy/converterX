package top.codeease.idea.plugin.exectuor;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.PopupStep;
import com.intellij.openapi.ui.popup.util.BaseListPopupStep;
import javafx.util.converter.DateStringConverter;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.codeease.idea.plugin.enums.DateConverterTypeEnum;
import top.codeease.idea.plugin.enums.StringConverterTypeEnum;
import top.codeease.idea.plugin.process.ReplaceProcess;
import top.codeease.idea.plugin.strategy.dateStrategy.DateConverterStrategy;
import top.codeease.idea.plugin.strategy.stringStrategy.StringConverterStrategy;

import javax.swing.*;
import java.util.List;

/**
 * @author by: ly
 * @ClassName: DatePopupExecutor
 * @Description: 日期列表执行器
 * @Date: 2024/1/3 下午2:49
 */
public class DatePopupExecutor extends BaseListPopupStep<String> {

    private Editor editor;
    private Project project;

    public DatePopupExecutor(@NotNull String title, @NotNull List<String> values, Editor editor, Project project) {
        super(title, values);
        this.editor = editor;
        this.project = project;
    }

    @Override
    @Nullable
    public PopupStep onChosen(@Nullable String selectedValue, boolean finalChoice) {
        // 处理选中的值
        if (StringUtils.isNotBlank(selectedValue)) {
            String selectedText = editor.getSelectionModel().getSelectedText();
            DateConverterStrategy strategyInstance = DateConverterTypeEnum.getStrategyInstance(selectedValue);
            String result = strategyInstance.execute(selectedText);
            ReplaceProcess.replaceText(result, editor, project);
        }
        // 如果是最终选择，则关闭弹出窗口
        return finalChoice ? PopupStep.FINAL_CHOICE : super.onChosen(selectedValue, finalChoice);
    }

    @Override
    public boolean hasSubstep(@Nullable String selectedValue) {
        // 在这里可以定义是否有子步骤
        return false;
    }

    @Nullable
    @Override
    public String getTextFor(String value) {
        // 返回列表项的显示文本
        return value;
    }

    @Nullable
    @Override
    public Icon getIconFor(String value) {
        // 返回列表项的图标，如果不需要图标，则返回 null
        return null;
    }
}
