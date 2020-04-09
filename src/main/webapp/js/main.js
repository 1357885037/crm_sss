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
    })




})


