package com.wzw;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Freemarker静态页面化技术
 * @Author: wzw
 * @Date: 2020/11/15 9:33
 * @version: 1.8
 */
public class CreateFreemarkerHtml {
    public static void main(String[] args) throws Exception {
            //第一步：创建一个 Configuration 对象，直接 new 一个对象。构造方法的参数就是 freemarker的版本号。
            Configuration configuration = new Configuration(Configuration.getVersion());

            //第二步：设置模板文件所在的路径,不需要加文件名。(这里有编译时异常==>要try)==>修改点
            configuration.setDirectoryForTemplateLoading(new File("D:\\wzw_Projects\\My_Freemaker\\MyFreemakerMode\\src\\main\\resources"));

            //第三步：设置模板文件使用的字符集。一般就是 utf-8。
            configuration.setDefaultEncoding("utf-8");

            //第四步：加载一个模板，创建一个模板对象。(这里有编译时异常==>要try)==>修改点
            Template template = configuration.getTemplate("test.ftl");

            //第五步：创建一个模板使用的数据集，可以是 pojo 也可以是 map。一般是 Map。==>修改点
            //返回数据的map
            Map map = new HashMap();

            //${显示的值}
            map.put("name","张三");
            //${显示的值}
            map.put("message","小可爱");

            //if判断要的值
            map.put("success", true);

            //list循环,还是要map返回值
            List goodsList = new ArrayList();
            //循环内容1
            Map goods1=new HashMap();
            goods1.put("name", "苹果");
            goods1.put("price", 5.8);
            //循环内容2
            Map goods2=new HashMap();
            goods2.put("name", "香蕉");
            goods2.put("price", 2.5);
            //循环内容3
            Map goods3=new HashMap();
            goods3.put("name", "橘子");
            goods3.put("price", 3.2);
            //添加到list集合中
            goodsList.add(goods1);
            goodsList.add(goods2);
            goodsList.add(goods3);
            //添加到返回的map中
            map.put("goodsList",goodsList);

            //第六步：创建一个 Writer 对象，一般创建 FileWriter 对象，指定生成的文件名。(这里有编译时异常==>要try)==>修改点
            FileWriter out = new FileWriter(new File("D:\\wzw_Projects\\My_Freemaker\\MyFreemakerMode\\src\\main\\MyFreemarkerHtml\\test.html"));

            //第七步：调用模板对象的 process 方法输出文件。(这里有编译时异常==>要try)
            template.process(map,out);

            //第八步：关闭流。(这里有编译时异常==>要try)
            out.flush();
            out.close();

        }
}
