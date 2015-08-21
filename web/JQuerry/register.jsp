<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/JavaScript" src="../js/manage.js"/>
</head>
<body>
	<form action="" method="post" name="form1" onSubmit="MM_validateForm('username','','R','email','','R','fullname','','R','textfield','','R','textfield2','','R','idcard','','R','password','','R','password2','','R');return document.MM_returnValue">
 		<TABLE width="98%" align=center border=0>
    		<TBODY>
      		<TR>
        		<TD height="30" colspan="2">
          		<div align="center" class="style1">请输入注册用户信息</div></TD>
      		</TR>
            <TR>
        <TD width="15%" bgColor=#f8f8f8>
          <DIV align=right>*域名/用户名：</DIV></TD>
        <TD bgColor=#f8f8f8><INPUT class=textbox size=16 
            name=username>
          .go.51.net &nbsp;
          <INPUT onclick=javascript:Check() type=button value=检测域名 name=button>
          <BR>
          <FONT 
            color=#285f94>(您的域名只能由小写英文字母、数字组成，必须以字母开头，5≤长度≤16，用户名和域名相同)</FONT></TD>
      </TR>
      <TR>
        <TD>
          <DIV align=right>*密码：</DIV></TD>
        <TD><INPUT class=textbox type=password size=16 name=password>
            <FONT 
            color=#285f94>(密码只能由英文字母和数字组成，区分大小写，6≤长度≤16)</FONT></TD>
      </TR>
      <TR>
        <TD bgColor=#f8f8f8>
          <DIV align=right>*密码：</DIV></TD>
        <TD bgColor=#f8f8f8><INPUT class=textbox type=password size=16 
            name=password2>
            <FONT color=#285f94>(重复密码。密码选定后将无法更改)</FONT></TD>
      </TR>
      <TR>
        <TD>
          <DIV align=right>*Email：</DIV></TD>
        <TD><INPUT name=email class=textbox onBlur="MM_validateForm('email','','NisEmail');return document.MM_returnValue" size=16>
            <FONT 
            color=#285f94>(请填写长期有效的Email地址，帐号的激活信将发送到此邮箱，这是您开通空间的依据)</FONT></TD>
      </TR>
      <TR>
        <TD bgColor=#f8f8f8>
          <DIV align=right>*姓名：</DIV></TD>
        <TD bgColor=#f8f8f8><INPUT class=textbox size=16 name=fullname>        </TD>
      </TR>
      <TR bgcolor="#FFFFFF">
        <TD><div align="right">性别：</div></TD>
        <TD><input name="sex" type="radio" value="0" checked>
    男　
      <input type="radio" name="sex" value="1">
    女</TD>
      </TR>
      <TR>
        <TD><div align="right">*出生日期：</div></TD>
        <TD bgcolor="#F8f8f8f8"><input name="textfield" type="text" value="20" size="5" maxlength="4">
          年
            <select name="select">
            <option value="1" selected>01</option>
            <option value="2">02</option>
            <option value="3">03</option>
            <option value="4">04</option>
            <option value="5">05</option>
            <option value="6">06</option>
            <option value="7">07</option>
            <option value="8">08</option>
            <option value="9">09</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
          </select>
          月
          <input name="textfield2" type="text" size="3" maxlength="2">
          日</TD>
      </TR>
      <TR>
        <TD>
          <DIV align=right>*身份证号码：</DIV></TD>
        <TD onfocus="MM_validateForm('idcard','','NisNum');return document.MM_returnValue"><INPUT class=textbox maxLength=18 size=18 name=idcard>        </TD>
      </TR>
      <TR>
        <TD bgColor=#f8f8f8>
          <DIV align=right>电话：</DIV></TD>
        <TD bgColor=#f8f8f8><INPUT class=textbox size=16 name=phone>        </TD>
      </TR>
      <TR>
        <TD>
          <DIV align=right>*网站分类：</DIV></TD>
        <TD><SELECT name=category>
            <OPTION value=0 selected>请选择</OPTION>
            <OPTION value=1>电脑网络</OPTION>
            <OPTION value=2>休闲娱乐</OPTION>
            <OPTION value=3>情感天地</OPTION>
            <OPTION value=4>游戏世界</OPTION>
            <OPTION value=5>汽车房产</OPTION>
            <OPTION value=6>体育健康</OPTION>
            <OPTION value=7>法律法规</OPTION>
            <OPTION value=8>文化艺术</OPTION>
            <OPTION value=9>医药卫生</OPTION>
            <OPTION value=10>教育科研</OPTION>
            <OPTION value=11>旅游交通</OPTION>
            <OPTION value=12>新闻时事</OPTION>
            <OPTION value=13>投资理财</OPTION>
            <OPTION value=14>公司企业</OPTION>
            <OPTION value=15>政治军事</OPTION>
            <OPTION value=16>校园生活</OPTION>
            <OPTION value=17>个人主页</OPTION>
            <OPTION 
            value=99>其他类型</OPTION>
          </SELECT>        </TD>
      </TR>
      <TR>
        <TD bgColor=#f8f8f8>
          <DIV align=right>*省份：</DIV></TD>
        <TD bgColor=#f8f8f8><SELECT name=state>
            <OPTION value=0 
              selected>请选择</OPTION>
            <OPTION value=1>北京市</OPTION>
            <OPTION 
              value=2>天津市</OPTION>
            <OPTION value=3>上海市</OPTION>
            <OPTION 
              value=4>重庆市</OPTION>
            <OPTION value=5>河北省</OPTION>
            <OPTION 
              value=6>山西省</OPTION>
            <OPTION value=7>辽宁省</OPTION>
            <OPTION 
              value=8>吉林省</OPTION>
            <OPTION value=9>江苏省</OPTION>
            <OPTION 
              value=10>浙江省</OPTION>
            <OPTION value=11>安徽省</OPTION>
            <OPTION 
              value=12>福建省</OPTION>
            <OPTION value=13>江西省</OPTION>
            <OPTION 
              value=14>山东省</OPTION>
            <OPTION value=15>河南省</OPTION>
            <OPTION 
              value=16>黑龙江省</OPTION>
            <OPTION value=17>湖北省</OPTION>
            <OPTION 
              value=18>湖南省</OPTION>
            <OPTION value=19>广东省</OPTION>
            <OPTION 
              value=20>广西壮族自治区</OPTION>
            <OPTION value=21>海南省</OPTION>
            <OPTION 
              value=22>四川省</OPTION>
            <OPTION value=23>贵州省</OPTION>
            <OPTION 
              value=24>陕西省</OPTION>
            <OPTION value=25>甘肃省</OPTION>
            <OPTION 
              value=26>青海省</OPTION>
            <OPTION value=27>西藏自治区</OPTION>
            <OPTION 
              value=28>内蒙古自治区</OPTION>
            <OPTION value=29>宁夏回族自治区</OPTION>
            <OPTION 
              value=30>新疆维吾尔族自治区</OPTION>
            <OPTION value=31>香港特别行政区</OPTION>
            <OPTION value=32>澳门特别行政区</OPTION>
            <OPTION value=33>台湾</OPTION>
            <OPTION value=99>其他</OPTION>
          </SELECT>        </TD>
      </TR>
      <TR>
        <TD>
          <DIV align=right>通讯地址：</DIV></TD>
        <TD><INPUT class=textbox size=50 name=address>        </TD>
      </TR>
      <TR>
        <TD><div align="right">兴趣爱好：</div></TD>
        <TD bgcolor="#F8F8F8"><input type="checkbox" name="checkbox" value="yiyue">
          音乐
          <input name="checkbox2" type="checkbox" id="checkbox2" value="diannao">
          电脑
          <input name="checkbox3" type="checkbox" id="checkbox3" value="mishu">
          美术
          <input type="checkbox" name="checkbox4" value="wenxue">
          文学
          <input type="checkbox" name="checkbox5" value="yingshi">
          影视
          <input type="checkbox" name="checkbox6" value="lvyou">
          旅游          </TD>
      </TR>
    </TBODY>
  </TABLE>
  <br>  
  <TABLE width="50%" align=center border=0>
    <TBODY>
      <TR>
        <TD>          <DIV align=center>
          <input type=hidden 
            value=bcf80edef31784044bbd95a1a3127c31 name=s>
          <input name="image" type=image src="img/next.gif" width=79 
            height=24 border=0>
</DIV></TD>
        <TD>
          <DIV align=center>
            <input name="image2" 
            type=image onClick="signup_form.reset();return false;" src="img/reset.gif" width=79 height=24 
            border=0>
</DIV></TD>
      </TR>
    </TBODY>
  </TABLE>
  <p>&nbsp;</p>
</form>
</body>
</html>