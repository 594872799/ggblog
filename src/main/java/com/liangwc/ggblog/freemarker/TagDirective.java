package com.liangwc.ggblog.freemarker;

import com.liangwc.ggblog.entity.GgTags;
import com.liangwc.ggblog.service.GgTagsService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * @author liangweicheng
 * @date 2019/11/29 17:06
 */
@Component
public class TagDirective implements TemplateDirectiveModel {
    @Autowired
    private GgTagsService tagsService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        TemplateScalarModel tms = (TemplateScalarModel) map.get("method");
        String method = tms.getAsString();

        switch (method) {
            case "count": {
                List<GgTags> articleInfoList = tagsService.list(null);
                Set<String> tagSet = new HashSet<>();
                for (GgTags ggTags : articleInfoList) {
                    String tags = ggTags.getTag();
                    for (String tag : tags.split(",")) {
                        tagSet.add(tag);
                    }
                }
                int count = tagSet.size();
                DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
                environment.setVariable("count", builder.build().wrap(count));
                templateDirectiveBody.render(environment.getOut());
                break;
            }
            case "list": {
                List<GgTags> tagList = tagsService.list(null);
                Map<String, Integer> tagMap = new HashMap<>();
                for (GgTags ggTags : tagList) {
                    String tags = ggTags.getTag();
                    for (String tag : tags.split(",")) {
                        if (tagMap.containsKey(tag)) {
                            int count = tagMap.get(tag);
                            tagMap.put(tag, count + 1);
                        } else {
                            tagMap.put(tag, 1);
                        }
                    }
                }
                DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
                environment.setVariable("tagMap", builder.build().wrap(tagMap));
                templateDirectiveBody.render(environment.getOut());
                break;
            }
            default: {

            }
        }
    }
}
