package com.carl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这是一个简单的controller
 * @author liqq
 *
 */
@RestController
@RequestMapping("/myController")
public class MyController {


	/**
	 * 获取js
	 * @return
	 */
	@PostMapping("getJSL")
	@ResponseBody
	public String getJSL(String home_url,String script) {
		
	//	script = "<script>var x=\"while@div@substr@setTimeout@26@window@9@5@03@location@cookie@String@l@dc@37@GMT@a@href@if@0@length@__jsl_clearance@4@toLowerCase@_phantom@var@f@challenge@1517192797@reverse@match@085@join@3@cd@Mon@catch@fromCharCode@charAt@firstChild@Path@createElement@document@Expires@29@innerHTML@addEventListener@__phantomas@i@eval@captcha@h@replace@x@https@Jan@for@try@r@2@function@18@return@1500@e@false@DOMContentLoaded@else@attachEvent@onreadystatechange\".replace(/@*$/,\"\").split(\"@\"),y=\"1a d=3d(){1(6.19||6.30){};1a 23,e='16=1d.20|14|';1a 1b=[3d(36){3f 32('c.26('+36+')')},(3d(){1a 34=2b.2a('2');34.2e='<11 12=\\\'/\\\'>36</11>';34=34.28.12;1a 3b=34.1f(/37?:\\\\/\\\\//)[14];34=34.3(3b.15).18();3f 3d(36){39(1a 31=14;31<36.15;31++){36[31]=34.27(36[31])};3f 36.21('')}})()];23=[[[3c+8]+[-~-~(+[])],(22+[]+[[]][~~[]])+[3c+8],(8+[[]][~~[]])+[(+[])],[3c+8]+[(+[])],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[(+[])],(8+[[]][~~[]])+[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]],(8+[[]][~~[]])+[3c+8],[3c+8]+[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]],(22+[]+[[]][~~[]])+[3c+8],(8+[[]][~~[]])+[(+[])],[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]],[3c+8]+[(+[])],[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+(8+[[]][~~[]]),(-~(+[])+[[]][~~[]])+[(+[])]+[17],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+(8+[[]][~~[]]),(7+[])+[(+[])]],[[(+[])]],[(-~(+[])+[[]][~~[]])+[(+[])]+[-~-~(+[])],(8+[[]][~~[]])+[(+[])],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+(22+[]+[[]][~~[]])],[[3c+8]],[[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[-~-~(+[])]],[[(+[])],[17],[17]],[[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]],[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[17],(-~(+[])+[[]][~~[]])+(-~(+[])+[[]][~~[]])+[17],(-~(+[])+[[]][~~[]])+[(+[])]+(7+[]),[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]+[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]],[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+(8+[[]][~~[]]),(22+[]+[[]][~~[]])+[3c+8],(8+[[]][~~[]])+(-~(+[])+[[]][~~[]]),[-~[(-~(+[])<<-~(+[]))]-~[(-~(+[])<<-~(+[]))]]+[-~-~(+[])-~[([(-~(+[])<<-~(+[]))]+~~![]>>(-~(+[])<<-~(+[])))]]]];39(1a 31=14;31<23.15;31++){23[31]=1b.1e()[(-~(+[])+[[]][~~[]])](23[31])};23=23.21('');e+=23;4('a.12=a.12.35(/[\\\\?|&]33-1c/,\\\'\\\')',40);2b.b=(e+';2c=24, 2d-38-3e 9:5:f 10;29=/;');};13((3d(){3a{3f !!6.2f;}25(41){3f 42;}})()){2b.2f('43',d,42);}44{2b.45('46',d);}\",z=0,f=function(x,y){var a=0,b=0,c=0;x=x.split(\"\");y=y||99;while((a=x.shift())&&(b=a.charCodeAt(0)-77.5))c=(Math.abs(b)<13?(b+48.5):parseInt(a,36))+y*c;return c},g=y.match(/\\b\\w+\\b/g).sort(function(x,y){return f(x)-f(y)}).pop();while(f(g,++z)-x.length){};eval(y.replace(/\\b\\w+\\b/g, function(y){return x[f(y,z)-1]}));</script>";
		// home_url = "http://www.gsxt.gov.cn";

		GetJSL getJSL = new GetJSL();
		String jsl;
		try {
			jsl = getJSL.getjsl(home_url, script);
		} catch (Exception e) {
			e.printStackTrace();
			jsl = e.getMessage();
		}
		return jsl;
	}
}
