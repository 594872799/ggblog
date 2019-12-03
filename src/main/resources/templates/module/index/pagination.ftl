<#--主页的分页ok-->
<#macro pagination posts>
    <#assign totalPages = posts.totalPage>
    <#assign totalElements = posts.total>
    <#assign number = posts.current>
    <#assign first = (posts.current == 1)>
    <#assign last = (posts.current == posts.totalPage)>
    <#assign hasPrevious = (posts.current <= 1)>
    <#assign hasNext = (posts.current >= posts.totalPage)>
    <section id="pagination" class="mt-5 mb-lg-3 d-flex justify-content-center">
        <nav aria-label="切换上下页">
            <ul class="pagination">
                <#--上一页部分-->
                <li class="page-item <#if hasPrevious>disabled</#if>">
                    <#if hasPrevious>
                        <a class="page-link" href="${context!}" tabindex="-1" aria-disabled="true">&laquo;</a>
                    <#else>
                        <a class="page-link" href="${context!}/page/${number-1}"
                           aria-label="上一页">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </#if>
                </li>
                <#--页码部分-->
                <#list 1..totalPages as index>
                    <#if index == number>
                        <li class="page-item active" aria-current="page">
                            <a class="page-link" href="javascript:void(0)">${number}<span class="sr-only">${number}</span></a>
                        </li>
                    <#else>
                        <li class="page-item">
                            <a class="page-link" href="${context!}/page/${index}">${index}</a>
                        </li>
                    </#if>
                </#list>
                <#--下一页部分-->
                <li class="page-item <#if hasNext>disabled</#if>">
                    <#if hasNext>
                        <a class="page-link" href="javascript:void(0)" tabindex="-1"
                           aria-disabled="true">&raquo;</a>
                    <#else>
                        <a class="page-link" href="${context!}/page/${number+1}"
                           aria-label="下一页">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </#if>
                </li>
            </ul>
        </nav>
    </section>
</#macro>