package cn.itcast.demo4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        // 1.开始创建xml解析器对象
        SAXReader reader = new SAXReader();
        try {
            // 2.让解析器对象去解析xml文件
            Document document = reader.read(Demo1.class.getClassLoader().getResourceAsStream("employees.xml"));
            // 3.开始获得内容
            Element root = document.getRootElement();//获得根节点对象
            Element employee = root.element("employee");//第一个employee
            Element name = employee.element("name");
            String text = name.getText();// 获得name标签中的文本
            System.out.println("text = " + text);
            System.out.println("----------");
            List<Element> employees =root.elements("employee");// 获得多个Element对象
            for (Element element : employees) {
                Element name1 = element.element("name");
                String text1 = name1.getText();
                System.out.println("text1 = " + text1);
            }

            System.out.println("-----------");
            Element employee1 = root.element("employee");// 第一个employee
            Attribute id = employee1.attribute("id");// 根据属性名获得属性对象
            String value = id.getValue();
            System.out.println("value = " + value);

            List<Element> employees1 =root.elements("employee");
            for (Element element : employees1) {
                Attribute id1 = element.attribute("id");
                String value1 = id1.getValue();
                System.out.println("value1 = " + value1);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
