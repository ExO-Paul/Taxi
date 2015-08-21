/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.tc.taxi.controller.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pavel
 */
public class TaxiControllerRequest {

    private Map<TaxiParamName, Object> params;

    public TaxiControllerRequest() {
        params = new HashMap<TaxiParamName, Object>();
    }

    public TaxiControllerRequest(Map<TaxiParamName, Object> map) {
        params = map;
    }

    public Map<TaxiParamName, Object> getParams() {
        return params;
    }

    public void setParams(Map<TaxiParamName, Object> params) {
        this.params = params;
    }

    public void addParams(Map<TaxiParamName, Object> params) {
        this.params.putAll(params);
    }

    public Object getParam(TaxiParamName taxiParamName) {
        params.get(taxiParamName);
        return params.get(taxiParamName);
    }

public void addParam(TaxiParamName taxiParamName, Object parameter) {
        this.params.put(taxiParamName, parameter);
    }
    
    
}
