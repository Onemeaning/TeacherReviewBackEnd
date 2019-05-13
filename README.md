# TeacherReview-back-end
>>>>>>>>>>>>>>>># 导师点评系统
>>>>>这是后端项目源码，项目基于SpringBoot+MyBatis框架快速搭建，目前只支持部分功能。<br/>
>>>>>前端项目地址：https://github.com/Onemeaning/WeChatProject<br/>
## 目录
* [项目背景](#项目背景)
* [开发环境](#开发环境)
* [项目背景](#项目结构)
* [功能介绍](#功能介绍)
  * [版本1.0](#1.0)
  * [版本1.1](#1.1)
  * [版本1.3](#1.3)
  * [版本1.4](#1.4)
  * [版本1.5](#1.5)
  * [版本1.6](#1.6)
* [联系方式](#联系方式)

<a name = "项目背景"><a/>
## 项目背景
　　还记得2017年9月份，那时候正好拿到学校的推免资格，这时候将面临一个问题————`选导师`,由于自己对于理想院校没有任何熟悉的同学可以咨询，只能靠自己在网上搜索，但是大部分结果都是对于这个学校的这个专业的评价，极少有对老师有点评的，因此你很难做出判断这个老师是科研能力强，还是项目能力好，是负责任型、还是放羊型、是高要求高期望、还是任凭你放荡、是毕业要求高、还是可以混等等……，你根本得不出结论，当我绝望的时候，我觉得自己开发出一款导师点评系统非常有必要，让有经验的人为自己系的导师打call，通过评价、点赞等方式、让好的导师让更多的人知道，这也就是我写这个系统的初衷。<br/>

<a name = "开发环境"><a/>
## 开发环境
  
<a name = "项目结构"><a/>
## 项目结构
  
<a name = "功能介绍"><a/>
## 功能介绍
  <a name = "1.0"><a/>
### 1.0版本功能体验
>>* 用户可以借助`微信小程序`授权，同时以微信小程序的openID作为用户的唯一标识以及其他useInfo添加至数据库作为一条用户信息；点击 主界面->授权登陆,即可进入程序,您可以选择学生身份或者导师身份登录，如果选择导师的身份，我们需要对您进行人脸识别来认证您的真实身份<br/><br/>
<div align=center> <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/authorize.png" height = "300"  alt = "授权界面"/> </div> <br/><br/>
  
>>* 第一步 进入院校选择界面；在热门导师推荐页面，您可以点击右上角的《学校》按钮来选择具体的专业，我们为您列出了这个专业的所有的老师的热度排名，您可以用左滑的形式，查看所有的导师简介，点击页面则会进入老师页面查看详细信息，您也可以在搜索栏中搜索专业信息，例如搜索《计算机科学与技术》系统会将全国数据库中所有计算机科学与技术专业的导师信息按照热度排序列出，你也可以按照左滑的形式依次查看。<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/select.png" height = "300"  alt = "推荐导师界面"/> </div> <br/><br/>  
  
  
>>* 查询某个系所有老师的信息<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/screenshot/某个系所有老师.png" height = "300"  alt = "某个系所有老师信息界面"/> </div> <br/><br/>

>>* 按照学校院系的方式模糊查询该系的老师，或者某个专业的老师；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/teachers.png" height = "300"  alt = "老师界面"/> </div> <br/><br/>

>>* 第二步 点击进入导师专业详细信息界面,在这个页面可以查看导师的详细资料，点击下方的点赞按钮，您可以给心仪的老师助力，让他被更多的学生发现，您也可以点击下方评论按钮，给您喜欢的老师点评一下！<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/details.png" height = "300"  alt = "老师详细信息界面"/> </div> <br/><br/>

>>* 第三步 查看导师详细资料和学生评;用户可以对某个老师进行点评、也可以删除自己的评论（删除品论根据用户的ID+评论时间位移识别）；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/commmnet.png" height = "300"  alt = "评论界面"/> </div> <br/><br/>

>>* 第四步 给心仪的老师发私信,在这个页面你可以给老师发私信，您可以详细的介绍自己，让导师可以更好的了解你，当然你也可以添加照片形式的简历，让老师全面的了解你，这也会增加你被老师选中的机会，祝你好运！<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/sendEmail.png" height = "300"  alt = "点赞界面"/> </div> <br/><br/>

>>* 第五步 查看老师回复的私信,在这里，您可以看到老师给您的回复，同样您也可以继续回复他，愉快的交流可以让导师最终选择您的几率增大。<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/me.png" height = "300"  alt = "我的界面"/> </div> <br/><br/>


<a name = "1.1"><a/>
### 1.1版本更新如下
>>* 可以实现对别人的评论点赞
>>* 可以点赞老师信息
>>* 所有的点赞信息都只能点赞一次，第二次为取消点赞
>>* 统计每个老师页面访问次数

<a name = "1.3"><a/>
### 1.3版本更新如下
>>* (1)新增了按专业搜索热门导师（前五）信息
>>* (2)新增了获取前端发送的反馈意见信息（处理多张图片情况）
>>* (3)修复了删除某条评论时候，不会删除这条评论对应的点赞情况这个BUG

<a name = "1.4"><a/>
### 1.4版本更新如下(2019/4/24本次重要更新)
>>* （1）新增给导师私发邮件，回复邮件，查询邮件细节，邮件到达通知，未读邮件个数等功能；
>>* （2）新增用户可以修改个人信息；
>>*  (3)新增用户提交的数据保存到数据库中；

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
>>* （4）添加了一些新的前端的照片

<a name = "联系方式"><a/>
## 联系方式
  email: wminglin@hnu.edu.cn;
