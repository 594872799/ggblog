<#--主页的左边ok-->
<#--列表项-->
<#if (articlePage.records)?? && articlePage.records?size gt 0>
<#--左边的文章列表-->
    <#include "list_item.ftl"/>
    <#list articlePage.records as post>
        <@listItem post=post />
    </#list>
<#--分页-->
    <#include "pagination.ftl">
    <@pagination posts=articlePage />
<#else>
    <div class="bg-white mt-5 mb-4">
        <div class="d-flex flex-column align-items-center pt-5">
            <span class="text-muted"><i class="fas fa-inbox fa-7x"></i></span>
            <span class="text-muted mt-4 mb-5">
                还没有写过文章，赶快去写文章吧
            </span>
        </div>
    </div>
</#if>

