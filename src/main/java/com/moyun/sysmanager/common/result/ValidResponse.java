package com.moyun.sysmanager.common.result;

import java.util.HashMap;

public class ValidResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public ValidResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public ValidResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public ValidResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
