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

function onInfoModify(){
    var elem = document.getElementById('show').curContext;

//this tr元素
    var queryString = '';
    var tds = this.getElementsByTagName('input');
    for(var i = 0; i < tds.length; i++){
        queryString = queryString + tds[i].getAttribute('name') + '=' + tds[i].value + ((i != tds.length - 1) ? '&' : '');
    }

    elem.XMLHttp.open("POST", "administrator?what=" + elem.getAttribute('id') + '_modify', false);
    elem.XMLHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    elem.XMLHttp.onreadystatechange = null;
    elem.XMLHttp.send(queryString);
    if(elem.XMLHttp.readyState == 4 && elem.XMLHttp.status == 200){
        var oj = JSON.parse(elem.XMLHttp.responseText);
        if(oj.state == 'success') {
            alert("修改成功！");
            onFresh();
        }else{
            alert("修改失败！")
        }
    }else{
        return;
    }
}

function onInfoDelete(){
    var elem = document.getElementById('show').curContext;

//this tr元素
    var queryString = '';
    var tds = this.getElementsByTagName('input');
    queryString = tds[0].getAttribute('name') + '=' + tds[0].value;

    if(elem.getAttribute('id') == 'scoreInfo'){
        queryString += '&' + tds[1].getAttribute('name') + '=' + tds[1].value;
    }

    elem.XMLHttp.open("POST", "administrator?what=" + elem.getAttribute('id') + '_delete', false);
    elem.XMLHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    elem.XMLHttp.onreadystatechange = null;
    elem.XMLHttp.send(queryString);
    if(elem.XMLHttp.readyState == 4 && elem.XMLHttp.status == 200){
        var oj = JSON.parse(elem.XMLHttp.responseText);
        if(oj.state == 'success') {
            alert("删除成功！");
            //执行删除后，总页数应该重新计算，并且重新将当前页改成第一页
            --elem.sum;
            if(elem.sum <= 0){
                elem.sum = 0;
            }
            elem.pageSum = Math.ceil(elem.sum / elem.pageSize)
            elem.curPage = 0;
            onFresh();
        }else{
            alert("删除失败！")
        }
    }else{
        return;
    }
}

function changeWidth() {
    let input = document.getElementById("myInput");
    input.size = input.value.length > 4 ? input.value.length : 4; // 这里input需要给个size属性
}
function OnResponse(what){
    if(this.readyState == 4){
        if(this.status == 200){
            var oj = JSON.parse(this.responseText);

            var elem = document.createElement('table');
            switch (what){
                case 'userInfo':
                    elem.innerHTML = '<tr>' +
                        '<th>用户名</th><th>密码</th><th>用户类型</th>' +
                        '</tr>';
                    break;
                case 'studentInfo':
                    elem.innerHTML = '<tr>' +
                        '<th>学号</th><th>姓名</th><th>性别</th>' +
                        '<th>出生日期</th><th>专业</th><th>班级号</th>' +
                        '<th>地址</th><th>电话</th><th>备注</th>' +
                        '</tr>';
                    break;
                case 'classInfo':
                    elem.innerHTML = '<tr>' +
                        '<th>班级号</th><th>班级名</th><th>专业</th>' +
                        '<th>学生人数</th><th>入学年份</th><th>辅导员</th>' +
                        '</tr>';
                    break;
                case 'courseInfo':
                    elem.innerHTML = '<tr>' +
                        '<th>课程号</th><th>课程名</th><th>课时</th>' +
                        '<th>学分</th>' +
                        '</tr>';
                    break;
                case 'courseTableInfo':
                    elem.innerHTML = '<tr>' +
                        '<th>课表ID</th><th>课程ID</th><th>班级ID</th>' +
                        '<th>教师ID</th><th>时间</th><th>地点</th>' +
                        '</tr>';
                    break;
                case 'scoreInfo':
                    elem.innerHTML = '<tr>' +
                        '<th>学生ID</th><th>课程ID</th><th>分数</th>' +
                        '</tr>';
                    break;
                case 'teacherInfo':
                    elem.innerHTML = '<tr>' +
                        '<th>教师ID</th><th>姓名</th><th>性别</th>' +
                        '<th>出生日期</th><th>学院</th><th>电话</th>' +
                        '</tr>';
                    break;
            }

            for(var i = 0; i < oj.length; i++){
                var tr = document.createElement('tr');
                var pro = Object.keys(oj[i]);
                for(var j = 0; j < pro.length; j++){
                    var td = document.createElement('td');
                    var tt = document.createElement('input');
                    if(j == 0 || j == 1 && what == 'scoreInfo'){
                        tt.disabled = 'disabled';
                    }
                    // tt.oninput = function () {
                    //     this.size = this.value.length > 4 ? this.value.length : 4; // 这里input需要给个size属性
                    // }
                    tt.setAttribute('name', pro[j]);
                    tt.setAttribute('value', oj[i][pro[j]]);
                    td.appendChild(tt);
                    tr.appendChild(td);
                }
                var modify = document.createElement('a');
                var td = document.createElement('td');
                td.appendChild(modify);
                modify.href = 'javascript:void(0);';
                modify.text = '修改';
                modify.onclick = onInfoModify.bind(tr);
                tr.appendChild(td);

                var del = document.createElement('a');
                td = document.createElement('td');
                td.appendChild(del);
                del.href = 'javascript:void(0);';
                del.text = '删除';
                del.onclick = onInfoDelete.bind(tr);
                tr.appendChild(td);
                elem.appendChild(tr);
            }

            var tr = document.createElement('tr');
            var tdFirst = document.createElement('td');
            var tdPrev = document.createElement('td');
            var tdNext = document.createElement('td');
            var tdLast = document.createElement('td');
            var tdState = document.createElement('td');
            tdFirst.innerHTML = '首页';
            tdFirst.onclick = onFirstBtn;
            tdPrev.innerHTML = '上一页';
            tdPrev.onclick = onPrevBtn;
            tdNext.innerHTML = '下一页';
            tdNext.onclick = onNextBtn;
            tdLast.innerHTML = '最后一页';
            tdLast.onclick = onLastBtn;
            tdState.innerHTML = '' + (document.getElementById("show").curContext.curPage + 1) +
                '/' + document.getElementById("show").curContext.pageSum;
            tr.appendChild(tdFirst);
            tr.appendChild(tdPrev);
            tr.appendChild(tdNext);
            tr.appendChild(tdLast);
            tr.appendChild(tdState);
            elem.appendChild(tr);
            document.getElementById('show').innerHTML = '';
            document.getElementById('show').appendChild(elem);
        }
    }

}

function onFresh(){
    elem = document.getElementById("show").curContext;

    // var url = "administrator?what="+ elem.getAttribute("id") + "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;
    var url;
    if(elem.isSearching == true){
        var sel = document.getElementsByTagName('select')[0];
        var conditionKey = sel[sel.selectedIndex].value;
        var conditionValue = document.getElementById('text').value;
        url = "administrator?what="+
            elem.getAttribute("id") + '_search' +
            "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize +
            '&conditionKey='+ conditionKey +'&conditionValue=' + conditionValue;
    }else{
        url = "administrator?what="+
            elem.getAttribute("id") +
            "&start=" + elem.curPage * elem.pageSize + "&number=" + elem.pageSize;
    }
    elem.XMLHttp.open("GET", url, true);
    elem.XMLHttp.send(null);
    elem.XMLHttp.onreadystatechange = OnResponse.bind(elem.XMLHttp, elem.getAttribute("id"));
}
//what=id_search&conditionKey=???&conditionValue=???
function onFirstBtn() {
    elem = document.getElementById("show").curContext;
    elem.curPage = 0;
    onFresh();
}

function onPrevBtn() {
    elem = document.getElementById("show").curContext;
    if (elem.curPage <= 0) {
        alert("已经是第一页！");
        elem.curPage = 0;
        return;
    }

    elem.curPage--;
    onFresh();
}

function onNextBtn() {
    elem = document.getElementById("show").curContext;
    if (elem.curPage >= elem.pageSum - 1) {
        alert("已经是最后一页！");
        elem.curPage = elem.pageSum - 1;
        return;
    }

    elem.curPage++;

    onFresh();
}

function onLastBtn() {
    elem = document.getElementById("show").curContext;
    elem.curPage = elem.pageSum - 1;
    if (elem.curPage < 0) {
        //零条数据记录
        elem.curPage = 0;
    }
    onFresh();
}

function btnOnClike(){
    this.pageSize = 2;
    this.curPage = 0;

    this.XMLHttp.onreadystatechange = null;
    this.XMLHttp.open("GET", "administrator?what=" + this.getAttribute("id") + "_count", false);
    this.XMLHttp.send(null);
    if(this.XMLHttp.readyState == 4 && this.XMLHttp.status == 200){
        var oj = JSON.parse(this.XMLHttp.responseText);
        this.sum = oj.count;
        this.pageSum = Math.ceil(oj.count / this.pageSize);
    }else{
        return ;
    }
    document.getElementById('show').curContext = this;
    this.isSearching = false;

    this.isInsert = false;

    onFirstBtn();
    document.getElementById("show").innerHTML = '';
    document.getElementById("show").style.display = "block";
    // document.getElementById("search").style.display = "block";
    document.getElementById("mod").value = '查找信息'
    document.getElementById("insert_show").style.display = "none";


    //所有按钮置白
    var btns = document.querySelectorAll("#father div");
    for(var i = 0; i < btns.length; i++){
        btns[i].style.backgroundColor = "white";
    }
    //当前常亮
    this.style.backgroundColor = 'hotpink';

    //绘制搜索框
    var searchElem = document.getElementById('search');
    switch (this.getAttribute("id")){
        case 'studentInfo':
            searchElem.querySelector('select').innerHTML = '        <option value=\'stu_id\' selected>学号</option>\n' +
                '        <option value="stu_name">姓名</option>\n' +
                '        <option value="stu_special">专业</option>\n' +
                '        <option value="stu_class_id">班级号</option>';
            break;
        case 'classInfo':
            searchElem.querySelector('select').innerHTML = '        <option value=\'class_name\' selected>班级名称</option>\n' +
                '        <option value="class_special">专业</option>\n' +
                '        <option value="class_year">入学年份</option>';
            break;
        case 'courseInfo':
            searchElem.querySelector('select').innerHTML = '        <option value=\'course_id\' selected>课程号</option>\n' +
                '        <option value="course_name">课程名</option>\n';
            break;
        case 'courseTableInfo':
            searchElem.querySelector('select').innerHTML = '        <option value=\'course_id\' selected>课程号</option>\n' +
                '        <option value="course_name">课程名</option>\n' +
                '        <option value="teacher_id">教师编号</option>\n' +
                '        <option value="time">上课时间</option>';
            break;
        case 'scoreInfo':
            searchElem.querySelector('select').innerHTML = '        <option value=\'stu_id\' selected>学号</option>\n' +
                '<option value="course_id">课程号</option>\n' +
                '<option value="interval">成绩区间</option>\n';
            break;
        default:
            searchElem.style.display = 'none';
            return;
    }
    searchElem.style.display = 'block';
    document.getElementById('text').value = '';
}

function drawTable(elem){
    var html = '<table>';
    switch(elem.getAttribute("id")){
        case 'userInfo':
            html += '<tr>' +
                '<td>用户名</td><td><input name="user_name" type="text" /></td>' +
                '</tr>' +
            '<tr>' +
                '<td>密码</td><td><input  name="password" type="text" /></td>' +
            '</tr>' +
                '<tr>' +
                '<td>用户身份</td><td><input  name="user_type" type="text" /></td>' +
                '</tr>';
            break;
        case 'studentInfo':
            html += '<tr>' +
                '<td>学号</td><td><input name="stu_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>姓名</td><td><input  name="stu_name" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>性别</td><td><input  name="stu_sex" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>出生日期</td><td><input name="stu_birth" type="date" value="2001-7-19"/></td>' +
                '</tr>' +
                '<tr>' +
                '<td>专业</td><td><input  name="stu_special" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>班级号</td><td><input  name="stu_class_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>住址</td><td><input name="stu_address" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>电话</td><td><input  name="stu_phone" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>备注</td><td><input  name="stu_note" type="text" /></td>' +
                '</tr>';
            break;
        case 'classInfo':
            html += '<tr>' +
                '<td>班号</td><td><input name="class_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>班级名</td><td><input  name="class_name" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>专业</td><td><input  name="class_special" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>班级人数</td><td><input name="class_number" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>年份</td><td><input  name="class_year" type="date" value="2001-7-19" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>辅导员</td><td><input  name="class_instructor" type="text" /></td>' +
                '</tr>' ;
            break;
        case 'courseInfo':
            html += '<tr>' +
                '<td>课程号</td><td><input name="course_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>课程名</td><td><input  name="course_name" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>课时</td><td><input  name="course_hours" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>学分</td><td><input name="course_credit" type="text" /></td>' +
                '</tr>' ;
            break;
        case 'courseTableInfo':
            html += '<tr>' +
                '<td>课表号</td><td><input name="ct_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>课程号</td><td><input  name="course_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>班级号</td><td><input  name="class_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>教师编号</td><td><input name="teacher_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>上课时间</td><td><input  name="time" type="date" value="2001-7-19"/></td>' +
                '</tr>' +
                '<tr>' +
                '<td>上课地点</td><td><input  name="place" type="text" /></td>' +
                '</tr>' ;
            break;
        case 'scoreInfo':
            html += '<tr>' +
                '<td>学号</td><td><input name="stu_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>课程号</td><td><input  name="course_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>分数</td><td><input  name="score" type="text" /></td>' +
                '</tr>' ;
            break;
        case 'teacherInfo':
            html += '<tr>' +
                '<td>教师编号</td><td><input name="tc_id" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>教师姓名</td><td><input  name="tc_name" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>教师性别</td><td><input  name="tc_sex" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>教师出生日期</td><td><input name="tc_birth" type="date" value="2001-7-19" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>所属学院</td><td><input  name="tc_depart" type="text" /></td>' +
                '</tr>' +
                '<tr>' +
                '<td>电话</td><td><input  name="tc_phone" type="text" /></td>' +
                '</tr>' ;
            break;
    }

    html += '<tr><td><input type="button" onclick="onSubmit()" value="添加"/></td></tr>'

    html += '</table>';
    document.getElementById('insert_show').innerHTML = html;
}

function onSubmit(){
    var elems = document.querySelectorAll('#insert_show input');

    var elem = document.getElementById('show').curContext;

    //this tr元素
    var queryString = '';
    for(var i = 0; i < elems.length - 1; i++){
        queryString = queryString + elems[i].getAttribute('name') + '=' + elems[i].value + ((i != elems.length - 2) ? '&' : '');
    }

    elem.XMLHttp.open("POST", "administrator?what=" + elem.getAttribute('id') + '_insert', false);
    elem.XMLHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    elem.XMLHttp.onreadystatechange = null;
    elem.XMLHttp.send(queryString);
    if(elem.XMLHttp.readyState == 4 && elem.XMLHttp.status == 200){
        var oj = JSON.parse(elem.XMLHttp.responseText);
        if(oj.state == 'success') {
            alert("添加成功！");

            ++elem.sum;
            elem.pageSum = Math.ceil(elem.sum / elem.pageSize)
            // onFresh();
        }else{
            alert("添加失败！");
        }
    }else{
        return;
    }
}

function modChange(){
    elem = document.getElementById("show").curContext;
    elem.isInsert = !elem.isInsert;

    if(elem.isInsert){
        drawTable(elem);
        document.getElementById("show").style.display = "none";
        if(elem.hasSearch == true) {
            document.getElementById("search").style.display = "none";
        }
        document.getElementById("mod").value = '添加信息'
        document.getElementById("insert_show").style.display = "block";

    }else{
        onFresh();
        document.getElementById("show").style.display = "block";
        if(elem.hasSearch == true){
            document.getElementById("search").style.display = "block";
        }
        document.getElementById("mod").value = '查找信息'
        document.getElementById("insert_show").style.display = "none";
    }
}

//what=id_search&conditionKey=???&conditionValue=???
function onSearchBtn(){
    elem = document.getElementById("show").curContext;
    var sel = document.getElementsByTagName('select')[0];
    var conditionKey = sel[sel.selectedIndex].value;
    var conditionValue = document.getElementById('text').value;

    elem.pageSize = 2;
    elem.curPage = 0;
    elem.XMLHttp.onreadystatechange = null;
    //重新获取页面数
    elem.XMLHttp.open("GET", "administrator?what=" + elem.getAttribute("id") + "_search_count" + '&conditionKey='+ conditionKey +'&conditionValue=' + conditionValue, false);
    elem.XMLHttp.send(null);
    if(elem.XMLHttp.readyState == 4 && elem.XMLHttp.status == 200){
        var oj = JSON.parse(elem.XMLHttp.responseText);
        elem.sum = oj.count;
        elem.pageSum = Math.ceil(oj.count / elem.pageSize);
    }else{
        return ;
    }
    elem.isSearching = true;
    onFirstBtn();
}




window.onload = function (){
    var btns = document.querySelectorAll("#father div");
    for(var i = 0; i < btns.length; i++){
        btns[i].hasSearch = true;
        btns[i].onclick = btnOnClike;
        btns[i].XMLHttp = GetXmlHttpObject();
        btns[i].onmouseover = function (){
            this.style.backgroundColor = "hotpink";
        }
        btns[i].onmouseout = function (){
            if(document.getElementById('show').curContext == this){
                return;
            }
            this.style.backgroundColor = "white";
        }
    }
    btns[0].hasSearch = false;
    btns[btns.length - 1].hasSearch = false;
    var modElem = document.getElementById('mod');

    modElem.onclick = modChange;

    btns[0].onclick();
}
//changeScoreInfo
