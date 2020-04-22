//获取系统时间
var newDate = '';
getLangDate();
//值小于10时，在前面补0
function dateFilter(date){
    if(date < 10){return "0"+date;}
    return date;
}
function getLangDate(){
    var dateObj = new Date(); //表示当前系统时间的Date对象
    var year = dateObj.getFullYear(); //当前系统时间的完整年份值
    var month = dateObj.getMonth()+1; //当前系统时间的月份值
    var date = dateObj.getDate(); //当前系统时间的月份中的日
    var day = dateObj.getDay(); //当前系统时间中的星期值
    var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
    var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
    var hour = dateObj.getHours(); //当前系统时间的小时值
    var minute = dateObj.getMinutes(); //当前系统时间的分钟值
    var second = dateObj.getSeconds(); //当前系统时间的秒钟值
    var timeValue = "" +((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午" ); //当前时间属于上午、晚上还是下午
    newDate = dateFilter(year)+"年"+dateFilter(month)+"月"+dateFilter(date)+"日 "+" "+dateFilter(hour)+":"+dateFilter(minute)+":"+dateFilter(second);
    document.getElementById("nowTime").innerHTML = "亲爱的"+timeValue+"好！当前时间为： "+newDate+"　"+week;
    setTimeout("getLangDate()",1000);
}

layui.use(['form','element','layer'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element;
        $ = layui.jquery;

    $.ajax({
        type: "post",
        url: "/crm/business/sumBusiness.do",
        // dataType: "json",
        success: function (data) {
            $("#byid2").empty();
            $("#byid2").append(""+data+"人");
        },
        error: function () {
            alert("出错啦");
        }
    });

    $.ajax({
        type: "post",
        url: "/crm/clients/Sumclients.do",
        // dataType: "json",
        success: function (data) {
            $("#byid1").empty();
            $("#byid1").append(""+data+"人");
        },
        error: function () {
            alert("出错啦");
        }
    });
    $.ajax({
        type: "post",
        url: "/crm/contracts/sumContracts.do",
        // dataType: "json",
        success: function (data) {
            $("#byid3").empty();
            $("#byid3").append(""+data+"人");
        },
        error: function () {
            alert("出错啦");
        }
    });

    //最新文章列表
    $.get("/crm/knowledge/queryKonw.do",function(data){
        console.log(data);
        var hotNewsHtml = '';
        for(var i=0;i<data.count;i++){
            hotNewsHtml += '<tr>'
                +'<td ><a href="/crm/knowledge/queryKonwid.do?kid='+data.data[i].k_id+'"> '+data.data[i].k_name+'</a></td>'
                +'</tr>';
        }
        $("#hot_news").html(hotNewsHtml);
        $("#ids1").append("<span class='layui-badge'>" + data.count + "</span>");
    })

    $.get("/json/newsList.json",function(data){
        console.log(data);
        var hotNewsHtml = '';
        for(var i=0;i<data.count;i++){
            hotNewsHtml += '<tr>'
                +'<td ><a href=""> '+data.data[i].newsName+'</a></td>'
                +'</tr>';
        }
        $("#newsName").html(hotNewsHtml);
        $("#ids2").append("<span class='layui-badge'>" + data.count + "</span>");
    });


    $.get("/crm/clients/querygroup.do", function (data) {
        //要操作的DOM
        var dom = document.getElementById("container");
        // 初始化实例，基于要操作的DOM
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        // 指定图表的配置项和数据
        option = {
            title: {
                text: '客户关系管理系统-客户来源统计',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: data
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            series: [
                {
                    name: '客户数量(占比)',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '40%'],
                    data: data,
                    itemStyle: {
                        emphasis: {
                            // 阴影的大小
                            shadowBlur: 10,
                            // 阴影水平方向上的偏移
                            shadowOffsetX: 0,
                            // 阴影颜色
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        if (option && typeof option === "object") {
            // 使用刚指定的配置项和数据显示 图表
            myChart.setOption(option, true);
        }
        // echarts 窗口缩放自适应
        window.onresize = function () {
            myChart.resize();
        }
        console.log(data)
    });

    var myChart3 = echarts.init(document.getElementById('tu2'));
    $.post("/crm/userinfo/bshangjishu.do").done(function (data) {
        myChart3.setOption({
            title: {
                text: '存在类型的商机',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: data
            }, grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },

                series: [
                {
                    name: '客户数量(占比)',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '40%'],
                    data: data,
                    itemStyle: {
                        emphasis: {
                            // 阴影的大小
                            shadowBlur: 10,
                            // 阴影水平方向上的偏移
                            shadowOffsetX: 0,
                            // 阴影颜色
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]


        });
    });
    var myChart4 = echarts.init(document.getElementById('tu3'));
    $.post("/crm/userinfo/hetongzhexina.do").done(function (data) {
        myChart4.setOption({
            title: {
                text: '本/上周合同成交量比较'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['本周', '上周']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['本/上周一', '本/上周二', '本/上周三', '本/上周四', '本/上周五','本/上周六', '本/上周日']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '本周',
                    type: 'line',
                    data: data.arrthree
                },
                {
                    name: '上周',
                    type: 'line',
                    data: data.arrtwo
                }
            ]

        });
    });


    $("#on1").click(function () {
        $("#a2").hide();
        $("#a3").hide();
        $("#a1").show();

    });

    $("#on2").click(function () {
        $("#a1").hide();
        $("#a3").hide();
        $("#a2").show();

    });

    $("#on3").click(function () {
        $("#a1").hide();
        $("#a2").hide();
        $("#a3").show();
    });



})


