// Explanation: Create a mock ImagesResponse object and assign the dto list to its 'items' field,
// then mock imagesApi.getImagesByTag(...) to return that response.

package com.halulkin.gallery.data.repository

import com.halulkin.gallery.data.api.ImagesApi
import com.halulkin.gallery.data.api.dtos.ImageDto
import com.halulkin.gallery.data.api.dtos.ImagesResponse
import com.halulkin.gallery.data.api.dtos.MediaDto
import kotlinx.coroutines.test.runTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ImagesRepositoryImplTest {

    private lateinit var imagesApi: ImagesApi
    private lateinit var imagesRepository: ImagesRepositoryImpl

    // Example ImageDto
    private val mockImageDto = ImageDto(
        title = "Cat",
        link = "url1",
        media = MediaDto("url1"),
        dateTaken = "2023-10-01",
        description = "A cute cat",
        published = "2023-10-01T00\\:00\\:00Z",
        author = "Author",
        authorId = "authorId",
        tags = "cat"
    )

    @Before
    fun setUp() {
        imagesApi = mockk()
        imagesRepository = ImagesRepositoryImpl(imagesApi)
    }

    @Test
    fun `returns images on success`() = runTest {
        // Given
        val tag = "cat"
        val response = ImagesResponse(
            title = "Test Title",
            link = "someLink",
            description = "Description",
            modified = "2023-10-01T00\\:00\\:00Z",
            generator = "Generator",
            items = listOf(mockImageDto)
        )
        coEvery { imagesApi.getImagesByTag(tags = tag) } returns response

        // When
        val result = imagesRepository.getImagesByTag(tag)

        // Then
        assertEquals(1, result.size)
        assertEquals("Cat", result.first().title)
        assertEquals("url1", result.first().url)
        coVerify { imagesApi.getImagesByTag(tags = tag) }
    }

    @Test
    fun `throws exception on failure`() = runTest {
        // Given
        val tag = "dog"
        val exception = RuntimeException("Network error")
        coEvery { imagesApi.getImagesByTag(tags = tag) } throws exception

        // When - Then
        try {
            imagesRepository.getImagesByTag(tag)
        } catch (e: Exception) {
            assertTrue(e is RuntimeException)
            assertEquals("Network error", e.message)
        }
        coVerify { imagesApi.getImagesByTag(tags = tag) }
    }
}