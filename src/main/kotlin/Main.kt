package ru.netology

fun SwitchOfTypes(nameOfType: String): String {
    val listOfComments: Array<String> = arrayOf(
        "count (integer) — число пользователей, которым понравилась запись;\n",
        "user_likes* (integer) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);\n",
        "can_like* (integer) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);\n",
        "can_publish* (integer) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).\n"
    )

    if (nameOfType == "integer" || nameOfType == "string" || nameOfType == "boolean") {
        return nameOfType
    }
    return nameOfType + listOfComments.contentToString()
}

data class Post(
    var postId: Int,
    val dateOfPublished: String = "07/21/2020",
    val title: String = "Запись на стене | Разработчикам",
    var page: Int,
    var listOnTheLeft: String,
    val nameFieldOfTheList: String = "Запись на стене",
    val descriptionFieldOfTheList: String = "Объект, описывающий запись на стене пользователя или сообщества, содержит следующие поля:",
    var fieldId: Int, //id самой табличной записи, не поста
    var fieldName: String,
    val fieldTypeDescription: String,
    var fieldType: String = ""
)

var arrayOfAllPosts: Array<Post> = emptyArray()

fun add(post: Post): Post {

    val lastPostId = arrayOfAllPosts.last().postId // получаем id самого последнего поста
    var newId = lastPostId + 1 //добавляем к нему 1
    post.postId = newId // обновляем значение в поле id нового поста
    arrayOfAllPosts += post // новый пост также записываем в текущий массив в конец
    return post // возращаем пост с новым id
}

fun main() {

    val post0 = Post(
        postId = 0,
        page = 1,
        listOnTheLeft = "Документация",
        fieldId = 0,
        fieldName = "Id",
        fieldTypeDescription = "Идентификатор записи.",
        fieldType = SwitchOfTypes("integer")
    )
    arrayOfAllPosts += post0

    val post1 = Post(
        postId = 1,
        page = 1,
        listOnTheLeft = "Документация",
        fieldId = 1,
        fieldName = "text",
        fieldTypeDescription = "Текст записи.",
        fieldType = SwitchOfTypes("string")
    )
    arrayOfAllPosts += post1

    val post2 = Post(
        postId = 2,
        page = 2,
        listOnTheLeft = "Документация",
        fieldId = 2,
        fieldName = "can_delete",
        fieldTypeDescription = "Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).\"",
        fieldType = SwitchOfTypes("boolean")
    )
    arrayOfAllPosts += post2

    val post3 = Post(
        postId = 3,
        page = 1,
        listOnTheLeft = "Документация",
        fieldId = 3,
        fieldName = "comments",
        fieldTypeDescription = "информация о комментариях к записи, объект с полями:",
        fieldType = SwitchOfTypes("object")
    )
    arrayOfAllPosts += post3

    println(arrayOfAllPosts.contentToString())

    val post4 = Post(
        postId = 0,
        page = 2,
        listOnTheLeft = "Документация",
        fieldId = 4,
        fieldName = "can_edit",
        fieldTypeDescription = "Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).\"",
        fieldType = SwitchOfTypes("boolean")
    )

    println(add(post4)) // -> id = 4
}

