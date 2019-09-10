package kr.co.saramin.lab.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Data
@Component
public class ClassicFunction {
	
	@Autowired
    ConfigurableApplicationContext ctx;
	
	public String getTagName(String tagStr){
		if(tagChk(tagStr))
			return tagStr.substring(tagStr.indexOf("<__")+3,tagStr.indexOf("__>"));
		else
			return "";
	}
	public Long getTagValLong(String tagStr){
		if((tagStr.split(">")).length>1){
			tagStr = tagStr.replaceAll("\\p{Z}", "");
			return Long.parseLong(tagStr.split(">")[1]);
		}
		else
			return (long) -1;
	}
	public int getTagValInt(String tagStr){
		if((tagStr.split(">")).length>1){
			tagStr = tagStr.replaceAll("\\p{Z}", "");
			return Integer.parseInt(tagStr.split(">")[1]);
		}
		else
			return -1;
	}
	public String getTagValStr(String tagStr,boolean whiteSpace){
		if((tagStr.split(">")).length>1){
			String str = tagStr.split(">")[1];
			
			//안녕　하세요 유니코드 특수 문자공백 제거 U+3000
			if(whiteSpace)
				str = str.replaceAll("\\p{Z}", "");
			
			return str;
		}
		return "";
	}
	
	
	public String getTagValStr(String tagStr){
		if((tagStr.split(">")).length>1){
			String str = tagStr.split(">")[1];
			return str;
		}
		return "";
	}

	public boolean tagChk(String tagStr){
		if(tagStr.indexOf("<__")==-1 || tagStr.indexOf("__>")==-1)
			return false;
		else 
			return true;
	}
	
}
