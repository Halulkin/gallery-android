package com.halulkin.gallery.domain.usecase

import com.halulkin.gallery.domain.model.Image
import com.halulkin.gallery.domain.repository.ImagesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetImagesByTagUseCaseTest {

    private lateinit var imagesRepository: ImagesRepository
    private lateinit var getImagesByTagUseCase: GetImagesByTagUseCase

    @Before
    fun setUp() {
        imagesRepository = mockk()
        getImagesByTagUseCase = GetImagesByTagUseCase(imagesRepository)
    }

    @Test
    fun `returns success when repository returns data`() = runTest {
        // Given
        val tag = "cat"
        val expected = listOf(Image("Cat Image", "url1"))
        coEvery { imagesRepository.getImagesByTag(tag) } returns expected

        // When
        val result = getImagesByTagUseCase(tag)

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expected, result.getOrNull())
        coVerify { imagesRepository.getImagesByTag(tag) }
    }

    @Test
    fun `returns failure when repository throws exception`() = runTest {
        // Given
        val tag = "dog"
        val exception = RuntimeException("Network error")
        coEvery { imagesRepository.getImagesByTag(tag) } throws exception

        // When
        val result = getImagesByTagUseCase(tag)

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
        coVerify { imagesRepository.getImagesByTag(tag) }
    }
}