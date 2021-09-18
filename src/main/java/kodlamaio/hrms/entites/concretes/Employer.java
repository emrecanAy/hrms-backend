package kodlamaio.hrms.entites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper =false )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonType.class)
})
@Table(name="employers")
public class Employer extends User {
	
	@Column(name="company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name="web_address")
	@NotNull
	@NotBlank
	private String webAddress;
	
	@Column(name="phone_number")
	@NotNull
	@NotBlank
	private String phoneNumber;
	
	@Column(name = "is_confirm", columnDefinition = "boolean default false")
	@JsonIgnore
	private Boolean isConfirm;
	
	@Type(type = "json")
	@Column(columnDefinition = "json", name = "updated_data")
	private Employer updatedData;
	
	
}
