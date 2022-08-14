package uz.al_jamoa.collections.link;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.al_jamoa.base.entity.BaseEntityID;

import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Link extends BaseEntityID {
    private String link;
    private int linkTypeCode;
}
