package com.kylin.electricassistsys.entity.basedata;

import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

/**
 * 变压器参数
 */
@NameStyle(Style.normal)
@Table(name="Byqcs")
public class ByqcsEntity extends BaseEntity
{
    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "变压器型号", index = 1, queryField = true)
    private String xh="";

    @NotBlank(message ="必填项" )
    @FieldMeta(description = "电压等级", index = 2, queryField = true,  editTagType = TagType.SELECT, keyValueType = KeyValueType.VOLTAGE)
    private  String dydj = "";

    @NotBlank(message ="必填项" )
    @Length(max = 20,message = "20位以内字符")
    @FieldMeta(description = "电压系列",index =3)
    private String xl="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "容量（MVA）",index =4)
    private float dr;

    @FieldMeta(description = "低压侧电压等级（KV）",index =5)
    private String dycdydj="";

    @FieldMeta(description = "低压电压序列",index =6)
    private String dyxl="";

    @FieldMeta(description = "高压侧额定电压（KV）",index =7)
    private String gyceddy="";

    @FieldMeta(description = "低压侧额定电压（KV）",index =8)
    private String dyceddy="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "空载损耗（KW）",index =9)
    private float kzsh;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "短路电压（%）",index =10)
    private float dldy;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "短路损耗（KW）",index =11)
    private float dlsh;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "空载电流（%）",index =12)
    private float kzdl;

    @FieldMeta(description = "铭牌变比",index =13)
    private String mpbb="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "额定电压",index =14)
    private float eddy;

    @FieldMeta(description = "调压方式",index =15)
    private String tyfs="";

    @FieldMeta(description = "绕组方式",index =16)
    private String rzfs="";

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高中阻抗",index =17)
    private float gzzk;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "中低阻抗",index =18)
    private float zdzk;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高低阻抗",index =19)
    private float gdzk;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高中耗损",index =20)
    private float gzhs;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "中低耗损",index =21)
    private float zdhs;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高低耗损",index =22)
    private float gdhs;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高中电阻",index =23)
    private float gzdz;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "中低电阻",index =24)
    private float zddz;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高低电阻",index =25)
    private float gddz;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高中电抗",index =26)
    private float gzdk;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "中低电抗",index =27)
    private float zddk;

    @Digits(integer = 6, fraction = 2,message = "8位有效数字的小数")
    @FieldMeta(description = "高低电抗",index =28)
    private float gddk;

    public String getXh()
    {
        return xh;
    }

    public void setXh(String xh)
    {
        this.xh = xh;
    }

    public String getDydj()
    {
        return dydj;
    }

    public void setDydj(String dydj)
    {
        this.dydj = dydj;
    }

    public String getXl()
    {
        return xl;
    }

    public void setXl(String xl)
    {
        this.xl = xl;
    }

    public float getDr()
    {
        return dr;
    }

    public void setDr(float dr)
    {
        this.dr = dr;
    }

    public String getDycdydj()
    {
        return dycdydj;
    }

    public void setDycdydj(String dycdydj)
    {
        this.dycdydj = dycdydj;
    }

    public String getDyxl()
    {
        return dyxl;
    }

    public void setDyxl(String dyxl)
    {
        this.dyxl = dyxl;
    }

    public String getGyceddy()
    {
        return gyceddy;
    }

    public void setGyceddy(String gyceddy)
    {
        this.gyceddy = gyceddy;
    }

    public String getDyceddy()
    {
        return dyceddy;
    }

    public void setDyceddy(String dyceddy)
    {
        this.dyceddy = dyceddy;
    }

    public float getKzsh()
    {
        return kzsh;
    }

    public void setKzsh(float kzsh)
    {
        this.kzsh = kzsh;
    }

    public float getDldy()
    {
        return dldy;
    }

    public void setDldy(float dldy)
    {
        this.dldy = dldy;
    }

    public float getDlsh()
    {
        return dlsh;
    }

    public void setDlsh(float dlsh)
    {
        this.dlsh = dlsh;
    }

    public float getKzdl()
    {
        return kzdl;
    }

    public void setKzdl(float kzdl)
    {
        this.kzdl = kzdl;
    }

    public String getMpbb()
    {
        return mpbb;
    }

    public void setMpbb(String mpbb)
    {
        this.mpbb = mpbb;
    }

    public float getEddy()
    {
        return eddy;
    }

    public void setEddy(float eddy)
    {
        this.eddy = eddy;
    }

    public String getTyfs()
    {
        return tyfs;
    }

    public void setTyfs(String tyfs)
    {
        this.tyfs = tyfs;
    }

    public String getRzfs()
    {
        return rzfs;
    }

    public void setRzfs(String rzfs)
    {
        this.rzfs = rzfs;
    }

    public float getGzzk()
    {
        return gzzk;
    }

    public void setGzzk(float gzzk)
    {
        this.gzzk = gzzk;
    }

    public float getZdzk()
    {
        return zdzk;
    }

    public void setZdzk(float zdzk)
    {
        this.zdzk = zdzk;
    }

    public float getGdzk()
    {
        return gdzk;
    }

    public void setGdzk(float gdzk)
    {
        this.gdzk = gdzk;
    }

    public float getGzhs()
    {
        return gzhs;
    }

    public void setGzhs(float gzhs)
    {
        this.gzhs = gzhs;
    }

    public float getZdhs()
    {
        return zdhs;
    }

    public void setZdhs(float zdhs)
    {
        this.zdhs = zdhs;
    }

    public float getGdhs()
    {
        return gdhs;
    }

    public void setGdhs(float gdhs)
    {
        this.gdhs = gdhs;
    }

    public float getGzdz()
    {
        return gzdz;
    }

    public void setGzdz(float gzdz)
    {
        this.gzdz = gzdz;
    }

    public float getZddz()
    {
        return zddz;
    }

    public void setZddz(float zddz)
    {
        this.zddz = zddz;
    }

    public float getGddz()
    {
        return gddz;
    }

    public void setGddz(float gddz)
    {
        this.gddz = gddz;
    }

    public float getGzdk()
    {
        return gzdk;
    }

    public void setGzdk(float gzdk)
    {
        this.gzdk = gzdk;
    }

    public float getZddk()
    {
        return zddk;
    }

    public void setZddk(float zddk)
    {
        this.zddk = zddk;
    }

    public float getGddk()
    {
        return gddk;
    }

    public void setGddk(float gddk)
    {
        this.gddk = gddk;
    }
}
