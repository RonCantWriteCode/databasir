## 文档导出

Databasir 支持多种类型的文档格式导出，该功能位于文档详情页面to，通过项目列表中点击指定项目的**查看文档**进入

![](img/project-export1.png)

进入文档页面以后，鼠标指向**导出**按钮即可显示出目前支持的文档导出格式

![](img/project-export2.png)

## 版本差异对比

如果成功同步了多个版本的文档，你可以随意的选择版本进行差异对比。

在文档页面，点击**显示版本差异**按钮

![](img/doc-diff1.png)

启用以后会出现一个对比版本的下拉框，选择我们要对比的版本，默认情况下基础版本是最新的，也就是在对比新版本比老版本有什么变化

![](img/doc-diff2.png)

选中版本以后就自动出现了差异标记

- 绿色：标识新增
- 红色：标识删除
- 黄色：标识修改
- 灰色：标识无变化

![](img/doc-diff3.png)

比如下图

- 删除了 document_remark 表
- 修改了 table_column_document、table_document 表
- 新增了 table_foreign_key_document 表

![](img/doc-diff4.png)

切换到修改表的地方，可以查看具体的修改内容，比如下图就展示了

- type 字段的类型由 text 改为了 varchar
- comment 字段的类型由 text 改为了 varchar

![](img/doc-diff5.png)

## 自定义文档模板（即将废弃）

目前 Databasir 的文档主要是以表格形式进行内容展示，包括了以下内容

- 表信息
- 列信息
- 索引信息
- 外键信息
- 触发器信息

这其中除了表信息以外，其他的表格内容都支持自定义表头（默认表头为英文）。

该操作需要拥有系统管理员权限，操作之前需要注意表格头名称的更改是全局的，即所有的项目都会生效。

页面入口位于侧边菜单栏的**文档模板**

![](img/template-edit1.png)

点击就会跳转编辑页面，就能跳转入模板的编辑页。

注意我用红框框起来的表头，这些都是可以编辑的

![](img/template-edit2.png)

比如我们将 Columns 的 `名称` 改为 `列名称` ，只需要点击表头输入新的名称，按下回车即可保存

![](img/template-edit3.png)

回到项目文档页面就可以看见我们做的变更生效了（没生效的话记得重新登陆试一下）

![](img/template-edit4.png)