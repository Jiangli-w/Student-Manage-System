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
                        '<th>工号</th><th>姓名</th><th>性别</th>' +
                        '<th>出生日期</th><th>院系</th><th>联系电话</th>'+
                        '</tr>';
                    if(oj == null) break;
                    htmlStr += '<tr>' +
                        '<td>'+ oj.tc_id + '</td><td>' + oj.tc_name + '</td><td>' + oj.tc_sex + '</td>' +
                        '<td>' + oj.tc_birth + '</td><td>' + oj.tc_depart + '</td><td>' + oj.tc_phone + '</td>'+
                        '</tr>';
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
                '<td>'+ (elem.curPage + 1) + '/' + elem.pageSum +'</td>'+
                '</tr>';
            htmlStr += '</table>';

            document.getElementById('show').innerHTML = htmlStr;
        }
    }

}

function onFirstBtn(){
    elem = document.getElementById(document.getElementById("show").curContext);
    elem.curPage = 0;

    var url = "teacher?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

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

    var url = "teacher?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

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

    var url = "teacher?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

    elem.XMLHttp.open("GET", url, true);
    elem.XMLHttp.send(null);
    elem.XMLHttp.onreadystatechange = OnResponse.bind(elem.XMLHttp, elem.getAttribute("id"));
}

function onLastBtn(){
    elem = document.getElementById(document.getElementById("show").curContext);
    elem.curPage = elem.pageSum - 1;

    var url = "teacher?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;

    elem.XMLHttp.open("GET", url, true);
    elem.XMLHttp.send(null);
    elem.XMLHttp.onreadystatechange = OnResponse.bind(elem.XMLHttp, elem.getAttribute("id"));
}

function btnOnClike(){
    this.pageSize = 2;
    this.curPage = 0;

    XMLHttp = GetXmlHttpObject();
    XMLHttp.open("GET", "teacher?what=" + this.getAttribute("id") + "_count", false);
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
function onSubmitBtn(){
    elem = document.getElementById(document.getElementById("show").curContext);

    var queryString = "stuId=" + document.getElementsByName("stuId")[0].value +
        "&courId=" + document.getElementsByName("courId")[0].value +
        "&score=" + document.getElementsByName("score")[0].value;

    elem.XMLHttp.open("POST", "teacher?what=" + document.getElementById("show").curContext, false);
    elem.XMLHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    elem.XMLHttp.send(queryString);


    if(XMLHttp.readyState == 4 && XMLHttp.status == 200){
        var oj = JSON.parse(XMLHttp.responseText);
        if(oj.state == 'success'){
            alert("变更学生成绩信息成功！");
        }else{
            alert("变更学生成绩信息失败！")
        }
    }else{
        return;
    }
}

window.onload = function (){
    var btns = document.querySelectorAll("#father div");
    for(var i = 0; i < btns.length - 1; i++){

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

    btns[btns.length - 1].onclick = function (){
        var htmlStr = '<table>\n' +
            '<tr><td>学号:</td><td><input type="text" name="stuId"/></td></tr>\n' +
            '<tr><td>课程号：</td><td><input type="text" name="courId"/></td></tr>\n' +
            '<tr><td>分数：</td><td><input type="text" name="score"/></td></tr>\n' +
            '<tr><td><input type="button" onclick="onSubmitBtn()" value="提交"/></td></tr>\n' +
            '</table>\n';
        XMLHttp = GetXmlHttpObject();
        this.XMLHttp = XMLHttp;
        document.getElementById('show').curContext = this.getAttribute("id");
        document.getElementById('show').innerHTML = htmlStr;

        //所有按钮置白
        var btns = document.querySelectorAll("#father div");
        for(var i = 0; i < btns.length; i++){
            btns[i].style.backgroundColor = "white";
        }
        //当前常亮
        this.style.backgroundColor = 'hotpink';
    };
    btns[btns.length - 1].onmouseover = function (){
        this.style.backgroundColor = "hotpink";
    }

    btns[btns.length - 1].onmouseout = function (){
        if(document.getElementById('show').curContext == this.getAttribute('id')){
            return;
        }
        this.style.backgroundColor = "white";
    }


    btns[0].onclick();
}
//changeScoreInfo
