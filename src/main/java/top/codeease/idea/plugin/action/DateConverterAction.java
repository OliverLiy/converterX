package top.codeease.idea.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import org.jetbrains.annotations.NotNull;
import top.codeease.idea.plugin.enums.DateConverterTypeEnum;
import top.codeease.idea.plugin.exectuor.DatePopupExecutor;
import top.codeease.idea.plugin.exectuor.StringPopupExecutor;
import top.codeease.idea.plugin.strategy.dateStrategy.DateConverterStrategy;

import java.util.List;
import java.util.Objects;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: DateFormatAction
 * @Description: 日期格式化动作
 * @Date: 2023/12/27 下午11:44
 */
public class DateConverterAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = (Editor) event.getDataContext().getData("editor");
        Project project = event.getProject();
        List<String> typeNameList = DateConverterTypeEnum.getTypeNameList();
        // 创建列表弹出窗口
        ListPopup listPopup = JBPopupFactory.getInstance()
                .createListPopup(new DatePopupExecutor("Date Converter",typeNameList,editor,project));
        // 在屏幕中间显示列表弹出窗口
        listPopup.showCenteredInCurrentWindow(Objects.requireNonNull(event.getProject()));
    }
}

