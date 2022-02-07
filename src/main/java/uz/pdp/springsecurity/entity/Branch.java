package uz.pdp.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.pdp.springsecurity.entity.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "branches")
@AllArgsConstructor
@NoArgsConstructor
public class Branch extends AbsEntity {
    @Column(nullable = false)
    private String name;

    @OneToOne
    private Address address;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Business business;
}
