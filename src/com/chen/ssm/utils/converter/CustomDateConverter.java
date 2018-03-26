package com.chen.ssm.utils.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义的时间转换器
 * @author JD
 *
 */
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			// 将String转成Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
