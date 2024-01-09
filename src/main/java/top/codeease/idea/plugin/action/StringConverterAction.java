package top.codeease.idea.plugin.action;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import org.jetbrains.annotations.NotNull;
import top.codeease.idea.plugin.enums.StringConverterTypeEnum;
import top.codeease.idea.plugin.exectuor.StringPopupExecutor;

import java.util.List;
import java.util.Objects;

/**
 * String转换功能的Action
 * @author ly
 */
public class StringConverterAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = (Editor) event.getDataContext().getData("editor");
        Project project = event.getProject();

        // 创建要展示的列表数据
        List<String> typeNameList = StringConverterTypeEnum.getTypeNameList();

        // 创建列表弹出窗口
        ListPopup listPopup = JBPopupFactory.getInstance()
                .createListPopup(new StringPopupExecutor("String Converter",typeNameList,editor,project));

        // 在屏幕中间显示列表弹出窗口
        listPopup.showCenteredInCurrentWindow(Objects.requireNonNull(event.getProject()));


    }
}