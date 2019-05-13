package net.zhongli.tech.freemarker2word.common;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * @author LK
 * @create 2019/5/13 23:55
 **/
public class FreeMarket2Word {

    private Configuration cfg;

    public FreeMarket2Word() {
        cfg = new Configuration(Configuration.getVersion());
        cfg.setDefaultEncoding("utf-8");
    }

    /**
     * 创建word文件并且返回下载
     * @param basePagcagePath 模板所在路径
     * @param templateName 模板名称
     * @param dataMap 占位符对应键值
     * @param response
     * @throws IOException
     * @throws TemplateException
     */
    public void createWord(String basePagcagePath, String templateName, Map<String, Object> dataMap,
                            HttpServletResponse response) {
        cfg.setClassForTemplateLoading(this.getClass(), basePagcagePath);
        Template template = null;
        Writer writer = null;
        try {
            template = cfg.getTemplate(templateName);
            writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
            template.process(dataMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void createWord(String basePagcagePath, String templateName, Map<String, Object> dataMap,
                           String filePath) {
        cfg.setClassForTemplateLoading(this.getClass(), basePagcagePath);
        Template template = null;
        Writer writer = null;
        File file = new File(filePath);
        try {
            template = cfg.getTemplate(templateName);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            template.process(dataMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
