package com.kukkyva.springdatajpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name="guardianName",
                column = @Column(name = "Guardian_name")
        )
}

)
public class Guardian {
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
