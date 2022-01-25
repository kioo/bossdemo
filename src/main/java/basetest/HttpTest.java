package basetest;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpTest {
    public static void main(String[] args) {
        String requestUrl = "https://www.zhipin.com/wapi/zpitem/web/boss/search/geeks.json?page=2&keywords=java&tag=&city=101110100&gender=-1&experience=-1,-1&salary=-1,-1&age=-1,-1&schoolLevel=-1&applyStatus=-1&degree=201,201&switchFreq=0&geekJobRequirements=0&exchangeResume=0&viewResume=0&firstDegree=0&queryAnd=0&companyNamesForHunter=&companySearchTypeForHunter=0&source=1&cityCodeStr=&_=1642991019710";
        Map<String, String> headers = new HashMap<>();
        headers.put("authority", "www.zhipin.com");
        // todo 关注 可能需要动态变化
        headers.put("sec-ch-ua", " Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97");
        headers.put("sec-ch-ua-mobile", "?0");
        // todo 关注 动态生成
        headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36");
        // todo 关注 可能需要动态生成格式
        String uuid = IdUtil.randomUUID();
        headers.put("traceId", "2A79BAEC-9BD0-47DF-B2D6-2A2105137DA3");
        headers.put("accept", "application/json, text/plain, */*");
        headers.put("x-requested-with", "XMLHttpRequest");
        // todo 从cookies 中获取
        headers.put("zp_token", "V1QNMvE-b-21dgXdNtzRQRKC-27DnTxQ~~");
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
        headers.put("cookie", "lastCity=101110100; wd_guid=28d06ddf-ef18-4f2f-9650-9dac1606216d; historyState=state; _bl_uid=mnkt2yXhk5ex4yop7ly0anwfaF4a; __g=-; acw_tc=0b6e703616429906602417903e01a84fc62407853102e3f316b3cbc6573868; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1642671918,1642731793,1642922264,1642990660; __zp_stoken__=3ea8dADBgIGxGSBVAImk8Jw0ueGJUO30KdHENe1A1XxMSNwtke3lYehRVYiU5Szw6R25lE0IxOxF%2BJGcfLyU1Vitadkd%2FF395KzBYUBQ2PxpkCSExO0RMDxRSSTsDHANxBVdXZz9OTxhBZXw%3D; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1642990759; wt2=DK_CQACzNGKSahc7M__4i38pDMFj9PhrKbnw7gQa-u14I4Elzn1HNQeHxyCspHfqp5W-92QKBPw0Kkufz0rSMpA~~; __l=l=%2Fwww.zhipin.com%2Fweb%2Fboss%2Findex&r=&g=&s=3&friend_source=0&s=3&friend_source=0; zp_token=V1QNMvE-b-21dgXdNtzRQRKC-27DnTxQ%7E%7E; __c=1642990660; __a=96107207.1642559712.1642914782.1642990660.86.5.8.86");

        HttpRequest httpRequest = HttpRequest.get(requestUrl).headerMap(headers,true).timeout(20000);
        String resultBody = httpRequest.execute().body();
        Console.log(resultBody);
    }

}
