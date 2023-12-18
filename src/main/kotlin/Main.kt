package ru.netology

data class Post(
    val id: Int, val name: String, val type: String, val description: String
)

data class DifficultPost(
    val id: Int, val name: String, val type: String = "object", val description: String,
    val command: String = ""
)

val commandForComments: Array<String> = arrayOf(
    "count (integer) — число пользователей, которым понравилась запись;",
    "user_likes* (integer) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);",
    "can_like* (integer) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);",
    "can_publish* (integer) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может)."
)

object WallServise {


    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun likeById(id: Int) {
        for ((index, post) in posts.withIndex())
            println(posts[index])
    }

}


fun main() {

    val post0 = Post(
        0,
        "id",
        "Int",
        "Идентификатор записи."
    )

    val post1 = Post(
        1,
        "owner_id",
        "Int",
        "Идентификатор владельца стены, на которой размещена запись. В версиях API ниже 5.7 это поле называется to_id."
    )

    val post2 = Post(
        2,
        "text",
        "String",
        "Текст записи."
    )

    val post3 = Post(
        3,
        "signer_id",
        "Int",
        "Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;"
    )

    val post4 = Post(
        4,
        "post_type",
        "String",
        "Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest."
    )

    val post5 = Post(
        5,
        "can_pin",
        "Boolean",
        "Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может)."
    )

    val post6 = Post(
        6,
        "can_delete",
        "Boolean",
        "Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может)."
    )

    val post7 = Post(
        7,
        "can_edit",
        "Boolean",
        "Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может)."
    )

    val post8 = Post(
        8,
        "postponed_id",
        "Int",
        "Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере."
    )

    val post9 = Post(
        9,
        "marked_as_ads",
        "Boolean",
        "Информация о том, содержит ли запись отметку «реклама» (1 — да, 0 — нет)."
    )

    val post10 = DifficultPost(
        10,
        "comments",
        "object",
        "Информация о комментариях к записи, объект с полями:",
        ""
    )

    fun result(array: Array<String>): String {
        var str = "\n"
        for (str0 in array) {
            str += " $str0 \n"
        }
        return str
    }


    val post10WithCommands = post10.copy(
        id = 10,
        name = "comments",
        type = "object",
        description = "Информация о комментариях к записи, объект с полями:",
        command = result(commandForComments)
    )

    println(post0)
    println(post1)
    println(post2)
    println(post3)
    println(post4)
    println(post5)
    println(post6)
    println(post7)
    println(post8)
    println(post9)
    println(post10WithCommands)

    var allPosts = WallServise
    println(allPosts)


    val post11 = Post(
        0,
        "New",
        "Boolean",
        "1 — true, 0 — false"
    )

    val lastPost = add(allPosts, post11)
    println(lastPost)
}

fun add(allPosts: WallServise, newPost: Post) {
    val lastPost = allPosts.size
    var newPost.id = lastPost + 1

}
