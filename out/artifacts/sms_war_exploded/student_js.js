function GetXmlHttpObject(){
    var XMLHttp = null;
    try{
        XMLHttp= new XMLHttpRequest();
    }catch(e){
        try{
            XMLHttp = new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e){
            XMLHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    return XMLHttp;
}

function OnResponse(what){
    if(this.readyState == 4){
        if(this.status == 200){
            var oj = null;
            if(this.responseText != '')
                oj= JSON.parse(this.responseText);
            var htmlStr = '';
            switch (what){
                case 'personInfo':
                    htmlStr = '<table>' +
                        '<tr>' +
                        '<th>学号</th><th>姓名</th><th>性别</th>' +
                        '<th>出生日期</th><th>专业</th><th>班级</th>'+
                        '<th>地址</th><th>电话</th><th>备注</th>'+
                        '</tr>';
                    if(oj == null) break;
                    htmlStr += '<tr>' +
                        '<td>'+ oj.stu_id + '</td><td>' + oj.stu_name + '</td><td>' + oj.stu_sex + '</td>' +
                        '<td>' + oj.stu_birth + '</td><td>' + oj.stu_special + '</td><td>' + oj.stu_class_id + '</td>'+
                        '<td>' + oj.stu_address + '</td><td>' + oj.stu_phone + '</td><td>' + oj.stu_note + '</td>'+
                        '</tr>';
                    break;
                case 'classInfo':
                    htmlStr = '<table>' +
                        '<tr>' +
                        '<th>班级号</th><th>班级名</th><th>班级专业</th>' +
                        '<th>人数</th><th>入学年份</th><th>辅导员</th>'+
                        '</tr>';
                    if(oj == null) break;
                    htmlStr += '<tr>' +
                        '<td>'+ oj.class_id + '</td><td>' + oj.class_name + '</td><td>' + oj.class_special + '</td>' +
                        '<td>' + oj.class_number + '</td><td>' + oj.class_year + '</td><td>' + oj.class_instructor + '</td>'+
                        '</tr>';
                    break;
                case 'courseInfo':
                    htmlStr = '<table>' +
                        '<tr>' +
                        '<th>课程号</th><th>课程名</th><th>课时</th>' +
                        '<th>学分</th>'+
                        '</tr>';
                    if(oj == null) break;
                    for(var i = 0; i < oj.length; i++){
                        htmlStr += '<tr>' +
                            '<td>'+ oj[i].course_id + '</td><td>' + oj[i].course_name + '</td><td>' + oj[i].course_hours + '</td>' +
                            '<td>' + oj[i].course_credit + '</td>'+
                            '</tr>';
                    }
                    break;
                case 'ctInfo':
                    htmlStr = '<table>' +
                        '<tr>' +
                        '<th>课表编号</th><th>课程号</th><th>课程名</th>' +
                        '<th>班级名</th><th>教师名</th><th>授课时间</th>'+
                        '<th>地点</th><th>课时</th>'+
                        '</tr>';
                    if(oj == null) break;
                    for(var i = 0; i < oj.length; i++){
                        htmlStr += '<tr>' +
                            '<td>'+ oj[i].ct_id + '</td><td>' + oj[i].course_id + '</td><td>' + oj[i].course_name + '</td>' +
                            '<td>' + oj[i].class_id + '</td><td>' + oj[i].tc_name + '</td><td>' + oj[i].time + '</td>'+
                            '<td>' + oj[i].place + '</td><td>' + oj[i].course_hours + '</td>'+
                            '</tr>';
                    }
                    break;
                case 'scoreInfo':
                    htmlStr = '<table>' +
                        '<tr>' +
                        '<th>学号</th><th>课程号</th><th>姓名</th>' +
                        '<th>课程名</th><th>分数</th>'+
                        '</tr>';
                    if(oj == null) break;
                    for(var i = 0; i < oj.length; i++){
                        htmlStr += '<tr>' +
                            '<td>'+ oj[i].stu_id + '</td><td>' + oj[i].course_id + '</td><td>' + oj[i].stu_name + '</td>' +
                            '<td>' + oj[i].course_name + '</td><td>' + oj[i].score + '</td>' +
                            '</tr>';
                    }
                    break;
            }
            var elem = document.getElementById(document.getElementById("show").curContext);

            htmlStr += '<tr><td onclick="onFirstBtn()">首页</td><td onclick="onPrevBtn()">上一页</td><td onclick="onNextBtn()">下一页</td><td onclick="onLastBtn()">尾页</td>' +
                '<td>'+ (elem.curPage + 1) + '/' + elem.pageSum +'</td>' +
                '</tr>'
            htmlStr += '</table>';

            document.getElementById('show').innerHTML = htmlStr;
        }
    }

}

function onFirstBtn(){
    elem = document.getElementById(document.getElementById("show").curContext);
    elem.curPage = 0;

    var url = "student?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

    elem.XMLHttp.open("GET", url, true);
    elem.XMLHttp.send(null);
    elem.XMLHttp.onreadystatechange = OnResponse.bind(elem.XMLHttp, elem.getAttribute("id"));
}

function onPrevBtn(){
    elem = document.getElementById(document.getElementById("show").curContext);
    if( elem.curPage <= 0 ){
        alert("已经是第一页！");
        elem.curPage = 0;
        return;
    }

    elem.curPage--;

    var url = "student?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

    elem.XMLHttp.open("GET", url, true);
    elem.XMLHttp.send(null);
    elem.XMLHttp.onreadystatechange = OnResponse.bind(elem.XMLHttp, elem.getAttribute("id"));
}

function onNextBtn(){
    elem = document.getElementById(document.getElementById("show").curContext);
    if( elem.curPage >= elem.pageSum - 1){
        alert("已经是最后一页！");
        elem.curPage = elem.pageSum - 1;
        return;
    }

    elem.curPage++;

    var url = "student?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

    elem.XMLHttp.open("GET", url, true);
    elem.XMLHttp.send(null);
    elem.XMLHttp.onreadystatechange = OnResponse.bind(elem.XMLHttp, elem.getAttribute("id"));
}

function onLastBtn(){
    elem = document.getElementById(document.getElementById("show").curContext);
    elem.curPage = elem.pageSum - 1;

    var url = "student?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

    elem.XMLHttp.open("GET", url, true);
    elem.XMLHttp.send(null);
    elem.XMLHttp.onreadystatechange = OnResponse.bind(elem.XMLHttp, elem.getAttribute("id"));
}

function btnOnClike(){
    this.pageSize = 2;
    this.curPage = 0;

    XMLHttp = GetXmlHttpObject();
    XMLHttp.open("GET", "student?what=" + this.getAttribute("id") + "_count", false);
    XMLHttp.send(null);
    if(XMLHttp.readyState == 4 && XMLHttp.status == 200){
        var oj = JSON.parse(XMLHttp.responseText);
        this.pageSum = Math.ceil(oj.count / this.pageSize);
    }else{
        return ;
    }
    document.getElementById('show').curContext = this.getAttribute("id");
    this.XMLHttp = XMLHttp;
    onFirstBtn();
    //所有按钮置白
    var btns = document.querySelectorAll("#father div");
    for(var i = 0; i < btns.length; i++){
        btns[i].style.backgroundColor = "white";
    }
    //当前常亮
    this.style.backgroundColor = 'hotpink';
}

window.onload = function (){
    var btns = document.querySelectorAll("#father div");
    for(var i = 0; i < btns.length; i++){

        btns[i].onclick = btnOnClike;

        btns[i].onmouseover = function (){
            this.style.backgroundColor = "hotpink";
        }

        btns[i].onmouseout = function (){
            if(document.getElementById('show').curContext == this.getAttribute('id')){
                return;
            }
            this.style.backgroundColor = "white";
        }
    }

    btns[0].onclick();
}