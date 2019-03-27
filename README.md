# TeacherReview-back-end
>>>>>>>>>>>>>>>># 导师点评系统
>>>>>>>>>>项目基于SpringBoot+MyBatis框架快速搭建，目前只支持部分功能。<br/>
## 目录
* [项目背景](#项目背景)
* [开发环境](#开发环境)
* [项目背景](#项目结构)
* [功能介绍](#功能介绍)
  * [版本1.0](1.0)
  * [版本1.1](1.1)
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
>>* 用户可以借助`微信小程序`授权，同时以微信小程序的openID作为用户的唯一标识以及其他useInfo添加至数据库作为一条用户信息；<br/><br/>
<div align=center> <img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/authorize.png" height = "300"  alt = "授权界面"/> </div> <br/><br/>
  
>>* 获取点赞数前五的老师信息；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/recomment.jpg" height = "300"  alt = "主页界面面"/> </div> <br/><br/>

>>* 按照学校院系的方式模糊查询该系的老师，同时返回该系点赞数前五的老师名单；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/teachers.png" height = "300"  alt = "老师界面"/> </div> <br/><br/>

>>* 按老师ID查询老师的具体信息；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/deatils.png" height = "300"  alt = "老师详细信息界面"/> </div> <br/><br/>

>>* 用户可以对某个老师进行点评、也可以删除自己的评论（删除品论根据用户的ID+评论时间位移识别）；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/commmnet.png" height = "300"  alt = "评论界面"/> </div> <br/><br/>

>>* 用户可以给老师点赞，每个人为每个老师点赞的次数仅为一次；<br/><br/>
<div align=center><img src="https://github.com/Onemeaning/TeacherReview-back-end/blob/master/src/main/resources/static/support.png" height = "300"  alt = "点赞界面"/> </div> <br/><br/>

<a name = "1.1"><a/>
### 1.1版本更新如下
>>* 可以实现对别人的评论点赞
>>* 可以点赞老师信息
>>* 所有的点赞信息都只能点赞一次，第二次为取消点赞
>>* 统计每个老师页面访问次数
 
***
<a name = "联系方式"><a/>
## 联系方式
  email: wminglin@hnu.edu.cn;
