package ru.netology
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun add() {

        var arrayOfAllPosts: Array<Post> = emptyArray()

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

        val lastPost = arrayOfAllPosts.last()
        val result = lastPost.postId
        
        assertEquals(1, result)

    }

   /* @Test
    fun update() {
    }*/
}