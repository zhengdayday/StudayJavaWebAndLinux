#  准备公司的rhce培训
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

## 常用系统工作命令
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
## 系统状态检测命令    
* ifconfig命令用于获取网卡配置与网络状态等信息
    * ifconfig
* uname命令用于查看系统内核与系统版本等信息
    * uname -a   
* uptime用于查看系统的负载信息
    * uptime
* free命令用于显示档期系统中内存的使用量信息
    * free -h
* who 用于查看当前登入主机的终端信息      
    * who
* last命令用于查看所有系统的登录记录      
    * last
* history 用于显示历史执行过的命令
    * history 存在.bash_history文件中 .表示隐藏文件
* sosreport 用于收集系统配置及架构信息并输出诊断文档
    * sosreport
## 工作目录切换命令    
* pwd命令用于显示用户当前所处的工作目录
    * pwd
* cd命令用于切换工作路径  
    * cd
* ls用于显示目录中的文件信息
    * ls 
    * ls -al -a查看全部文件-l查看文件属性
    * ls -ld /etc -d查看目录权限与属性信息
## 文本文件编辑命令
* cat命令用于查看纯文本文件（内容较少）
    * cat -n xxx  -n参数可以显示行号
* more 用于查看纯文本文件（内容较多）
    * more xxx
* head 用户查看纯文本文档的前N行
    * head -n 20 xxx
* tail 用于查看纯文本文档的后N行
    * tail -f xxx   -f可以实时更新,比如日志
    * tail -n 20
* tr 用于替换文本文件中的字符
    * cat xx | tr [a-z] [A-Z]  
* wc命令用于统计指定文本的行数、字数、字节数
    * wc -l 只显示行数
    * wc -w 只显示单词数
    * wc -c 只显示字节数
* stat 用于查看文件的具体存储信息和时间信息  
    * stat xxx
* cut 用于按‘列’提取文本字符
    * cut -d: -f1 xxx  -d设置间隔符  -f设置需要看的列数
* diff命令用于比较多个文本文件的差异
    * diff --brief xxx xxx  --brief显示比较后的结果，判断文件是否相同
    * diff -c xxx xxx -c参数来描述文件内容的具体不同
## 文件目录管理命令
* touch 命令用于创建空白文件或设置文件的时间
    * -a 仅读取时间(atime)
    * -m 仅修改时间(mtime)
    * -d 同时修改atime与mtime    
    * touch -d "日期"  xxx
* mkdir命令用于创建空白的目录
    * mkdir -p x/xx/xxx -p用于创建具有嵌套叠层的文件目录
* cp命令用于复制文件或目录    
    * -p 保留原始文件的属性
    * -d 若对象为“链接文件”，则保留该“链接文件”的属性
    * -r 递归持续复制（用于目录）
    * -i 若目标文件存在则询问是否覆盖
    * -a 相当于-pdr（p、d、r 为上述参数）
    * cp xxx xxx cp 参数 源文件 目标文件
* mv命令用于剪切文件或文件重命名
    * mv 参数 源文件 目标路径/目标文件名
* rm命令用于删除文件或目录
    * -f 强制删除
    * -r删除目录
* dd命令用于按照指定大小和个数的数据块复制文件或转换文件 dd 参数
   * if 输入的文件名称
   * of 输出的文件名称
   * bs 设置每个“块”的大小
   * count 设置要复制“块”的个数 
   * dd if=/dev/zero of=560_file count=1 bs=560M
        * 从/dev/zero取出一个大小为560MB的数据开，然后保存为560_file文件
   * dd if=/dev/cdrom of=RHEL-server-7.0-x86_64-LinuxProbe.Com.iso
        * dd 命令来压制出光盘镜像文件，将它变成一个可立即使用的 iso 镜像
* file命令用于查看文件类型
    * file xxx/xxx
    * file xxx
## 打包压缩和搜索命令
* tar 对文件进行打包和解压
    * -c 创建压缩文件
    * -x 解开压缩文件
    * -t 查看压缩包内有哪些文件
    * -z 用 Gzip 压缩或解压
    * -j 用 bzip2 压缩或解压
    * -v 显示压缩或解压的过程
    * -f 目标文件名
    * -p 保留原始的权限与属性
    * -P 使用绝对路径来压缩
    * -C 指定解压到的目录      
    * 一般使用“tar -czvf 压缩包名称.tar.gz 要打包的目录”命令把指定的文件进行打包压缩；相应的解压命令为“tar -xzvf 压缩 包名称.tar.gz”
* grep命令用于在文本中执行关键词搜索，并显示匹配的结果
    * -b 将可执行文件（binary）当作文本文件（text）来搜索
    * -c 仅显示找到的行数
    * -i 忽略大小写
    * -n 显示行号
    * -v 反向选择—仅列出没有“关键词”的行
* find 用于按照指定条件来查找文件
    * -name 匹配名称
    * -perm 匹配权限（mode 为完全匹配，-mode 为包含即可）
    * -user 匹配所有者
    * -group 匹配所有组
    * -mtime -n +n 匹配修改内容的时间（-n 指 n 天以内，+n 指 n 天以前）
    * -atime -n +n 匹配访问文件的时间（-n 指 n 天以内，+n 指 n 天以前）
    * -ctime -n +n 匹配修改文件权限的时间（-n 指 n 天以内，+n 指 n 天以前）
    * -nouser 匹配无所有者的文件
    * -nogroup 匹配无所有组的文件
    * -newer f1 !f2 匹配比文件 f1 新但比 f2 旧的文件
    * --type b/d/c/p/l/f  匹配文件类型（后面的字母参数依次表示块设备、目录、字符设备、管道、链接文件、文本文件）
    * -size 匹配文件的大小（+50KB 为查找超过 50KB 的文件，而-50KB 为查找小于50KB 的文件）
    * -prune 忽略某个目录
    * -exec …… {}\; 后面可跟用于进一步处理搜索结果的命令（下文会有演示）
## 管道符
* 输入输出重定向
    * 标准输入重定向（STDIN，文件描述符为 0）：默认从键盘输入，也可从其他文件或命
    令中输入。
        * 命令 < 文件 将文件作为命令的标准输入
        * 命令 << 分界符 从标准输入中读入，直到遇见分界符才停止
        * 命令 < 文件 1 > 文件 2 将文件 1 作为命令的标准输入并将标准输出到文件 2
    * 标准输出重定向（STDOUT，文件描述符为 1）：默认输出到屏幕。
        * 命令 > 文件 将标准输出重定向到一个文件中（清空原有文件的数据）
        * 命令 2> 文件 将错误输出重定向到一个文件中（清空原有文件的数据）
        * 命令 >> 文件 将标准输出重定向到一个文件中（追加到原有内容的后面）
        * 命令 2>> 文件 将错误输出重定向到一个文件中（追加到原有内容的后面）
        * 命令 >> 文件 2>&1 或命令 &>> 文件将标准输出与错误输出共同写入到文件中（追加到原有内容的后面）
    * 错误输出重定向（STDERR，文件描述符为 2）：默认输出到屏幕
* 管道符 执行格式为命令A|命令B，管道命令符的作用是把前面一个命令的标准正常数据当作后一个命令的标准输入
* 命令行的通配符
    * ？代表匹配单个字符
    * * 代表匹配零个或者多个字符
    * [0-9]代表匹配0~9之间的单个数字的字符，而中括号内加上字符[abc]表示匹配a、b、c三个字母中的任意一个
* 常用的转义字符    
    * \ 使反斜杠后面的一个变量变为单纯的字符串 反斜杠
    * " 转义其中所有的变量为单纯的字符串 单引号
    * "" 保留其中的变量属性， 不进行转义处理 双引号
    * '' 把其中的命令执行后返回结果 反引号
* 重要的环境变量
    * 命令在Linux系统中分四个步骤
        * 判断用户是否以绝对路径或相对路径输入命令如果是的话直接执行
        * 检测用户输入的命令是否为别名命令，可以通过alias 别名=命令 unalias别名=命令
        * Bash解释器判断用户输入的是内部命令还是外部命令
        * 系统在多个路径中查找用户输入的命令文件，定义这些路径的变量叫做PATH，
        * 可以使用env命令查看所有的环境变量
## vim编辑器   
* vim中常用的命令
    * dd 删除（剪切）光标所在整行
    * 5dd 删除（剪切）从光标处开始的 5 行
    * yy 复制光标所在整行
    * 5yy 复制从光标处开始的 5 行
    * n 显示搜索命令定位到的下一个字符串
    * N 显示搜索命令定位到的上一个字符串
    * u 撤销上一步的操作
    * p 将之前删除（dd）或复制（yy）过的数据粘贴到光标后面
    * :w 保存
    * :q 退出
    * :q! 强制退出（放弃对文档的修改内容）
    * :wq! 强制保存退出
    * :set nu 显示行号
    * :set nonu 不显示行号
    * :命令 执行该命令
    * :整数 跳转到该行
    * :s/one/two 将当前光标所在行的第一个 one 替换成 two
    * :s/one/two/g 将当前光标所在行的所有 one 替换成 two
    * :%s/one/two/g 将全文中的所有 one 替换成 two
    * ?字符串 在文本中从下至上搜索该字符串
    * /字符串 在文本中从上至下搜索该字符串
    * a 是在光标的后一位切换为编辑模式
    * i 是在当前位置切换为编辑模式
    * o 是在光标的下一行创建一个空行
* 配置主机的名称
    * vim /etc/hostname
* 配置网卡信息
    * cd /etc/sysconfig/network-scripts
    * vim ifcfg-enoxxx
    * type 设备类型
    * 地址分配模式: BOOTPROTO=static
    * 网卡名称: NAME=
    * 是否启动ONBOOT=yes
    * IP地址: IPADDR=192.168.10.10
    * 子网掩码:NETMASK=255.255.255.0
    * 网关地址i:GATEWAY=
    * DNS地址 DNS1=
    * 然后使用ping命令检查是否ping通
* 配置Yum软件仓库
    *  进入到/etc/yum.repos.d目录中
* 编写shell脚本
    * #! 系统使用那种Shell解释器
    * # 注释 
    * 用法  
    ```jshelllanguage
              #！ /bin/zsh
              # For example 
              pwd
              ls
            ``` 