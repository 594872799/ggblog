<#--主页的分页ok-->
<#macro pagination posts>
    <#if posts.getTotal() gt 0>
        <section id="pagination" class="mt-5 mb-lg-3 d-flex justify-content-center">
            <nav aria-label="切换上下页">
                <ul class="pagination">
                    <#--上一页部分-->
                    <li class="page-item <#if posts.records?size lte 0>disabled</#if>">
                        <#if posts.records?size lte 0>
                            <a class="page-link" href="${context!}" tabindex="-1" aria-disabled="true">&laquo;</a>
                        <#else>
                            <a class="page-link" href="${context!}/page/${posts.records?size}"
                               aria-label="上一页">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </#if>
                    </li>
                    <#--页码部分-->
                    <#list 1..posts.total-1 as r>
                        <#if r == (posts.total%posts.size + 1)>
                            <li class="page-item active" aria-current="page">
                                <a class="page-link" href="javascript:void(0)">${posts.total%posts.size + 1} <span
                                            class="sr-only">(current)</span></a>
                            </li>
                        <#else>
                            <li class="page-item">
                                <a class="page-link" href="${context!}/page/${r}">${r}</a>
                            </li>
                        </#if>
                    </#list>
                    <#--下一页部分-->
                    <li class="page-item <#if posts.getTotal() lte (posts.total%posts.size + 1)>disabled</#if>">
                        <#if posts.getTotal() lte (posts.total%posts.size + 1)>
                            <a class="page-link" href="javascript:void(0)" tabindex="-1"
                               aria-disabled="true">&raquo;</a>
                        <#else>
                            <a class="page-link" href="${context!}/page/${posts.total%posts.size + 2}"
                               aria-label="下一页">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </#if>
                    </li>
                </ul>
            </nav>
        </section>
    </#if>
</#macro>