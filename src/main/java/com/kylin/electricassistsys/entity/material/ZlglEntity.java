package com.kylin.electricassistsys.entity.material;


import com.kylin.electricassistsys.entity.BaseEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.utility.FieldMeta;
import com.kylin.electricassistsys.utility.TagType;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.Date;

@NameStyle(Style.normal)
@Table(name="Zlgl")
public class ZlglEntity extends BaseEntity
{
    @FieldMeta(description = "资料名称",index =1, queryField =true)
    private String zlName;

    @FieldMeta(description = "资料类型",index =2, queryField = true,editTagType = TagType.SELECT, keyValueType = KeyValueType.ZLLX)
    private String zlType;

    @FieldMeta(description = "文件名",index =3)
    private String fileName;

    @FieldMeta(description = "上传人",index =4)
    private String uploadUser;

    @FieldMeta(description = "上传时间",index =5)
    private String uploadTime;

    @FieldMeta(description = "物理路徑",index =5,show = false)
    private String path = "";

    @FieldMeta(description = "地址",index =6,show = false)
    private String url;

    @FieldMeta(description = "备注",index =7)
    private String remark;

    public String getZlName()
    {
        return zlName;
    }

    public void setZlName(String zlName)
    {
        this.zlName = zlName;
    }

    public String getZlType()
    {
        return zlType;
    }

    public void setZlType(String zlType)
    {
        this.zlType = zlType;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getUploadUser()
    {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser)
    {
        this.uploadUser = uploadUser;
    }

    public String getUploadTime()
    {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime)
    {
        this.uploadTime = uploadTime;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }
}
