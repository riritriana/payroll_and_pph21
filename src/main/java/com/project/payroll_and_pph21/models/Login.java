package com.project.payroll_and_pph21.models;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor                   
public class Login {
    @Id
    @UuidGenerator // ini string acak atau kode acak 
    @Column(name = "user_id", length = 36, nullable = false)
    private String id;
    private String username;
    private String password;

}
