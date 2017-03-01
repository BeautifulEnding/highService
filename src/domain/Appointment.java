package domain;

import javax.persistence.*;

@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@Column(name="app_id")
	private Integer id;
	//“约” 关键词
	@Column(name="app_name")
	private String name;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int hashCode()
	{
		return 0;
	}

	public boolean equals(Object obj)
	{
		return false;
	}
}
