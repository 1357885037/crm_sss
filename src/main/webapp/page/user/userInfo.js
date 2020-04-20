var form, $,areaData;
layui.config({
    base : "../../js/"
}).extend({
    "address" : "address"
})
layui.use(['form','layer','upload','laydate',"address"],function(){
    form = layui.form;
    $ = layui.jquery;
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        upload = layui.upload,
        laydate = layui.laydate,
        address = layui.address;



    //普通图片上传
      upload.render({
        elem: '#test0'
        ,url: '/crm/upload/userUpload.do' //改成您自己的上传接口
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo1').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });
   /* // 上传文件
    upload.render({
        elem: '#test0' //绑定元素
        ,url: '/crm/upload/userUpload.do' //上传接口
        ,auto:false
        ,accept: 'file' //普通文件
        ,multiple:true
        ,done: function(res){     //上传完毕回调
            layer.msg('提交成功！', {icon: 6});
            window.location.href ="/Login/Users/Personal_Data.do";
        }
        ,error: function(){//请求异常回调
            layer.msg('上传失败！', {icon: 7});
        }
    });*/
/*    //上传头像
    upload.render({
        elem: '#test0',
        url: '/crm/upload/userUpload.do',
        method : "get"  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        ,before: function(obj){
        //预读本地文件示例，不支持ie8
   /!*     obj.preview(function(res){
            $('#userFace').attr('src', res); //图片链接（base64）
            layer.msg("头像修改成功！！！");

        });*!/
    }
    ,done: function(res){
        //如果上传失败
        if(res.code > 0){
            return layer.msg('上传失败');
        }
        //上传成功
    }
    ,error: function(){
        //演示失败状态，并实现重传
        var demoText = $('#demoText');
        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
        demoText.find('.demo-reload').on('click', function(){
            uploadInst.upload();
        });
    }
    });*/


    //添加验证规则
    form.verify({
        userBirthday : function(value){
            if(!/^(\d{4})[\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|1[0-2])([\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|[1-2][0-9]|3[0-1]))*$/.test(value)){
                return "出生日期格式不正确！";
            }
        }
    })

    laydate.render({
        elem: '.userBirthday'//指定元素
    });

    //获取省信息

    //提交个人资料
    form.on("submit(changeUser)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //将填写的用户信息存到session以便下次调取

        //获取已处理的服务一共有多少并显示脚表
        $.ajax({
            type: "post",
            url: "/sanqi/users/updateuser.do",
            data:data.field,
            dataType: "json",
            success: function (data) {
                if(data==200){
                    setTimeout(function(){
                        layer.close(index);
                        layer.msg("提交成功！");
                    },2000);
                }else{
                    setTimeout(function(){
                        layer.close(index);
                        layer.msg("提交失败！");
                    },2000);
                }
            },
            error: function () {
                alert("出错啦");
            }
        });


        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })

    //修改密码
    form.on("submit(changePwd)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
            layer.msg("密码修改成功！");
            $(".pwd").val('');
        },2000);
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    })
})