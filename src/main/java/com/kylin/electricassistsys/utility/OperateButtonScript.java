package com.kylin.electricassistsys.utility;

/**
 * Created by Threecolors on 2017/11/16.
 */
public class OperateButtonScript
{
    public static String EIDIT_BUTTON = "<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"删除\" style=\"text-decoration:none\" onclick=\"openDeleteLayer('%s')\">"
            + "<div class=\"ui-pg-div\" style=\"display: inline\">"
            + "<i class=\"ui-icon icon-trash red\"></i>"
            + " </div>"
            + "</a>";

    public  static String DELETE_BUTTON="<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"编辑\" style=\"text-decoration:none\" onclick=\"editFunction('%s')\">"
            + "<div class=\"ui-pg-div\" style=\"display: inline\">"
            + "<i class=\"ui-icon icon-pencil blue\"></i>"
            + "</div>"
            + " </a>";

    public  static  String AUTHORITY_SETTING = "<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"功能授权\" style=\"text-decoration:none\" onclick=\"authorityFunction('%s')\">"
            + "<div class=\"ui-pg-div\" style=\"display: inline\">"
            + "<i class=\"ui-icon  icon-edit purple\"></i>"
            + "</div>"
            + "</a>";

    public  static  String ROLE_SETTING = "<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"设置角色\" style=\"text-decoration:none\" onclick=\"roleFunction('%s')\">"
            + "<div class=\"ui-pg-div\" style=\"display: inline\">"
            + "<i class=\"ui-icon  icon-edit purple\"></i>"
            + "</div>"
            + "</a>";
    public  static  String FILE_DOWNLODING = "<a data-toggle=\"tooltip\" href=\"%s\" data-placement=\"top\" title=\"下载\" style=\"text-decoration:none\">"
            + "<div class=\"ui-pg-div\" style=\"display: inline\">"
            + "<i class=\"ui-icon   icon-download-alt\"></i>"
            + "</div>"
            + "</a>";

    public  static  String UNLOCK = "<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"解锁登录账号\" style=\"text-decoration:none\" onclick=\"unlockFunction('%s')\">"
            + "<div class=\"ui-pg-div\" style=\"display: inline\">"
            + "<i class=\"ui-icon  icon-unlock\"></i>"
            + "</div>"
            + "</a>";

    public  static  String RESET_PWD = "<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"重置密码\" style=\"text-decoration:none\" onclick=\"resetAccountFunction('%s')\">"
            + "<div class=\"ui-pg-div\" style=\"display: inline\">"
            + "<i class=\"ui-icon  icon-refresh\"></i>"
            + "</div>"
            + "</a>";
}
