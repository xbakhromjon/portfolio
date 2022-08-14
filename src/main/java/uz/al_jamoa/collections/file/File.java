package uz.al_jamoa.collections.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.al_jamoa.base.entity.BaseEntityID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class File extends BaseEntityID {
    private String filePath;
    private String originalName;
    private String extention;
    private String generatedName;
    private Long size;
    private Boolean isActive = true;
}
