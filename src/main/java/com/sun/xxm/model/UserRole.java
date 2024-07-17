package com.sun.xxm.model;

import com.mybatisflex.annotation.RelationManyToMany;
import com.mybatisflex.annotation.RelationOneToOne;
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
@Table(value="userrole")
public class UserRole extends BaseEntity {
    private  Long userId;
    private  Long roleId;

//    @RelationManyToMany(
//            joinTable = "userrole", // 中间表
//            selfField = "roleId", joinSelfColumn = "account_id",
//            targetField = "id", joinTargetColumn = "role_id")
//    private Role role;
}
