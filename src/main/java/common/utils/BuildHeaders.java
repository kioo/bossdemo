package common.utils;

import cn.hutool.core.util.IdUtil;

import java.util.*;

public class BuildHeaders {

    public static Map<String, String> buildBossHeader(Map<String, String> queryParams) {
        Map<String, String> headers = new HashMap<>();
        headers.put("authority", "www.zhipin.com");
        // todo 关注 可能需要动态变化
        headers.put("sec-ch-ua", " Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97");
        headers.put("sec-ch-ua-mobile", "?0");
        // todo 关注 动态生成
        headers.put("user-agent", getAgent());
        // todo 关注 可能需要动态生成格式
        String uuid = IdUtil.randomUUID();
        headers.put("traceId", uuid);
        headers.put("accept", "application/json, text/plain, */*");
        headers.put("x-requested-with", "XMLHttpRequest");
        // todo 从cookies 中获取
        headers.put("zp_token", queryParams.get("zp_token").replace("%7E%7E", "~~"));
        // todo 可能动态生成
        headers.put("x-anti-request-token", "d41d8cd98f00b204e9800998ecf8427e");
        // todo 关注 可能需要动态变化
        headers.put("sec-ch-ua-platform", "macOS");
        headers.put("sec-fetch-site", "same-origin");
        headers.put("sec-fetch-mode", "cors");
        headers.put("sec-fetch-dest", "empty");
        // todo 关注 可能需要动态变化
        headers.put("referer", "https://www.zhipin.com/web/frame/search/new");
        headers.put("accept-language", "application/json, text/plain, */*");
        headers.put("cookie", queryParams.get("cookie"));
        return headers;
    }

    public static String getAgent() {
        List<String> agents = new ArrayList<>();

        agents.add("Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; Nexus S Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        agents.add("Avant Browser/1.2.789rel1 (http://www.avantbrowser.com)");
        agents.add("Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/532.5 (KHTML, like Gecko) Chrome/4.0.249.0 Safari/532.5");
        agents.add("Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.310.0 Safari/532.9");

        Random rand = new Random();
        int index = rand.nextInt(agents.size());
        return agents.get(index);
    }
}

