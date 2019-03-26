# TeacherReview-back-end
#导师点评系统
项目基于SpringBoot+MyBatis框架快速搭建，目前只支持部分功能。<br/>
##1.0版本功能体验
*用户可以借助`微信小程序`授权，同时以微信小程序的openID作为用户的唯一标识以及其他useInfo添加至数据库作为一条用户信息；<br/>
![授权界面](src/main/resources/static/authorize.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/300)<br/>
*获取点赞数前五的老师信息；<br/>
![主页界面](src/main/resources/static/recomment.jpg)
*按照学校院系的方式模糊查询该系的老师，同时返回该系点赞数前五的老师名单；<br/>
![老师界面](src/main/resources/static/teachers.jpg)<br/>
*按老师ID查询老师的具体信息；<br/>
![老师详细信息界面](src/main/resources/static/deatils.jpg)<br/>
*用户可以对某个老师进行点评、也可以删除自己的评论（删除品论根据用户的ID+评论时间位移识别）；<br/>
![评论界面](src/main/resources/static/commment.jpg)<br/>
*用户可以给老师点赞，每个人为每个老师点赞的次数仅为一次；<br/>
![点赞界面](src/main/resources/static/support.jpg)<br/>
