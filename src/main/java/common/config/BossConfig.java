package common.config;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import common.config.entry.BossConfigBean;

import java.io.*;

public class BossConfig {
    public String getConfigContent()  {
        InputStream is = this.getClass().getResourceAsStream("/bossconfig.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s="";
        String configContentStr = "";
        try {
            while((s=br.readLine())!=null) {
                configContentStr = configContentStr+s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configContentStr;
    }

    public BossConfigBean getConfigBean(){
        String configContent = this.getConfigContent();
        BossConfigBean bossConfigBean = JSONUtil.toBean(configContent, BossConfigBean.class);
        Console.log("获取配置文件成功");
        return bossConfigBean;
    }
    public static void main(String[] args) {
        BossConfig bc = new BossConfig();
        String configContent = bc.getConfigContent();
        System.out.println(configContent);
        BossConfigBean bossConfigBean = JSONUtil.toBean(configContent, BossConfigBean.class);
        System.out.println(bossConfigBean);
    }

}
