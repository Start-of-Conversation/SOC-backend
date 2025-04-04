package toyproject.startofconversation.common.domain.cardgroup.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import toyproject.startofconversation.common.domain.cardgroup.entity.CardGroup

@Repository
interface CardGroupRepository : JpaRepository<CardGroup, String>{
}