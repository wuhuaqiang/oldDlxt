package com.kylin.electricassistsys.utility.mail;

/**
 * Created by Threecolors on 2018/3/1.
 */
public class MailProperties
{
    private String host;
    private String username;
    private String password;
    private String from;

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
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

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }
}
