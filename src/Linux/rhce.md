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