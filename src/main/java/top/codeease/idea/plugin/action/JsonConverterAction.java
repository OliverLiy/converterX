package top.codeease.idea.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import org.jetbrains.annotations.NotNull;
import top.codeease.idea.plugin.enums.JsonConverterTypeEnum;
import top.codeease.idea.plugin.enums.StringConverterTypeEnum;
import top.codeease.idea.plugin.exectuor.JsonPopupExecutor;
import top.codeease.idea.plugin.exectuor.StringPopupExecutor;

import java.util.List;
import java.util.Objects;

/**
 * @author by: ly
 * @ClassName: JsonConverterAction
 * @Description: JSON转换
 * @Date: 2024/1/5 上午11:30
 */
public class JsonConverterAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = (Editor) event.getDataContext().getData("editor");
        Project project = event.getProject();

        // 创建要展示的列表数据
        List<String> typeNameList = JsonConverterTypeEnum.getTypeNameList();

        // 创建列表弹出窗口
        ListPopup listPopup = JBPopupFactory.getInstance()
                .createListPopup(new JsonPopupExecutor("Json Converter",typeNameList,editor,project));

        // 在屏幕中间显示列表弹出窗口
        listPopup.showCenteredInCurrentWindow(Objects.requireNonNull(event.getProject()));
    }
}
