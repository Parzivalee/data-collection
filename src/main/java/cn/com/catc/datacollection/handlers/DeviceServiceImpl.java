package cn.com.catc.datacollection.handlers;

import cn.com.catc.datacollection.entity.devices.*;
import cn.com.catc.datacollection.utils.FileUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Description 设备JSON文件处理类
 * @Author lwj
 * @Date 2019/7/15
 * @Version 1.0
 **/
@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final String DEVICESPATH = "devicesPath";
    private static final String SERVERSPATH = "serversPath";
    private static final String MANAGEPATH = "managePath";
    private static final String RESOURCEPATH = "resourcePath";
    private static final String SYSTEMPATH = "systemPath";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Executor executor;

    @Async
    public void fileHandler(String filePath, List<String> jsonFiles) {
        System.out.println("工作线程：" + Thread.currentThread().getName());
        System.out.println("开始处理时间：" + dateFormat.format(new Date()));
        System.out.println(jsonFiles.size());
        jsonFiles.parallelStream().forEach(json -> {
            if (json != null)
                this.jsonHandler(json);
        });
        System.out.println("结束处理时间：" + dateFormat.format(new Date()));

    }

    public void jsonHandler(String jsonPath) {
        switch (FileUtils.getFileName(jsonPath)) {
            case "cpu":
                Cpu cpu = new Cpu();
                try {
                    //将json转对象
                    String jsonContent = FileUtils.readFileByLines(jsonPath);
                    JSONArray jsonArray = JSONArray.parseArray(jsonContent);
                    int size = jsonArray.size();
                    String filePath = FileUtils.getFileName(jsonPath);
                    //遍历Json
                    for (int i = 0; i < size; i++) {
                        //对象赋值及insert
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        cpu.setCpuindex(Integer.parseInt(jsonObject.getString("index")));
                        cpu.setValue(Double.parseDouble(jsonObject.getString("value")));

                        cpu.setUpdateTime(new Date());
                        //保存至Redis
                        redisTemplate.opsForValue().set(jsonPath, cpu);
                    }
                } catch (Exception e) {
                    log.error("ERROR", e);
                }
                break;
            case "entity":
                Entity entity = new Entity();
                try {
                    //将json转对象
                    String jsonContent = FileUtils.readFileByLines(jsonPath);
                    JSONArray jsonArray = JSONArray.parseArray(jsonContent);
                    int size = jsonArray.size();
                    String filePath = FileUtils.getFileName(jsonPath);
                    //遍历Json
                    for (int i = 0; i < size; i++) {
                        //对象赋值及insert
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        //TODO
                        entity.setAreaid(Long.parseLong(jsonPath));
                        //TODO
                        entity.setIpadress(jsonPath);
                        entity.setPindex(Long.parseLong(jsonObject.getString("pindex")));
                        entity.setEntityindex(Long.parseLong(jsonObject.getString("index")));
                        entity.setClasstype(Integer.parseInt(jsonObject.getString("class")));
                        entity.setName(jsonObject.getString("name"));
                        entity.setDescr(jsonObject.getString("descr"));
                        entity.setAlias(jsonObject.getString("alias"));
                        entity.setVtype(jsonObject.getString("vtype"));
                        entity.setCin(jsonObject.getString("cin"));
                        entity.setRelpos(jsonObject.getString("relpos"));
                        entity.setHwr(jsonObject.getString("hwr"));
                        entity.setFwr(jsonObject.getString("fwr"));
                        entity.setSwr(jsonObject.getString("swr"));
                        entity.setSnum(jsonObject.getString("snum"));
                        entity.setMfg(jsonObject.getString("mfg"));
                        entity.setModel(jsonObject.getString("model"));
                        entity.setAsset(jsonObject.getString("asset"));

                        entity.setUpdateTime(new Date());
                        //保存至Redis
                        redisTemplate.opsForValue().set(jsonPath, entity);
                    }
                } catch (Exception e) {
                    log.error("ERROR", e);
                }
                break;
            case "ifvalue":
                IfValue ifValue = new IfValue();
                try {
                    //将json转对象
                    String jsonContent = FileUtils.readFileByLines(jsonPath);
                    JSONArray jsonArray = JSONArray.parseArray(jsonContent);
                    int size = jsonArray.size();
                    String filePath = FileUtils.getFileName(jsonPath);
                    //遍历Json
                    for (int i = 0; i < size; i++) {
                        //对象赋值及insert
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        //TODO
                        ifValue.setAreaid(Long.parseLong(jsonPath));
                        //TODO
                        ifValue.setIpadress(jsonPath);
                        try {
                            ifValue.setFluxin(Double.parseDouble(jsonObject.getString("fluxIn")));
                        } catch (Exception e) {
                            ifValue.setFluxin(null);
                        }
                        try {
                            ifValue.setFluxout(Double.parseDouble(jsonObject.getString("fluxOut")));
                        } catch (Exception e) {
                            ifValue.setFluxout(null);
                        }
                        try {
                            ifValue.setUcastin(Double.parseDouble(jsonObject.getString("ucastIn")));
                        } catch (Exception e) {
                            ifValue.setUcastin(null);
                        }
                        try {
                            ifValue.setUcastout(Double.parseDouble(jsonObject.getString("ucastOut")));
                        } catch (Exception e) {
                            ifValue.setUcastout(null);
                        }
                        try {
                            ifValue.setMcastin(Double.parseDouble(jsonObject.getString("mcastIn")));
                        } catch (Exception e) {
                            ifValue.setMcastin(null);
                        }
                        try {
                            ifValue.setMcastout(Double.parseDouble(jsonObject.getString("mcastOut")));
                        } catch (Exception e) {
                            ifValue.setMcastout(null);
                        }
                        try {
                            ifValue.setBcastin(Double.parseDouble(jsonObject.getString("bcastIn")));
                        } catch (Exception e) {
                            ifValue.setBcastin(null);
                        }
                        try {
                            ifValue.setBcastout(Double.parseDouble(jsonObject.getString("bcastOut")));
                        } catch (Exception e) {
                            ifValue.setBcastout(null);
                        }
                        try {
                            ifValue.setDiscardin(Double.parseDouble(jsonObject.getString("discardIn")));
                        } catch (Exception e) {
                            ifValue.setDiscardin(null);
                        }
                        try {
                            ifValue.setDiscardout(Double.parseDouble(jsonObject.getString("discardOut")));
                        } catch (Exception e) {
                            ifValue.setDiscardout(null);
                        }
                        try {
                            ifValue.setErrorin(Double.parseDouble(jsonObject.getString("errorIn")));
                        } catch (Exception e) {
                            ifValue.setErrorin(null);
                        }
                        try {
                            ifValue.setErrorout(Double.parseDouble(jsonObject.getString("errorOut")));
                        } catch (Exception e) {
                            ifValue.setErrorout(null);
                        }
                        try {
                            ifValue.setUnknownprotos(Double.parseDouble(jsonObject.getString("unknownProtos")));
                        } catch (Exception e) {
                            ifValue.setUnknownprotos(null);
                        }
                        try {
                            ifValue.setOpticalvoltage(Double.parseDouble(jsonObject.getString("opticalVoltage")));
                        } catch (Exception e) {
                            ifValue.setOpticalvoltage(null);
                        }
                        try {
                            ifValue.setOpticalbiascurrent(Double.parseDouble(jsonObject.getString("opticalBiasCurrent")));
                        } catch (Exception e) {
                            ifValue.setOpticalbiascurrent(null);
                        }
                        try {
                            ifValue.setOpticalrxpower(Double.parseDouble(jsonObject.getString("opticalRxPower")));
                        } catch (Exception e) {
                            ifValue.setOpticalrxpower(null);
                        }
                        try {
                            ifValue.setOpticaltxpower(Double.parseDouble(jsonObject.getString("opticalTxPower")));
                        } catch (Exception e) {
                            ifValue.setOpticaltxpower(null);
                        }
                        try {
                            ifValue.setIpv6fluxin(Double.parseDouble(jsonObject.getString("ipv6FluxIn")));
                        } catch (Exception e) {
                            ifValue.setIpv6fluxin(null);
                        }
                        try {
                            ifValue.setIpv6fluxout(Double.parseDouble(jsonObject.getString("ipv6FluxOut")));
                        } catch (Exception e) {
                            ifValue.setIpv6fluxout(null);
                        }
                        try {
                            ifValue.setTime(dateFormat.parse(DateFormat.getDateTimeInstance()
                                    .format(Long.parseLong(jsonObject.getString("time")))));
                        } catch (Exception e) {
                            ifValue.setTime(null);
                        }
                        try {
                            ifValue.setPhyindex(Long.parseLong(jsonObject.getString("phyIndex")));
                        } catch (Exception e) {
                            ifValue.setPhyindex(null);
                        }
                        try {
                            ifValue.setEntityindex(Long.parseLong(jsonObject.getString("entityIndex")));
                        } catch (Exception e) {
                            ifValue.setEntityindex(null);
                        }
                        try {
                            ifValue.setPorttype(Integer.parseInt(jsonObject.getString("portType")));
                        } catch (Exception e) {
                            ifValue.setPorttype(null);
                        }
                        try {
                            ifValue.setIfindex(Integer.parseInt(jsonObject.getString("ifIndex")));
                        } catch (Exception e) {
                            ifValue.setIfindex(null);
                        }
                        ifValue.setIfname(jsonObject.getString("ifname"));
                        ifValue.setIfalias(jsonObject.getString("ifAlias"));
                        ifValue.setIfdesc(jsonObject.getString("ifDesc"));
                        try {
                            ifValue.setAdminstatus(Integer.parseInt(jsonObject.getString("adminStatus")));
                        } catch (Exception e) {
                            ifValue.setAdminstatus(null);
                        }
                        try {
                            ifValue.setOperstatus(Integer.parseInt(jsonObject.getString("operStatus")));
                        } catch (Exception e) {
                            ifValue.setOperstatus(null);
                        }
                        try {
                            ifValue.setSpeed(Integer.parseInt(jsonObject.getString("speed")));
                        } catch (Exception e) {
                            ifValue.setSpeed(null);
                        }
                        try {
                            ifValue.setIftype(Integer.parseInt(jsonObject.getString("ifType")));
                        } catch (Exception e) {
                            ifValue.setIftype(null);
                        }
                        try {
                            ifValue.setIfmtu(Integer.parseInt(jsonObject.getString("ifMtu")));
                        } catch (Exception e) {
                            ifValue.setIfmtu(null);
                        }
                        ifValue.setIfphysaddress(jsonObject.getString("ifPhysAddress"));
                        ifValue.setIp(jsonObject.getString("ip"));
                        ifValue.setUpdateTime(new Date());

                        redisTemplate.opsForValue().set(jsonPath, ifValue);
                    }
                } catch (Exception e) {
                    log.error("ERROR", e);
                }
                break;
            case "interface":
                Interface interface1 = new Interface();
                try {
                    //将json转对象
                    String jsonContent = FileUtils.readFileByLines(jsonPath);
                    JSONArray jsonArray = JSONArray.parseArray(jsonContent);
                    int size = jsonArray.size();
                    String filePath = FileUtils.getFileName(jsonPath);
                    //遍历Json
                    for (int i = 0; i < size; i++) {
                        //对象赋值及insert
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        //TODO
                        interface1.setAreaid(Long.parseLong(jsonPath));
                        //TODO
                        interface1.setIpadress(jsonPath);
                        try {
                            interface1.setTime(dateFormat.parse(DateFormat.getDateTimeInstance()
                                    .format(Long.parseLong(jsonObject.getString("time")))));
                        } catch (Exception e) {
                            interface1.setTime(null);
                        }
                        try {
                            interface1.setPhyindex(Long.parseLong(jsonObject.getString("phyIndex")));
                        } catch (Exception e) {
                            interface1.setPhyindex(null);
                        }
                        try {
                            interface1.setEntityindex(Long.parseLong(jsonObject.getString("entityIndex")));
                        } catch (Exception e) {
                            interface1.setEntityindex(null);
                        }
                        try {
                            interface1.setPorttype(Integer.parseInt(jsonObject.getString("portType")));
                        } catch (Exception e) {
                            interface1.setPorttype(null);
                        }
                        try {
                            interface1.setIfindex(Integer.parseInt(jsonObject.getString("ifIndex")));
                        } catch (Exception e) {
                            interface1.setIfindex(null);
                        }
                        interface1.setIfname(jsonObject.getString("ifName"));
                        interface1.setIfalias(jsonObject.getString("ifAlias"));
                        interface1.setIfdesc(jsonObject.getString("ifDesc"));
                        try {
                            interface1.setAdminstatus(Integer.parseInt(jsonObject.getString("adminStatus")));
                        } catch (Exception e) {
                            interface1.setAdminstatus(null);
                        }
                        try {
                            interface1.setOperstatus(Integer.parseInt(jsonObject.getString("operStatus")));
                        } catch (Exception e) {
                            interface1.setOperstatus(null);
                        }
                        try {
                            interface1.setSpeed(Integer.parseInt(jsonObject.getString("speed")));
                        } catch (Exception e) {
                            interface1.setSpeed(null);
                        }
                        try {
                            interface1.setIftype(Integer.parseInt(jsonObject.getString("ifType")));
                        } catch (Exception e) {
                            interface1.setIftype(null);
                        }
                        try {
                            interface1.setIfmtu(Integer.parseInt(jsonObject.getString("ifMtu")));
                        } catch (Exception e) {
                            interface1.setIfmtu(null);
                        }
                        interface1.setIfphysaddress(jsonObject.getString("ifPhysAddress"));
                        interface1.setIp(jsonObject.getString("ip"));

                        interface1.setUpdateTime(new Date());

                        redisTemplate.opsForValue().set(jsonPath, interface1);
                    }
                } catch (Exception e) {
                    log.error("ERROR", e);
                }
                break;
            case "memory":
                Memory memory = new Memory();
                try {
                    //将json转对象
                    String jsonContent = FileUtils.readFileByLines(jsonPath);
                    JSONArray jsonArray = JSONArray.parseArray(jsonContent);
                    int size = jsonArray.size();
                    String filePath = FileUtils.getFileName(jsonPath);
                    //遍历Json
                    for (int i = 0; i < size; i++) {
                        //对象赋值及insert
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        try {
                            //TODO
                            memory.setAreaid(Long.parseLong(jsonPath));
                        } catch (Exception e) {
                            log.error("ERROR", e);
                        }
                        //TODO
                        memory.setIpadress(jsonPath);
                        try {
                            memory.setMemoryindex(Integer.parseInt(jsonObject.getString("index")));
                        } catch (Exception e) {
                            log.error("ERROR", e);
                        }
                        try {
                            memory.setValue(Double.parseDouble(jsonObject.getString("value")));
                        } catch (Exception e) {
                            log.error("ERROR", e);
                        }

                        memory.setUpdateTime(new Date());

                        redisTemplate.opsForValue().set(jsonPath, memory);
                    }
                } catch (Exception e) {
                    log.error("ERROR", e);
                }
                break;
            case "sys":
                Sys sys = new Sys();
                try {
                    //将json转对象
                    String jsonContent = FileUtils.readFileByLines(jsonPath);
                    JSONArray jsonArray = JSONArray.parseArray(jsonContent);
                    int size = jsonArray.size();
                    String filePath = FileUtils.getFileName(jsonPath);
                    //遍历Json
                    for (int i = 0; i < size; i++) {
                        //对象赋值及insert
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        try {
                            //TODO
                            sys.setAreaid(Long.parseLong(jsonPath));
                        } catch (Exception e) {
                            log.error("ERROR", e);
                        }
                        //TODO
                        sys.setIpadress(jsonPath);
                        try {
                            sys.setSysindex(Integer.parseInt(jsonObject.getString("index")));
                        } catch (Exception e) {
                            log.error("ERROR", e);
                        }
                        sys.setValue(jsonObject.getString("value"));
                        sys.setUpdateTime(new Date());

                        redisTemplate.opsForValue().set(jsonPath, sys);
                    }
                } catch (Exception e) {
                    log.error("ERROR", e);
                }
                break;
            case "vlan":
                Vlan vlan = new Vlan();
                try {
                    //将json转对象
                    String jsonContent = FileUtils.readFileByLines(jsonPath);
                    JSONArray jsonArray = JSONArray.parseArray(jsonContent);
                    int size = jsonArray.size();
                    String filePath = FileUtils.getFileName(jsonPath);
                    //遍历Json
                    for (int i = 0; i < size; i++) {
                        //对象赋值及insert
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        try {
                            //TODO
                            vlan.setAreaid(Long.parseLong(jsonPath));
                        } catch (Exception e) {
                            log.error("ERROR", e);
                        }
                        //TODO
                        vlan.setIpadress(jsonPath);
                        try {
                            vlan.setVlanindex(Integer.parseInt(jsonObject.getString("id")));
                        } catch (Exception e) {
                            log.error("ERROR", e);
                        }
                        vlan.setName(jsonObject.getString("name"));
                        try {
                            vlan.setStatus(Integer.parseInt(jsonObject.getString("status")));
                        } catch (Exception e) {
                            vlan.setStatus(null);
                        }
                        vlan.setPorts(jsonObject.getString("ports"));

                        vlan.setUpdateTime(new Date());

                        redisTemplate.opsForValue().set(jsonPath, vlan);
                    }
                } catch (Exception e) {
                    log.error("ERROR", e);
                }
                break;
            default:
                break;
        }
    }

}
