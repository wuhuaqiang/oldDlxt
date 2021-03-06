package com.kylin.electricassistsys.wrapper;

import com.kylin.electricassistsys.utility.JsoupXSSCleanUtil;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by Threecolors on 2018/1/29.
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper
{
    HttpServletRequest orgRequest = null;
    private boolean isIncludeRichText = false;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText)
    {
        super(request);
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
     * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
     */
    @Override
    public String getParameter(String name)
    {
        Boolean flag = ("content".equals(name) || name.endsWith("WithHtml"));
        if (flag && !isIncludeRichText)
        {
            return super.getParameter(name);
        }
        name = JsoupXSSCleanUtil.clean(name);
        String value = super.getParameter(name);
        if (StringUtils.isNotBlank(value))
        {
            value = JsoupXSSCleanUtil.clean(value);
            value = StringEscapeUtils.escapeSql(value);
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name)
    {
        String[] arr = super.getParameterValues(name);
        if (arr != null)
        {
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = JsoupXSSCleanUtil.clean(arr[i]);
            }
        }
        return arr;
    }


    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name)
    {
        name = JsoupXSSCleanUtil.clean(name);
        String value = super.getHeader(name);
        if (StringUtils.isNotBlank(value))
        {
            value = JsoupXSSCleanUtil.clean(value);
            value = StringEscapeUtils.escapeSql(value);
        }
        return value;
    }

    /**
     * 获取最原始的request
     *
     * @return
     */
    public HttpServletRequest getOrgRequest()
    {
        return orgRequest;
    }

    /**
     * 获取最原始的request的静态方法
     *
     * @return
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req)
    {
        if (req instanceof XssHttpServletRequestWrapper)
        {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }

        return req;
    }
}