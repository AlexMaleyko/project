package service;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 10.04.2017.
 */
public class TemplateMessage {
    private static final org.slf4j.Logger LOGGER=
            org.slf4j.LoggerFactory.getLogger(TemplateMessage.class);
    private String name;
    private String template;
    public TemplateMessage(String name){
        STGroup messageTemplates = new STGroupFile("messageTemplates.stg");
        ST template1 = messageTemplates.getInstanceOf(name);
        if(name.equals("birthday")) {
            template1.add("name", "<Имя>");
            template1.add("patronymic", "<Отчество>");
        }
        if(name.equals("randomOccasion")){
            template1.add("occasion", "<Праздник>");
        }
        if(name.equals("greeting")){
            template1.add("place", "<Место>");
        }
        this.name=name;
        this.template = template1.render();
    }
    public static List<TemplateMessage> getAllTemplates(){
        List<TemplateMessage> templateMessages = new ArrayList<>();
        templateMessages.add(new TemplateMessage("birthday"));
        templateMessages.add(new TemplateMessage("randomOccasion"));
        templateMessages.add(new TemplateMessage("greeting"));
        return templateMessages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
