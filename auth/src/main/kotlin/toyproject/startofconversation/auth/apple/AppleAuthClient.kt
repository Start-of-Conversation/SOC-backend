package toyproject.startofconversation.auth.apple

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import toyproject.startofconversation.auth.apple.dto.ApplePublicKeyResponse

@FeignClient(name = "appleAuthClient", url = "\${social.apple.auth.public-key-url}")
interface AppleAuthClient {

    @GetMapping
    fun getAppleAuthPublicKey() : ApplePublicKeyResponse
}