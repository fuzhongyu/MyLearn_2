<%--
  Created by IntelliJ IDEA.
  User: fuzhongyu
  Date: 2017/4/11
  Time: 上午11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadFile</title>

    <script src="/statics/jquery/jquery-1.9.0.min.js"></script>

    <script type="text/javascript">

        function saveFun() {
            var fi=$("#file").val();
            var value=getFileName(fi);
            alert(value);

            $.ajax({
                type:'post',
                url:'/helloWorld/checkPic_2',
                dataType:'json',
                data:{title:value},
                success:function (data) {
                    alert(data);
                }

            });
        }

        function getFileName(o){
            var pos=o.lastIndexOf("\\");
            return o.substring(pos+1);
        }

    </script>
</head>



<body>

   <form id="inputForm" action="/helloWorld/uploadFile" method="post" enctype="multipart/form-data">
       <input id="file" type="file" name="file" value="上传图片">
       <input type="button" value="提交" onclick="saveFun();">
   </form>

</body>
</html>
