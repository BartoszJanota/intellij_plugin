package com.plasms.bj.idea.plugins;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.plasma.bj.net.HttpConnectionUtils;

/**
 * Created by bj on 24.03.15.
 */
public class BjItem extends AnAction{
    public BjItem() {
        super("BJ_ITEM");
    }

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String url = Messages.showInputDialog(project, "Please provide URL you want to connect to (try localhost:8080/fortune).", "BJ Plugin demo", Messages.getQuestionIcon());
        String txt = HttpConnectionUtils.performGetRequest(url);
        Messages.showMessageDialog(project, "Received message:\n" + txt + "\n", "Response", Messages.getInformationIcon());
    }

}
