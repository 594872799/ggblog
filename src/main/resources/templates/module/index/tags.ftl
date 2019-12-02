<#--主页的标签部分ok-->
<@tagTag method="list">
    <#if tagMap??>
        <section id="tags" class="mt-4 mb-5 bg-white">
            <div class="card">
                <div class="card-header">
                    <i class="fas fa-tags mr-2"></i>
                    所有标签
                </div>
                <div class="card-body">
                    <#list tagMap?keys as key>
                        <div class="tag">
                            <a href="/tags/${key}" class="text-muted">
                                <span class="tag-left">${key}</span>
                                <span class="tag-right">${tagMap[key]}</span>
                            </a>
                        </div>
                    </#list>
                    <div class="tag">
                        <a href="/tags" class="text-muted">
                            <span class="tag-left">所有标签</span>
                            <span class="tag-right">
                            <@postTag method="count">
                                ${count!}
                            </@postTag>
                        </span>
                        </a>
                    </div>
                </div>
            </div>
        </section>
    </#if>
</@tagTag>