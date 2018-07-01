package com.kylin.electricassistsys.entity.system;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.enumparam.Status;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

/**
 * 用户实体
 */
@NameStyle(Style.normal)
@Table(name="UserInfo")
public class UserInfoEntity extends BaseEntity
{
    @Pattern(regexp="^[\\u4e00-\\u9fa5]{1,10}$",message="小于10位的汉字")
    @FieldMeta(description = "姓名", index = 1, queryField = true)
    private String name="";

    @NotBlank(message = "必填项")
    @FieldMeta(description = "单位", index = 2, queryField = true, show = false, editTagType = TagType.SELECT,keyValueType = KeyValueType.GDGS, isExport = false)
    private String unitId="";

    @Transient
    @FieldMeta(description = "单位", index = 2,editTagType = TagType.NONE, isImport = false)
    private String unitName="";

    @Transient
    @Pattern(regexp="^[a-zA-Z0-9]{4,20}$",message="字母、数字构成4到20位字符")
    @FieldMeta(description = "登录账号", index = 3, isImport = false)
    private String username="";

    @Transient
    @FieldMeta(description = "密码", index = 3, show = false,isExport = false, isImport = false)
    private String password ="";

    @NotBlank(message = "必填项")
    @FieldMeta(description = "性别", index = 4)
    private String sex="";

    @Pattern(regexp="(^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$)",message="格式不正确")
    @FieldMeta(description = "邮箱", index = 5)
    private String email="";

    @Pattern(regexp="^1[34578]\\d{9}$",message="格式不正确")
    @FieldMeta(description = "手机号", index = 6)
    private String cellphoneNumber="";

    @Pattern(regexp="(^$)|(^[1-9][0-9]{4,10}$)",message="格式不正确")
    @FieldMeta(description = "QQ号", index = 7)
    private String qq="";

    @Pattern(regexp="(^$)|(^\\d{4,9}$)",message="格式不正确")
    @FieldMeta(description = "座机号", index = 8)
    private String telephoneNumber="";

    @FieldMeta(description = "地址", index = 9)
    private String address="";

    @Transient
    @NotBlank(message = "必填项")
    @FieldMeta(description = "用户状态", index = 10)
    private String accountStatus="";

    @Transient
    @FieldMeta(description = "是否锁定", index = 11,show = false)
    private boolean isUnlock;

    @Transient
    @FieldMeta(description = "是否锁定", index = 11)
    private String isLockTxt;

    @FieldMeta(description = "备注",index = 12)
    private String remark="";

    public String getUnitId()
    {
        return unitId;
    }

    public void setUnitId(String unitId)
    {
        this.unitId = unitId;
    }

    public String getUnitName()
    {
        return unitName;
    }

    public void setUnitName(String unitName)
    {
        this.unitName = unitName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getQq()
    {
        return qq;
    }

    public void setQq(String qq)
    {
        this.qq = qq;
    }

    public String getCellphoneNumber()
    {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber)
    {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAccountStatus()
    {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus)
    {
        this.accountStatus = accountStatus;
    }

    public boolean isUnlock()
    {
        return isUnlock;
    }

    public void setUnlock(boolean unlock)
    {
        isUnlock = unlock;
    }

    public String getIsLockTxt()
    {
        return this.isUnlock?"否":"是";
    }
}
