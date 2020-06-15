# TeacherReview-back-end
>>>>>>>>>>>>>>>># 师生互选助手
>>>>>这是后端项目源码，项目基于SpringBoot+MyBatis框架快速搭建，目前只支持部分功能。

<div align=right>
     <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/logo.png" height = "90"  alt = "授权界面"/> 
</div>

>>>>>前端项目地址：https://github.com/Onemeaning/WeChatProject
>>>>>详细介绍文档：https://github.com/Onemeaning/TeacherReviewBackEnd/blob/master/师生互选助手介绍文档.pdf

## 目录
* [项目背景](#项目背景)
* [开发环境](#开发环境)
* [项目背景](#项目结构)
* [DEMO演示](#DEMO演示)
* [功能介绍](#功能介绍)
* [版本介绍](#版本介绍)
  * [版本1.0](#1.0)
  * [版本1.1](#1.1)
  * [版本1.3](#1.3)
  * [版本1.4](#1.4)
  * [版本1.5](#1.5)
  * [版本1.6](#1.6)
  * [版本1.7](#1.7)
  * [版本1.8](#1.8)
  * [版本1.9](#1.9)
* [联系方式](#联系方式)

<a name = "项目背景"><a/>
## 一、项目背景
　　还记得2017年9月份，那时候正好拿到学校的推免资格，这时候将面临一个问题————`选导师`,对于理想院校却因没有任何熟悉的同学可以咨询，只能靠自己在网上搜索，但是大部分结果都是对于这个学校的这个专业的评价，极少有对老师有点评的，因此你很难做出判断这个老师是科研能力强，还是项目能力好，是负责任型、还是放羊型、是高要求高期望、还是任凭你放荡、是毕业要求高、还是可以混等等……，你根本得不出结论，当我绝望的时候，我觉得自己有必要开发出一款《师生互选助手》非常有必要，让有经验的人为自己系的导师打call，通过评价、点赞等方式、让好的导师让更多的人知道；在这里你还可以跟老师联系，如果您是老师，你可以在这里发布招生需求，这样同学老师之间互相选择，相互受益；这也就是我写这个系统的初衷。<br/>

<a name = "开发环境"><a/>
## 二、开发环境
  
<a name = "项目结构"><a/>
## 三、项目结构

<a name = "DEMO演示"><a/>
## 四、DEMO演示
     
   #### 4.1 GIF演示
       由于文档对于单个GIF时间不能超过1分钟，这里将三分钟的演示效果用三个GIF图来演示，效果不太好，大家可以点击下方的演示视频惊醒观看；
       
<div align=center>
 <img src=https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/demo_gif/demo_p1.gif height = "400" alt = "演示demo1"/>
 <img src=https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/demo_gif/demo_p2.gif height = "400" alt = "演示demo2"/>
 <img src=https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/demo_gif/demo_p3.gif height = "400" alt = "演示demo3"/>
</div> 
     
   #### 4.2 [演示视频](https://www.bilibili.com/video/av54031932)

<a name = "功能介绍"><a/>
## 五、功能介绍

#### 授权登陆
>>* 用户可以借助`微信小程序`授权，同时以微信小程序的openID作为用户的唯一标识以及其他useInfo添加至数据库作为一条用户信息；点击 主界面->授权登陆,即可进入程序<br/>
<div align=center> <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/两个方式授权登陆界面.png" height = "400"  alt = "授权界面"/> </div> <br/><br/>

>>* 您可以选择学生身份或者导师身份登录,如果选择导师的身份.我们需要对您进行人脸识别来认证您的真实身份;
<div align=center> <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/导师身份认证页面.png" height = "400"  alt = "导师认证界面"/> </div> <br/><br/>

>>* 在导师认证的过程中,您可能会得到如下结果;1、非活体信息（这是因为您没有使用自己自拍照）；2、匹配得分少于八十（并非您本人）；3、系统暂时没有添加该导师（这是因为您的个人信息还没加入到数据库中，此时可以联系管理员解决）；4、false（这是因为您的数据库中照片不存在或者非证件照类型,此时可以联系管理员解决）；否则就认证成功了；
<div align=center>
 <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/非活体照片.png" height = "400"  alt = "非活体照片"/> 
 <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/照片相似度低.png" height = "400"  alt = "照片相似度低"/> 
  <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/系统暂时没有添加老师返回结果.png" height = "400"  alt = "系统暂时没有添加老师返回结果"/> 
</div>

>>* 认证身份之后就会进入到主界面中，
<div align=center> <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/主页面.png" height = "400"  alt = "主页面"/> </div> <br/><br/>

 
#### 第一步 进入院校选择界面;在主界面中，您可以点击‘搜索导师信息’按钮去寻找您想了解某个系的老师信息
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/select.png" height = "400"  alt = "推荐导师界面"/> </div> <br/><br/>  
  
  
>>* 查询某个系所有老师的信息；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/某个系所有老师.png" height = "400"  alt = "某个系所有老师信息界面"/> </div>

>>* 当然您也可以在“热门导师推荐页面”的搜索栏中按照学校院系的方式模糊查询该系的老师，或者某个专业的老师的简要信息；当然您也可以点击右上方的《学校》按钮来快速选择您想了解的学校老师信息；<br/><br/>
<div align=center>
 <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/热门导师推荐首页.png" height = "400"  alt = "热门导师推荐首页"/>
 <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/推荐导师界面.png" height = "400"  alt = "推荐导师界面"/>
</div>

#### 第二步 点击进入导师专业详细信息界面,在这个页面可以查看导师的详细资料，点击下方的点赞按钮，您可以给心仪的老师助力，让他被更多的学生发现，您也可以点击下方评论按钮，给您喜欢的老师点评一下！<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/导师详细信息界面.png" height = "400"  alt = "老师详细信息界面"/> </div> 

#### 第三步 查看导师详细资料和学生评;用户可以对某个老师进行点评、也可以删除自己的评论（删除品论根据用户的ID+评论时间位移识别）；<br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/评论界面.png" height = "400"  alt = "评论界面"/> </div> <br/><br/>

#### 第四步 给心仪的老师发私信,在这个页面你可以给老师发私信，您可以详细的介绍自己，让导师可以更好的了解你，当然你也可以添加照片形式的简历，让老师全面的了解你，这也会增加你被老师选中的机会，祝你好运！<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/发送私信界面.png" height = "400"  alt = "发送私信界面"/> </div> 

#### 第五步 进入我的界面，查看个人信息，收到私信情况；在这里会根据不同的授权登陆身份显示不同的界面<br/><br/>
<div align=center>
    <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/学生用户看到的我的界面.png" height = "400"  alt = "学生用户看到的我的界面"/><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/导师看到的自己信息页面.png" height = "400"  alt = "导师看到的自己信息页面"/>
</div> 

>>* 修改个人资料界面；导师和学生会赋予不一样的修改权限；
<div align=center>
    <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/学生用户看到的我的界面.png" height = "400"  alt = "普通用户修改信息页面.png"/><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/导师身份修改个人信息界面.png" height = "400"  alt = "导师身份修改个人信息界面"/>
</div> 

#### 第六步 查看老师回复的私信,在这里，您可以看到老师给您的回复，同样您也可以继续回复他，愉快的交流可以让导师最终选择您的几率增大。
<div align=center>
    <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/收到所有私信总览.png" height = "400"  alt = "收到所有私信总览"/><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/查看私信具体信息页面.png" height = "400"  alt = "查看私信具体信息页面"/>
</div> 

<a name = "版本介绍"><a/>
## 六、版本介绍
  <a name = "1.0"><a/>
   
### 1.0版本
>>* (1)查询导师信息
>>* (2)对老师进行评论
>>* (3)对老师的信息点赞，但是一个人可以点赞多次
>>* (4)查看个人信息
   
  <a name = "1.1"><a/>
 
### 1.1版本更新如下
>>* (1)可以实现对别人的评论点赞
>>* (2)可以点赞老师信息
>>* (3)所有的点赞信息都只能点赞一次，第二次为取消点赞
>>* (4)统计每个老师页面访问次数

<a name = "1.3"><a/>
 
### 1.3版本更新如下
>>* (1)新增了按专业搜索热门导师（前五）信息
>>* (2)新增了获取前端发送的反馈意见信息（处理多张图片情况）
>>* (3)修复了删除某条评论时候，不会删除这条评论对应的点赞情况这个BUG

<a name = "1.4"><a/>
 
### 1.4版本更新如下(2019/4/24本次重要更新)
>>* (1)新增给导师私发邮件，回复邮件，查询邮件细节，邮件到达通知，未读邮件个数等功能；
>>* (2)新增用户可以修改个人信息；
>>* (3)新增用户提交的数据保存到数据库中；

<a name = "1.5"><a/>
 
### 1.5版本更新如下(2019/5/12本次重要更新)
>>* 【重要】（1）新增导师认证接口（util包中四个关键类），使用百度AI人脸比对API实现导师身份认证功能（用户上传一张自拍照和数据中存储的老师的证件照）进行比对；比对之后立马删除临时文件夹中的所有文件；
>>* （2）新增为用户提供查看私信中的简历照片的接口，查询完之后删除临时文件夹的功能；
>>* （3）更新了使用新的帮助截图（非常好看）；
>>* （4）前端不再是用advice所提供的接口，这里暂时还有没有删除该接口；

<a name = "1.6"><a/>
 
### 1.6版本更新如下(2019/5/13本次重要更新)
>>* 【重要】（1）修复每次打成war包时，总是不包括本地的lib目录中的jar包；
>>* （2）修复导师认证过程中总是出现（非活体照片），是原因是设置来自数据库中的照片格式必须为活体照片（LIVE），但是数据库中的照片本因为证件照片，修复后已经更改为证件照片类型IDCARD；
>>* （3）修复导师认证之后只会更改老师数据库中的ID，而不会修改邮件库、评论库、点赞库中的原ID，这导致了之前的评论都无法查看；
>>* （4）添加了一些新的前端的照片；

<a name = "1.7"><a/>
 
### 1.7版本更新如下(2019/5/19本次重要更新)
>>*  (1)新增查看历史聊天记录功能;
>>*  (2)修改logo;
>>*  (3)新增GIF图的演示DEMO;
>>*  (4)重新布局README文件;

---
<a name = "1.8"><a/>

### 1.8本次更新记为版本1.0.0，版本元年（代号：扁舟）(2019/6/22本次重要更新)
>>*  (1)新增百度自然语言处理API;
>>*  (2)新增统计老师科研论文、项目数量，动态变化情况;
>>*  (3)新增屏蔽负面评价;
>>*  (4)新增老师画像，给老师打标签;

<a name = "1.9"><a/>

### 1.9本次更新记为版本1.0.0，版本元年（代号：扁舟）(2019/7/6本次更新)
>>*  (1)更新老师可以发布招生需求功能;

<a name = "联系方式"><a/>
 
## 联系方式
  email: wminglin@hnu.edu.cn;
