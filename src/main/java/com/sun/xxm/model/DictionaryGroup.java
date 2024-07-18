package com.sun.xxm.model;

    import com.mybatisflex.annotation.Table;
    import com.sun.xxm.utils.BaseEntity;
    import jakarta.persistence.Entity;
    import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table("dictionary_group")
public class DictionaryGroup extends BaseEntity {
    private String name;

    private String code;

    private Integer order;

    private String remark;

    private boolean isSystem;
}
