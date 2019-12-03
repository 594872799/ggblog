    <#--主页的一个文章列表项ok-->
<#macro listItem post>
<#--一个列表项-->
    <div class="list-item px-1 py-4 mt-xl-0 mt-3 border-bottom">
        <#--文章标题-->
        <a href="/archives/${post.title!}" class="text-body">
            <h4 class="post-title font-weight-bold text-break">
                ${post.title!}
            </h4>
        </a>
        <#--文章摘要-->
        <span class="post-summary mt-4 d-block text-muted text-break">${post.article.content!}</span>

        <small class="mt-4 d-block">
            <#--标签-->
            <#if (post.tagList)?? && post.tagList?size !=0>
                <span class="mr-3 font-weight-bold d-md-inline d-none">
                    <i class="fas fa-tags mr-1"></i>
                    <#list post.tagList as tag>
                        <a class="text-body mr-1"
                           href="/tags/${tag!}">${tag!}</a>
                    </#list>
                </span>
            </#if>
            <#--日期-->
            <span class="mr-3">
                <i class="fas fa-calendar-alt mr-2"></i>${post.createTime?string["yyyy年MM月dd日"]!}
            </span>
            <#--多少次浏览-->
            <span>
                <i class="fas fa-eye mr-2"></i>${post.vister!}次浏览
            </span>
        </small>
    </div>
</#macro>