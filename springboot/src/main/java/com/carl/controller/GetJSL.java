package com.carl.controller;

import java.util.concurrent.TimeUnit;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.alibaba.fastjson.JSON;



public class GetJSL {
	
	private ScriptEngine engine;
	public GetJSL() {
        ScriptEngineManager manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("JavaScript");
    }
	public String run(String str){
        return str;
    }
	public String getjsl(String home_url,String Script) throws Exception{
		
		
		
		String cookie = null;
		String cookieContent = Script;
		try {
		
		cookieContent = cookieContent.replaceAll("<script>(.*)</script>[\\s\\S]*", "$1");
		cookieContent = cookieContent.replaceAll("try\\{eval", "try{setScript");
		cookieContent = "var script = '';function setScript(text){script = text;eval(text)}; function setTimeout(){};var window = {'_phantom':'','__phantomas':''};var document = {};document.createElement = function()"
				+ "{return {'innerHTML':'','firstChild':{'href':'" + home_url + "'}}};"
				+ "document.addEventListener = function(){};document.attachEvent = function(){};document.cookie = '';" + cookieContent;
		//ScriptEngineManager manager = new ScriptEngineManager();
		//ScriptEngine engine = manager.getEngineByName("javascript");
		//System.out.println("s2:"+cookieContent);
		engine.eval(cookieContent);
		String script = engine.get("script").toString();
		System.out.println("s3:" + script);
		engine.eval(script);
		//System.out.println("s4:"+script);
		TimeUnit.SECONDS.sleep(1);
		String methodName = script.replaceAll("var (.*)=function[\\s\\S]{3}setTimeout[\\s\\S]*", "$1");
		//System.out.println("s5:"+script);
		//System.out.println("s6:"+methodName);
		Invocable invoke = (Invocable) engine;
		invoke.invokeFunction(methodName);
		
		cookie = JSON.parseObject(JSON.toJSONString(engine.get("document"))).getString("cookie").replaceAll("(.*);Expires[\\s\\S]*", "$1");
		System.out.println("Cookie:"+cookie);
		return cookie;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
