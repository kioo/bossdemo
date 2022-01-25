package common.config.entry;

import lombok.Data;

import java.util.List;

@Data
public class BossConfigBean {
    private List<ConfigItem> hotCityList;
    private List<ConfigItem> work;
    private List<ConfigItem> experience;
    private BaseItem base;
}
