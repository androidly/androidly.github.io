
- ### 完成备份
```
git init //初始化本地仓库 
git add source //将必要的文件依次添加，有些文件夹如npm install产生的node_modules由于路径过长不好处理，所以这里没有用`git add .`命令了，而是依次添加必要文件，如下图所示 
git commit -m "Blog Source Hexo" 
git branch hexo //新建hexo分支 
git checkout hexo //切换到hexo分支上 
git remote add origin git@github.com:yourname/yourname.github.io.git //将本地与Github项目对接 
git push origin hexo //push到Github项目的hexo分支上
```

- ### 另一终端完成clone和push更新
```
git clone -b hexo git@github.com:yourname/yourname.github.io.git //将Github中hexo分支clone到本地 
cd yourname.github.io //切换到刚刚clone的文件夹内 
npm install //注意，这里一定要切换到刚刚clone的文件夹内执行，安装必要的所需组件，不用再init hexo new post "new blog name" //新建一个.md文件，并编辑完成自己的博客内容 
git add source //经测试每次只要更新sorcerer中的文件到Github中即可，因为只是新建了一篇新博客 
git commit -m "XX" git push origin hexo //更新分支 
hexo d -g //push更新完分支之后将自己写的博客对接到自己搭的博客网站上，同时同步了Github中的master
```

- ### 不同终端愉快玩耍
```
git pull origin hexo //先pull完成本地与远端的融合 
hexo new post " new blog name" 
git add source 
git commit -m "XX" 
git push origin hexo 
hexo d -g
```



