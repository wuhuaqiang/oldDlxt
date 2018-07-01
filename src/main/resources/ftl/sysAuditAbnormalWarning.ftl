<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>系统异常预警</title>
</head>
<body>
<div>
    <pre>
        <p>您好，系统出现异常，请及时核实处理！</p>

     用户名：${info.account}     用户IP： ${info.userIp}

     该用户于${info.currentTimeTxt} 访问系统，出现 ${info.auditEventName} 异常。

 该用户的访问的${info.message}
    </pre>
</div>
</body>
</html>