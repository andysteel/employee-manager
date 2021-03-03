package com.gmail.andersoninfonet.employeemanager.monitoring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "custom")
@Component
public class CustomActuatorEndpoint {
    
    @ReadOperation
    public Map<String, String> customEndpoint(String name) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "value");
        map.put("name", name);
        return map;
    }
}
