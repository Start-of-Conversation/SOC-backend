package toyproject.startofconversation.common.domain.user.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import lombok.Builder
import lombok.Getter
import toyproject.startofconversation.common.base.BaseDateEntity
import toyproject.startofconversation.common.base.value.Domain
import toyproject.startofconversation.common.domain.auth.entity.Auth
import toyproject.startofconversation.common.domain.device.entity.Device
import toyproject.startofconversation.common.domain.user.entity.value.Role
import java.time.LocalDateTime

@Entity
@Table(name = "users")
@Getter
@Builder
class Users(

    @Email
    @Column(length = 30, nullable = false, unique = true)
    val email: String,

    @Column(length = 20, nullable = false)
    var nickname: String,

    var profile: String = "~/image/profiles/default_profile.png",

    @Enumerated(EnumType.STRING)
    val role: Role = Role.USER,

    var isDeleted: Boolean = false,

    var deletedAt: LocalDateTime?,

    @OneToMany
    val auths: MutableList<Auth> = mutableListOf(),

    @OneToMany
    val devices: MutableSet<Device> = mutableSetOf(),

    @OneToMany
    val likes: MutableList<Likes> = mutableListOf()

) : BaseDateEntity(Domain.USER)