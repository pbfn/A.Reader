package com.pedro_bruno.areader.model

data class MUser(
    val id: String? = null,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
    val quote: String,
    val profession: String
) {
    fun toMap(): MutableMap<String, Any> = mutableMapOf(
        "user_id" to this.userId,
        "display_name" to this.displayName,
        "quote" to this.quote,
        "avatar_Url" to this.avatarUrl,
        "profession" to this.profession,
    )
}
