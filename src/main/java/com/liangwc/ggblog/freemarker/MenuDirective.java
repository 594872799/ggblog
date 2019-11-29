package com.liangwc.ggblog.freemarker;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.liangwc.ggblog.entity.GgMenu;
import com.liangwc.ggblog.service.GgMenuService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author liangweicheng
 * @date 2019/11/29 11:30
 */
@Component
public class MenuDirective implements TemplateDirectiveModel {
    @Autowired
    private GgMenuService menuService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        List<GgMenu> list = menuService.selectList(null);
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        environment.setVariable("menu", builder.build().wrap(list));
        templateDirectiveBody.render(environment.getOut());
    }
}
