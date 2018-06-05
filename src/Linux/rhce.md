#  公司的rhce培训
## Yum常用命令
* yum list all 列出仓库中所有软件包
* yum info 查看软件包信息
* yum install 安装软件包
* yum reinstall 重新安装软件包
* yum update 升级软件包
* yum remove 移除软件包
* yum clean all 清除所有仓库缓存
* yum check-update 检查可更新的软件包
* yum grouplist 查看系统中已经安装的软件包组
* yum groupinstall 安装指定的软件包组
* yum groupremove 移除指定的软件包组
* yum groupinfo 查询指定的软件包组信息

## RHEL7采用systemd初始化进程
* systemctl start xxx.service 启动服务
* systemctl restart xxx.service 重启服务
* systemctl stop xxx.service 停止服务
* systemctl reload xxx.service 重新加载配置文件（不终止服务）
* systemctl status xxx.service 查看服务状态
* systemctl enable xxx.servie 开机自动重启
* systemctl disable xxx.service 开机不自动启动
* systemctl is-enabled xxx.service 查看特定服务是否为开机自动启动

## Linux 命令
* man 命令 查看帮助内容信息 ： man man 后看到帮助提示，可以执行如如下操作
    * 空格向下翻页
    * PaGe down 向下翻页
    * PaGe up 向上翻页
    * home 直接前往首页
    * end 直接前往尾页
    * / 从上至下搜索某个关键词 /linux
    * ? 从下至上搜索某个关键词 ?Linux
    * n 定位到下一个搜索到的关键词
    * N 定位到上一个搜索到的关键词
    * q 退出帮助文档
    * NAME 命令的名称
    * SYNOPSIS 参数的大致使用方法
    * DESCRIPTION 介绍说明
    * EXAMPLES 演示（附带简单说明）
    * OVERVIEW 概述
    * DEFAULTS 默认的功能
    * OPTIONS 具体的可用选项（带介绍）
    * ENVIRONMENT 环境变量
    * FILES 用到的文件
    * SEE ALSO 相关的资料
    * HISTORY 维护历史与联系方式
* echo 命令用于在terminal输出字符串或变量提取后的值
    * echo dayday Terminal print dayday
    * echo $SHELL Terminal print /bin/bash
* data命令用于显示及设置系统的时间或日期
    * date print Tue Jun  5 10:10:49 CST 2018
    * date "+%Y-$m-$d %H:$M:%S" print date "+%Y-%m-%d %H:%M:%S"
    * date -s "20170901 8:30:00" 设置当前时间
    * date "+%j" 显示今天是第几天
* reboot命令重启系统 需要管理员权限
* poweroff命令关闭系统，需要管理员权限
* wget命令用于在Terminal中下载网络文件
    * -b 后台下载模式
    * -p 下载到指定目录
    * -t 最大尝试次数
    * -c 断点续传
    * -p 下载页面内所有资源，包括图片、视频等
    * -r 递归下载
* ps 命令用于查看系统进程状态
    * -a 限制所有进程（包括其他用户的进程）
    * -u 用户以及其他详细信息
    * -x 显示没有控制终端的进程     
    * 进程有五种常见状态
        * R(运行):进程正在运行或运行队列中等待
        * S(中断):进程处于休眠中，当某个条件形成后或者接到信号时， 则脱离该状态
        * D(不可中断):进程不响应系统异步信号，即便用kill命令也不能将其中断
        * Z(僵死):进程已经终止，但进程描述符依然存在，直到父进程调用wait4()系统函数后将进程释放
        * T(停止):进程收到停止信号后停止运行
* top命令用于动态地监视进程活动与系统负载等信息，其格式为top   
* pidof命令用于查询某个指定服务进程的PID值
    * pidof sshd
* kill命令用于终止某个指定PID的服务进程
    * kill 2156
* killall命令用于终止某个指定名称服务所对应的全部进程
    * kill httpd     
* ifconfig命令用于获取网卡配置与网络状态等信息
    * ifconfig
    