package com.doer.mraims.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class DateTimeSerializer extends JsonSerializer<DateTime> {
	
	private DateTimeFormatter dateFormat = DateTimeFormat.forPattern(Constant.DATE_FORMAT);

	@Override
	public void serialize(DateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		String formattedDate = dateFormat.print(date);
		gen.writeString(formattedDate);
	}
	
}