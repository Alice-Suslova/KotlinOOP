package ru.netology

fun SwitchOfTypes (nameOfType : String) : String {
    val listOfComments : Array<String> = arrayOf(
    "count (integer) — число пользователей, которым понравилась запись;\n",
    "user_likes* (integer) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);\n",
    "can_like* (integer) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);\n",
    "can_publish* (integer) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).\n"
    )

    if(nameOfType == "integer" || nameOfType == "string" || nameOfType == "boolean") {
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
    var fieldId: Int, //id самой табличной записи
    var fieldName: String,
    val fieldTypeDescription: String,
    var fieldType: String = ""
)


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

    val post1 = Post(
        postId = 1,
        page = 1,
        listOnTheLeft = "Документация",
        fieldId = 1,
        fieldName = "text",
        fieldTypeDescription = "Текст записи.",
        fieldType = SwitchOfTypes("string")
    )

    val post2 = Post(
        postId = 2,
        page = 2,
        listOnTheLeft = "Документация",
        fieldId = 2,
        fieldName = "can_delete",
        fieldTypeDescription = "Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).\"",
        fieldType = SwitchOfTypes("boolean")
    )

    val post3 = Post(
        postId = 3,
        page = 1,
        listOnTheLeft = "Документация",
        fieldId = 3,
        fieldName = "comments",
        fieldTypeDescription = "информация о комментариях к записи, объект с полями:",
        fieldType = SwitchOfTypes("object")
    )

    println(post0)
    println(post1)
    println(post2)
    println(post3)


}
