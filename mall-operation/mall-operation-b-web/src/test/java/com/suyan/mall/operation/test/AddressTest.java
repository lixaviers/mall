package com.suyan.mall.operation.test;

import com.suyan.mall.operation.dao.AddressMapper;
import com.suyan.mall.operation.model.Address;
import com.suyan.mall.operation.model.AddressExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void update() {
        AddressExample example = new AddressExample();
        example.createCriteria().andAddressLevelNotEqualTo((byte) 1).andIdGreaterThan(3716);
        List<Address> addresses = addressMapper.selectByExample(example);
        for (Address address : addresses) {

            try {
                RestTemplate restTemplate = new RestTemplate();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
                map.add("search", address.getName());

                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

                ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://citycode.blacklife.cn/search/search.php", request, String.class);

                String body = responseEntity.getBody();
                String substring = body.substring(body.indexOf("省份编码") + 5, body.indexOf("省份编码") + 11);

                String substring1 = body.substring(body.indexOf("拼音：") + 3);
                String py = substring1.substring(0, substring1.indexOf("</div>"));
                String substring2 = substring1.substring(substring1.indexOf("城市编码：") + 5);
                String bm = substring2.substring(0, substring2.indexOf("</div>"));
                String substring3 = substring1.substring(substring1.indexOf("邮编：") + 3);
                String yb = substring3.substring(0, substring3.indexOf("</div>"));

                address.setPinyin(py);
                address.setAreaCode(bm);
                address.setZipCode(yb);
                addressMapper.updateByPrimaryKeySelective(address);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}