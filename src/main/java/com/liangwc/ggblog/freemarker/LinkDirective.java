package com.liangwc.ggblog.freemarker;

import com.liangwc.ggblog.entity.GgLink;
import com.liangwc.ggblog.service.GgLinkService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author liangweicheng
 * @date 2019/12/13 9:50
 */
@Component
public class LinkDirective implements TemplateDirectiveModel {
    @Autowired
    private GgLinkService linkService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        TemplateScalarModel tms = (TemplateScalarModel) map.get("method");
        String method = tms.getAsString();
        switch (method) {
            case "list": {
                List<GgLink> linkList = linkService.list();
                DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
                environment.setVariable("links", builder.build().wrap(linkList));
                templateDirectiveBody.render(environment.getOut());
                break;
            }
        }
    }
}
