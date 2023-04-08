package com.sts.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String quest;

	@OneToMany(mappedBy = "id")
	private List<Options> option;

	public List<Options> getOption() {
		return option;
	}

	public void setOption(List<Options> option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Questions{" + "id=" + id + ", quest='" + quest + '\'' + '}';
	}

	public Questions() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}
}
