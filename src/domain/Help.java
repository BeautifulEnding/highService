package domain;

import javax.persistence.*;

@Entity
@Table(name="help")
public class Help {
	@Id
	@Column(name="help_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//帮助方向关键词
	@Column(name="help_name")
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
