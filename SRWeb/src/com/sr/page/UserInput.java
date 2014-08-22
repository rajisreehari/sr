package com.sr.page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sr.dao.ThingDto;
import com.sr.dao.UserDto;

public class UserInput extends UserDto {
	private String[] genderList = new String[] {"F", "M"};
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	
	public UserInput(){}
	
	public UserInput(UserDto userDto, List<ThingDto> things){
		super.setCreatedBy(userDto.getCreatedBy());
		super.setCreatedTime(userDto.getCreatedTime());
		super.setDateOfBirth(userDto.getDateOfBirth());
		super.setEnabled(userDto.getEnabled());
		super.setFirstName(userDto.getFirstName());
		super.setGender(userDto.getGender());
		super.setLastName(userDto.getLastName());
		super.setPassword(userDto.getPassword());
		super.setThings(things);
		super.setUpdatedBy(userDto.getUpdatedBy());
		super.setUpdatedTime(userDto.getUpdatedTime());
		super.setUserName(userDto.getUserName());
		super.setUserId(userDto.getUserId());
		super.setMainImagePath(userDto.getMainImagePath());
		super.setThumbImagePath(userDto.getThumbImagePath());
	}

	public String[] getGenderList() {
		return genderList;
	}
	
	public void setDateOfBirthInput(String dateOfBirth) throws ParseException {
		if(dateOfBirth == null || dateOfBirth.trim().length() <= 0){
			return;
		}
		Date date = format.parse(dateOfBirth);
		super.setDateOfBirth(date);
	}
	
	public String getDateOfBirthInput(){
		Date dateOfBirth = super.getDateOfBirth();
		if(dateOfBirth == null){
			return null;
		}
		return format.format(dateOfBirth);
	}
}
