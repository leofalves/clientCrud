package io.leofalves.clientCrud.dto;

import java.io.Serializable;
import java.time.Instant;

import io.leofalves.clientCrud.entities.Client;

public class ClientDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Instant birthDate;
	private String name;
	private String cpf;
	private Double income;
	private Integer children;
	
	public ClientDto() {
		
	}
		
	public ClientDto(Long id, Instant birthDate, String name, String cpf, Double income, Integer children) {
		this.id = id;
		this.birthDate = birthDate;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.children = children;
	}

	public ClientDto(Client client) {
		this.id = client.getId();
		this.birthDate = client.getBirthDate();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.income = client.getIncome();
		this.children = client.getChildren();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Integer getChildren() {
		return children;
	}
	public void setChildren(Integer children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ClientDto other = (ClientDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
