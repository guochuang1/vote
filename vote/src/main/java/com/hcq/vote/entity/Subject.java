package com.hcq.vote.entity;

import java.util.HashSet;
import java.util.Set;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Subject {
	private static int TYPE_SINGLE =1;   //单选
	private static int TYPE_MULTIPLE=2;  //多选
	
	private long id;
	private String title;
	private int type;
	private int version;  //是否有效
	private Set<Option>options = new HashSet<Option>();   //选项
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Set<Option> getOptions() {
		return options;
	}
	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	
	public void addOption(Option option){
		this.options.add(option);
		 option.setSubject(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + type;
		result = prime * result + version;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (id != other.id)
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		if (version != other.version)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", type=" + type + ", version=" + version + ", options="
				+ options + "]";
	}
}
