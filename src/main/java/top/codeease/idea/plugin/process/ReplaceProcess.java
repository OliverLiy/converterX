package top.codeease.idea.plugin.process;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import top.codeease.idea.plugin.strategy.stringStrategy.StringConverterStrategy;

/**
 * @author by: ly
 * @ClassName: ReplaceProcess
 * @Description: 文本替换处理器
 * @Date: 2024/1/3 下午2:53
 */
public class ReplaceProcess {
    /**
     * 替换文本
     * @param execute
     * @param editor
     * @param project
     */
    public static void replaceText(String execute, Editor editor, Project project) {
        String resultText = execute;
        Runnable runnable = () -> {
            ApplicationManager.getApplication().runWriteAction(() -> {
                Document document = editor.getDocument();
                document.replaceString(editor.getSelectionModel().getSelectionStart(), editor.getSelectionModel().getSelectionEnd(), resultText);
            });
        };
        WriteCommandAction.runWriteCommandAction(project, runnable);
    }
}
